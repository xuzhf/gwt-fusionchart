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

import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;

import com.raisepartner.chartfusion.api.Node;
import com.raisepartner.chartfusion.api.StyledChart;
import com.raisepartner.chartfusion.generator.metadata.MetaAttribute;
import com.raisepartner.chartfusion.generator.metadata.MetaNode;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Generates Java API for building chart with fusionchart product. 
 * This generator 
 * 
 * @author S.Chassande-Barrioz
 */
public class JAPIGenerator extends VelocityHelper {

    public final static String TEMPLATE_GEN_DIR = "com/raisepartner/chartfusion/generator";

    /**
     * APIGenerator: <xls directory> [<output dir>]
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String xlsDir = null;
        if (args.length == 0) {
            xlsDir = ".";
        } else {
            xlsDir = args[0];
        }
        String outDir = args[1];
        if (args.length == 1) {
            outDir = ".";
        } else {
            outDir = args[1];
        }
        new JAPIGenerator().generate(new File(xlsDir), new File(outDir));
    }

    public JAPIGenerator() throws Exception{
        super();
        VMs.add(TEMPLATE_GEN_DIR);
        initVelocityEngine();
    }
    
    public void generate(File xlsDir, File outDir) throws Exception {
        XLSParser parser = new XLSParser();
        Map chartName2rootNode = parser.parseFiles(xlsDir);
        if (chartName2rootNode.isEmpty()) {
            return;
        }
        //find common attributes between nodes
        Map nodeName2commonAttributes = new Analyzer().findCommonAttributes(chartName2rootNode);
        //Build class descriptors
        List classDescs = computeClassDescriptor(chartName2rootNode, nodeName2commonAttributes);
        //generate
        List l = new ArrayList(chartName2rootNode.keySet());
        Collections.sort(l);
        info("JAPIGenerator is generating " + classDescs.size() + " classes for chart " + l + ".");
        final String template = "node.vm";
        for (Iterator it = classDescs.iterator(); it.hasNext();) {
            generateFile(outDir, (ClassDesc) it.next(), template);
        }
        generateList(chartName2rootNode, outDir);
        info("JAPIGenerator: Done.");
    }

    private void generateList(Map chartName2rootNode, File outDir) throws Exception {
    	ClassDesc cd = new ClassDesc();
    	cd.packageName = "com.raisepartner.chartfusion.web.client";
    	cd.className = "FusionChartList";
    	List attributes = new ArrayList();
    	for (Iterator it = chartName2rootNode.keySet().iterator(); it.hasNext();) {
    		attributes.add(new MetaAttribute((String) it.next()));
		}
    	cd.setAttributes(attributes);
        generateFile(outDir, cd, "FusionChartList.vm");
    }
    
    private List computeClassDescriptor(Map chartName2rootNode, 
            Map nodeName2commonAttributes) {
        List classDescs = new ArrayList();
        //Common classes between chart
        final String apiPackageName = Node.class.getPackage().getName();
        for (Iterator it = nodeName2commonAttributes.entrySet().iterator(); it.hasNext();) {
            Map.Entry me = (Map.Entry) it.next();
            String nodeName = (String) me.getKey();
            Set commonAttributes = (Set) me.getValue();
            ClassDesc cd = new ClassDesc();
            cd.packageName = apiPackageName;
            cd.className = StringUtils.firstLetterUpper(nodeName);
            if ("chart".equals(nodeName) || "graph".equals(nodeName)) {
            	cd.superType = StyledChart.class.getName();
            } else {
            	cd.superType = Node.class.getName();
            }
            cd.nodeName = nodeName;
            cd.attributes = new ArrayList(commonAttributes);
            cd.subnodes = Collections.EMPTY_LIST;
            classDescs.add(cd);
        }
        //classes for each chart type
        for (Iterator it = chartName2rootNode.entrySet().iterator(); it.hasNext();) {
            Map.Entry me = (Map.Entry) it.next();
            String chartName = (String) me.getKey();
            MetaNode rootNode = (MetaNode) me.getValue();
            for (Iterator itNode = rootNode.getAllNodes().iterator(); itNode.hasNext();) {
                MetaNode node = (MetaNode) itNode.next();
                ClassDesc cd = new ClassDesc();
                cd.packageName = apiPackageName + "." + chartName.toLowerCase();
                if (node == rootNode) {
                    cd.className = StringUtils.firstLetterUpper(chartName);
                } else {
                    cd.className = StringUtils.firstLetterUpper(node.nodeName);
                }
                Set commonAttributes = (Set)  nodeName2commonAttributes.get(node.nodeName) ;
                if (commonAttributes == null) {
                    cd.superType = Node.class.getName();
                    cd.attributes = node.attributes;
                    cd.nodeName = node.nodeName;
                } else {
                    cd.nodeName = null;
                    cd.superType = apiPackageName + "." + StringUtils.firstLetterUpper(node.nodeName);
                    cd.attributes = new ArrayList(node.attributes);
                    cd.attributes.removeAll(commonAttributes);
                }
                cd.subnodes = node.subnodes;
                classDescs.add(cd);
            }
        }
        return classDescs;
    }
    
    
    private void generateFile(File outDir, ClassDesc cd, String templateName) throws Exception {
        Context ctx = new VelocityContext();
        ctx.put("cd", cd);
        File f = new File(outDir, cd.packageName.replace('.', '/')+ "/" + cd.className + ".java");
        f.getParentFile().mkdirs();
        FileWriter fw = new FileWriter(f);
        velocityEngine.getTemplate(TEMPLATE_GEN_DIR +"/" + templateName).merge(ctx, fw);
        fw.flush();
        fw.close();
        debug("File '" + f.getAbsolutePath() + "' generated.");
    }
}
