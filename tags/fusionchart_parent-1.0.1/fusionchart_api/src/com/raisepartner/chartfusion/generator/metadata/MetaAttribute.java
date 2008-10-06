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

import com.raisepartner.chartfusion.generator.StringUtils;


public class MetaAttribute {
	public String name;
	public String type;
	public String rangeValue;
	public String description;
	
	public MetaAttribute() {
	}
	public MetaAttribute(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRangeValue() {
		return rangeValue == null ? "" : rangeValue;
	}
	public void setRangeValue(String rangeValue) {
		this.rangeValue = rangeValue;
	}
	public String getType() {
		return type == null ? "" : type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFirstUpperName() {
		return StringUtils.firstLetterUpper(name);
	}
	public String getUpperName() {
		return name.toUpperCase();
	}
	
	public String get70WrappedDescription() {
		if (description == null) {
			return "";
		}
		return StringUtils.wrap(description, 70, "\t * ");
	}
    public int hashCode() {
        return name.hashCode();
    }
    public boolean equals(Object o) {
        if (!(o instanceof MetaAttribute)) {
            return false;
        }
        MetaAttribute a = (MetaAttribute) o;
        return name.equals(a.name);
    }

}
