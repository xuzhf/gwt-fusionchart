/**
 * Copyright (c) 2008 Raise Partner
 * 22, av. Doyen Louis Weil,
 * 38000 Grenoble, France
 * All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * Contact: sebastien@chassande.fr
 */
package com.raisepartner.chartfusion.generator;

import com.raisepartner.chartfusion.generator.metadata.MetaAttribute;
import com.raisepartner.chartfusion.generator.metadata.MetaNode;
import com.raisepartner.chartfusion.generator.metadata.NodeOfChart;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Analyzes nodes hierachies in order to extract common attributes.
 * 
 * @author S.Chassande-Barrioz
 */
public class Analyzer extends Logger {

    public static void main(String[] args) throws Exception {
        String xlsDir = null;
        if (args.length == 0) {
            xlsDir = ".";
        } else {
            xlsDir = args[0];
        }
        new Analyzer().findCommonAttributes(new XLSParser().parseFiles(new File(xlsDir)));
    }
    
    /**
     * Computes common attributes between nodes.
     * @param chartName2rootNode is a map (chart name, MetaNode)
     * @return a map (node Name, Set(MetaAttribute))
     * @throws Exception
     */
    public Map<String,Set<MetaAttribute>> findCommonAttributes(Map<String,MetaNode> chartName2rootNode) throws Exception {
        //format data
        HashMap<String,List<NodeOfChart>> nodeName2nocs = new HashMap<String,List<NodeOfChart>>();
        for (Entry<String,MetaNode> me : chartName2rootNode.entrySet()) {
            String chartName = me.getKey();
            MetaNode rootNode = me.getValue();
            debug(rootNode.toString());
            Set<MetaNode> nodes = rootNode.getAllNodes();
            for (MetaNode mn : nodes) {
                NodeOfChart noc = new NodeOfChart(mn, chartName);
                List<NodeOfChart> nocs = nodeName2nocs.get(mn.nodeName);
                if (nocs == null) {
                    nocs = new ArrayList<NodeOfChart>();
                    nodeName2nocs.put(mn.nodeName, nocs);
                }
                nocs.add(noc);
            }
        }
        //analyze
        Map<String,Set<MetaAttribute>> nodeName2commonAttributes = new HashMap<String,Set<MetaAttribute>>();
        for (List<NodeOfChart> nocs : nodeName2nocs.values()) {
            analyzeNOCS(nocs, nodeName2commonAttributes);
        }
        return nodeName2commonAttributes;
    }

    private void analyzeNOCS(List<NodeOfChart> nocs, Map<String,Set<MetaAttribute>> nodeName2commonAttributes) {

    	if (nocs.size() < 2) {
            return;
        }
        Set<MetaAttribute> commonAttributes = new HashSet<MetaAttribute>();
        Set<MetaNode> commonSubNodes = new HashSet<MetaNode>();
        //Take all attributes of the first
        NodeOfChart noc = (NodeOfChart) nocs.get(0);
        debug("* Analyzing node '" + noc.node.nodeName + "': ");
        Set<String> subNodeNames = getNodeNames(noc.node.subnodes);
        debugCommons(noc, subNodeNames);
        commonAttributes.addAll(noc.node.attributes);
        commonSubNodes.retainAll(subNodeNames);
        //Keep common attributes with the rest
        for (int i = 1; i < nocs.size(); i++) {
            noc = (NodeOfChart) nocs.get(i);
            subNodeNames = getNodeNames(noc.node.subnodes);
            debugCommons(noc, subNodeNames);
            if (!commonAttributes.isEmpty() && noc.node.attributes.isEmpty()) {
                warn("\t\tNo attributes found on node '" + noc.node.nodeName 
                		+ "' of the chart '" + noc.chartName + "' !!!");
            }
            commonSubNodes.retainAll(subNodeNames);
            commonAttributes.retainAll(noc.node.attributes);
        }
        if (!commonAttributes.isEmpty()) {
            nodeName2commonAttributes.put(noc.node.nodeName, commonAttributes);
            debug("* Common attributes between the nodes '" + noc.node.nodeName + "': ");
            for (MetaAttribute ma : commonAttributes) {
                debug("\t\t-" + ma.name);
            }
        } else {
            debug("* No common attributes between the nodes '" + noc.node.nodeName + "': ");
        }
        if (!commonSubNodes.isEmpty()) {
            debug("* Common sub nodes between the nodes '" + noc.node.nodeName + "': ");
            for (MetaNode mn : commonSubNodes) {
                debug("\t\t-" + mn);
            }
        } else {
            debug("* No common sub nodes between the nodes '" + noc.node.nodeName + "': ");
        }
    }

    private void debugCommons(NodeOfChart noc, 
            Set<String> subNodeNames) {
        if (debug) {
            debug("\t-'" + noc.node.nodeName + "' is used in chart '" + noc.chartName + "'.");
            debug("\t  it has " +  noc.node.attributes.size() + " attribute(s)");
            for (MetaAttribute ma : noc.node.attributes) {
                debug("\t\t-" + ma.name);
            }
            debug("\t  it has " +  subNodeNames.size() + " sub node(s)");
            for (String name : subNodeNames) {
                debug("\t\t-" +  name);
            }
        }
    }

    private Set<String> getNodeNames(List<MetaNode> nodes) {
        HashSet<String> res = new HashSet<String>();
        for (MetaNode node : nodes) {
            res.add(node.nodeName);
        }
        return res;
    }
}
