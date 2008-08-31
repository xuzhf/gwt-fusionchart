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
    public Map findCommonAttributes(Map chartName2rootNode) throws Exception {
        //format data
        HashMap nodeName2nocs = new HashMap();
        for (Iterator itChart = chartName2rootNode.entrySet().iterator(); itChart.hasNext();) {
            Map.Entry me = (Map.Entry) itChart.next();
            String chartName = (String) me.getKey();
            MetaNode rootNode = (MetaNode) me.getValue();
            debug(rootNode.toString());
            Set nodes = rootNode.getAllNodes();
            for (Iterator it = nodes.iterator(); it.hasNext();) {
                MetaNode mn = (MetaNode) it.next();
                NodeOfChart noc = new NodeOfChart(mn, chartName);
                List nocs = (List) nodeName2nocs.get(mn.nodeName);
                if (nocs == null) {
                    nocs = new ArrayList();
                    nodeName2nocs.put(mn.nodeName, nocs);
                }
                nocs.add(noc);
            }
        }
        //analyze
        Map nodeName2commonAttributes = new HashMap();
        for (Iterator it = nodeName2nocs.values().iterator(); it.hasNext();) {
            List nocs = (List) it.next();
            analyzeNOCS(nocs, nodeName2commonAttributes);
        }
        return nodeName2commonAttributes;
    }

    private void analyzeNOCS(List nocs, Map nodeName2commonAttributes) {

    	if (nocs.size() < 2) {
            return;
        }
        Set commonAttributes = new HashSet();
        Set commonSubNodes = new HashSet();
        //Take all attributes of the first
        NodeOfChart noc = (NodeOfChart) nocs.get(0);
        debug("* Analyzing node '" + noc.node.nodeName + "': ");
        Set subNodeNames = getNodeNames(noc.node.subnodes);
        debugCommons(noc, commonSubNodes);
        commonAttributes.addAll(noc.node.attributes);
        commonSubNodes.retainAll(subNodeNames);
        //Keep common attribtes with the rest
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
            for (Iterator it = commonAttributes.iterator(); it.hasNext();) {
                MetaAttribute ma = (MetaAttribute) it.next();
                debug("\t\t-" + ma.name);
            }
        } else {
            debug("* No common attributes between the nodes '" + noc.node.nodeName + "': ");
        }
        if (!commonSubNodes.isEmpty()) {
            debug("* Common sub nodes between the nodes '" + noc.node.nodeName + "': ");
            for (Iterator it = commonSubNodes.iterator(); it.hasNext();) {
                debug("\t\t-" + it.next());
            }
        } else {
            debug("* No common sub nodes between the nodes '" + noc.node.nodeName + "': ");
        }
    }

    private void debugCommons(NodeOfChart noc, 
            Set subNodeNames) {
        if (debug) {
            debug("\t-'" + noc.node.nodeName + "' is used in chart '" + noc.chartName + "'.");
            debug("\t  it has " +  noc.node.attributes.size() + " attribute(s)");
            for (Iterator it2 = noc.node.attributes.iterator(); it2.hasNext();) {
                MetaAttribute ma = (MetaAttribute) it2.next();
                debug("\t\t-" + ma.name);
            }
            debug("\t  it has " +  subNodeNames.size() + " sub node(s)");
            for (Iterator it2 = subNodeNames.iterator(); it2.hasNext();) {
                debug("\t\t-" +  it2.next());
            }
        }
    }

    private Set getNodeNames(List nodes) {
        HashSet res = new HashSet();
        for (Iterator iter = nodes.iterator(); iter.hasNext();) {
            MetaNode node = (MetaNode) iter.next();
            res.add(node.nodeName);
        }
        return res;
    }
}
