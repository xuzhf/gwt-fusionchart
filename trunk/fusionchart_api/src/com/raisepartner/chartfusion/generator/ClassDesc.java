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

import java.util.List;

import com.raisepartner.chartfusion.generator.metadata.MetaAttribute;
import com.raisepartner.chartfusion.generator.metadata.MetaNode;

public class ClassDesc {

    public String className;
    public String packageName;
    public String superType;
    public String nodeName;
    
    /**
     * List of MetaAttribute instances
     */
    public List<MetaAttribute> attributes;
    /**
     * List of ClassDesc
     */
    public List<MetaNode> subnodes;
    
    public boolean hasNodeName() {
        return nodeName != null;
    }
    
    public List<MetaAttribute> getAttributes() {
        return attributes;
    }
    public void setAttributes(List<MetaAttribute> attributes) {
        this.attributes = attributes;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public String getNodeName() {
        return nodeName;
    }
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
    public String getPackageName() {
        return packageName;
    }
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    public List<MetaNode> getSubnodes() {
        return subnodes;
    }
    public void setSubnodes(List<MetaNode> subnodes) {
        this.subnodes = subnodes;
    }
    public String getSuperType() {
        return superType;
    }
    public void setSuperType(String superType) {
        this.superType = superType;
    }
    
}
