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
package com.raisepartner.chartfusion.web.server.xmlchartbuilder;

import java.util.Date;

public abstract class StringParameterProvider implements ParameterProvider {


	public abstract void setParameter(String paramName, Object paramValue);

	public abstract String getStringParameter(String paramName);

	public Object getParameter(String paramName) {
		return getStringParameter(paramName);
	}

	public Long getLongParameter(String paramName) throws NumberFormatException {
		String  str = getStringParameter(paramName);
		if("null".equals(str)) {
			return null;
		}
		return Long.valueOf(str);
	}
	public Long getLongParameter(String paramName, Long defaultValue) {
		String  str = getStringParameter(paramName);
		if (str == null || str.trim().length()== 0) {
			return defaultValue;
		}
		if("null".equals(str)) {
			return null;
		}
		return Long.valueOf(str);
	}
	public Integer getIntegerParameter(String paramName, Integer defaultValue) {
		return getInteger(getStringParameter(paramName), defaultValue);
	}
	public Integer getInteger(String str, Integer defaultValue) {
		if (str == null || str.trim().length()== 0) {
			return defaultValue;
		}
		return Integer.valueOf(str);
	}
	public int getIntParameter(String paramName, int defaultValue) {
		String  str = getStringParameter(paramName);
		if (str == null || str.trim().length()== 0) {
			return defaultValue;
		}
		return Integer.parseInt(str);
	}
	public Date getDateParameter(String paramName, Date defaultValue) {
		Long l = getLongParameter(paramName, null);
		return l == null ? defaultValue : new Date(l.longValue());
	}
	
	public boolean getBooleanParameter(String paramName, boolean defaultValue) {
		String  str = getStringParameter(paramName);
		if (str == null || str.trim().length()== 0) {
			return defaultValue;
		}
		return Boolean.valueOf(str).booleanValue();
	}

}
