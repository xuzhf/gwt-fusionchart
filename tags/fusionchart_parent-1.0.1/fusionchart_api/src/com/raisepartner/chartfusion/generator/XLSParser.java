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

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.raisepartner.chartfusion.generator.metadata.MetaAttribute;
import com.raisepartner.chartfusion.generator.metadata.MetaNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class XLSParser extends Logger {

    public Map parseFiles(File dir) throws Exception {
        File[] xlsFiles = dir.listFiles(new FilenameFilter() {
            public boolean accept(File d, String name) {
                return name.endsWith(".xls");
            }
        });
        if (xlsFiles == null) {
            System.err.println("No Xls file found in '" + dir.getAbsolutePath() + "'.");
            return Collections.EMPTY_MAP;
        } else {
            Map rootnodes = new HashMap();
            for (int i = 0; i < xlsFiles.length; i++) {
                String fn = xlsFiles[i].getName(); 
                String chartName = fn.substring(0, fn.length() - 4);
                rootnodes.put(chartName, parse(xlsFiles[i]));
            }
            return rootnodes;
        }        
    }
    
    
	public MetaNode parse(File file) throws Exception {
        debug("Parsing '" + file.getAbsolutePath() + "' ...");
		InputStream in = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(in));
		Map nodeName2MetaNode = new HashMap();
		try {
			parseAttribute(wb.getSheetAt(0), nodeName2MetaNode);
			return parseNode(wb.getSheetAt(1), nodeName2MetaNode);
		} catch (Exception e) {
			System.err.println("Error during the parsing of the xls file: '" + file.getAbsolutePath() + "':");
			throw e;
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
	
	private void parseAttribute(HSSFSheet sheet, Map nodeName2MetaNode) throws Exception {
		int idx = 1;
		while (true) {
			HSSFRow row = sheet.getRow(idx);
			if (row == null) {
				return;
			}
			String nodeOwner = getStringValue(row, 0, null);
			if (nodeOwner == null || nodeOwner.length() == 0) {
				return;
			}
			MetaNode node = getMetaNode(nodeOwner, nodeName2MetaNode);
			MetaAttribute att = new MetaAttribute();
			att.name = getStringValue(row, 1, null);
			if (att.name == null) {
				throw new Exception("Null attribute name on line " + (idx +1));
			}
			att.name = att.name.trim();
			att.type = getStringValue(row, 2, null);
			att.rangeValue = getStringValue(row, 3, null);
			att.description = getStringValue(row, 4, null);
			node.attributes.add(att);
			idx ++;
		}
	}
	private MetaNode parseNode(HSSFSheet sheet, Map nodeName2MetaNode) {
		int idx = 1;
		MetaNode rootNode = null;
		while (true) {
			HSSFRow row = sheet.getRow(idx);
			if (row == null) {
				return rootNode;
			}
			String parentNodeName = getStringValue(row, 0, null);
			String childNodeName = getStringValue(row, 1, null);
			if (parentNodeName == null || parentNodeName.length() == 0) {
				return rootNode;
			}
			MetaNode parentNode = getMetaNode(parentNodeName, nodeName2MetaNode);
			if (rootNode == null) {
				rootNode = parentNode;
			}
			MetaNode childNode = getMetaNode(childNodeName, nodeName2MetaNode);
			parentNode.subnodes.add(childNode);
			idx ++;
		}
	}
	private MetaNode getMetaNode(String nodeName, Map nodeName2MetaNode) {
		MetaNode n = (MetaNode) nodeName2MetaNode.get(nodeName);
		if (n == null) {
			n = new MetaNode(nodeName);
			nodeName2MetaNode.put(nodeName, n);
		}
		return n;
	}
	
    public String getStringValue(HSSFRow row, int col, String defaultValue) {
    	return getStringValue(row.getCell((short) col), defaultValue);
    }
	/**
	 * Extractes a String value from a cell
	 * @param cell is an XLS cell
	 * @param defaultValue is the default value returned if cell does not 
	 * contains data (null or empty String).
	 * @return a String instance or the default value
	 */
    public String getStringValue(HSSFCell cell, String defaultValue) {
    	if (cell == null) {
    		return defaultValue;
    	} else {
    		String s;
			try {
				s = cell.getStringCellValue();
			} catch (RuntimeException e) {
				return "" + cell.getNumericCellValue();
			}
    		if (s == null || s.length()== 0) {
        		return defaultValue;
    		} else {
    			return s;
    		}
    	}
    }
}
