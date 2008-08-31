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

import java.util.StringTokenizer;

public class StringUtils {

	public static String firstLetterUpper(String s) {
		return Character.toString(s.charAt(0)).toUpperCase() + s.substring(1);
	}

	public static String wrap(String str, int size, String linePrefix) {
		StringBuffer sb = new StringBuffer();
		final String delims = " -.:'/\\";
		StringTokenizer st = new StringTokenizer(str, delims, true);
		if (st.hasMoreElements()) {
			sb.append(linePrefix);
		}
		int currentLength = sb.length();
		while(st.hasMoreTokens()) {
			final String token = st.nextToken();
			final int tokenLength = token.length();
			if (tokenLength > size) {
				//Token is greater than the wrap size
				if (currentLength > 0) {
					sb.append("\n").append(linePrefix);
				}
				sb.append(token).append("\n");
				if (st.hasMoreTokens()) {
					sb.append(linePrefix);
				}
				currentLength = 0;
			} else {
				if ((currentLength + tokenLength) <= size) {
					sb.append(token);
					currentLength += tokenLength;
				} else {
					sb.append("\n").append(linePrefix);
					sb.append(token);
					currentLength = tokenLength;
				}
			}
		}
		return sb.toString();
	}

}
