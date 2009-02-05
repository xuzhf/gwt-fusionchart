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
package com.raisepartner.chartfusion.generator.metadata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.raisepartner.chartfusion.generator.StringUtils;

public class MetaNode {

	public String nodeName;
	public List<MetaAttribute> attributes = new ArrayList<MetaAttribute>();
	public List<MetaNode> subnodes = new ArrayList<MetaNode>();
	
	public MetaNode(String n) {
		nodeName = n;
	}

	public List<MetaAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<MetaAttribute> attributes) {
		this.attributes = attributes;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public List<MetaNode> getSubnodes() {
		return subnodes;
	}

	public void setSubnodes(List<MetaNode> subnodes) {
		this.subnodes = subnodes;
	}
	
	public String getFirstUpperNodeName() {
		return StringUtils.firstLetterUpper(nodeName);
	}
	public String getUpperNodeName() {
		return nodeName.toUpperCase();
	}
    public Set<MetaNode> getAllNodes() {
        HashSet<MetaNode> s = new HashSet<MetaNode>();
        getNodes(this, s);
        return s;
    }
    public Map<String,MetaNode> getAllNodesByName() {
        HashMap<String,MetaNode> m = new HashMap<String,MetaNode>();
        getNodes(this, m);
        return m;
    }
    
    public int hashCode() {
        return nodeName.hashCode();
    }
    public boolean equals(Object o) {
        if (!(o instanceof MetaNode)) {
            return false;
        }
        MetaNode n = (MetaNode) o;
        return nodeName.equals(n.nodeName) 
            && attributes.equals(n.attributes)
            && sameSubNodes(this, n)
            ;
    }
    private boolean sameSubNodes(MetaNode n1, MetaNode n2) {
    	if (n1.subnodes.size() != n2.subnodes.size()) {
    		return false;
    	}
    	for (int i = 0; i < n1.subnodes.size(); i++) {
			MetaNode sn1 = (MetaNode) n1.subnodes.get(i);
			MetaNode sn2 = (MetaNode) n2.subnodes.get(i);
			if (sn1 != n1) {
				if (!sn1.equals(sn2)) {
					return false;
				}
			}
		}
    	return true;
    }
    
    private static void getNodes(MetaNode n, Map<String, MetaNode> m) {
        m.put(n.nodeName, n);
        for (MetaNode sn : n.subnodes) {
        	if (sn != n) {
        		getNodes(sn, m);
        	}
        }
    }
    private static void getNodes(MetaNode n, Set<MetaNode> s) {
        s.add(n);
        for (MetaNode sn : n.subnodes) {
        	if (sn != n) {
        		getNodes(sn, s);
        	}
        }
    }
    /**
     * Builds the XML representation of the node.
     */
    public String toString() {
        return toString(new StringBuffer(), "").toString(); 
    }
    /**
     * Recursive method for building XML representation of the node
     * @param sb is the StringBuffer to fill with the representation of the 
     * current node. Must not be null.
     * @param tab is the tabulation prefix to insert at each line begin. Must 
     * not be null. 
     * @return the tab parameter.
     */
    private StringBuffer toString(StringBuffer sb, String tab) {
        final String innerTab = tab + "\t";
        sb.append(tab).append("<").append(nodeName);
        for (MetaAttribute ma : attributes) {
            sb.append(" ").append(ma.getName());
        }
        if (subnodes.isEmpty()) {
            sb.append("/>\n");
        } else {
            sb.append(">\n");
            for (MetaNode n : subnodes) {
                if (n != this) {
                	n.toString(sb, innerTab);
                }
            }
            sb.append(tab).append("</").append(nodeName).append(">\n");
        }
        return sb;
    }

}
