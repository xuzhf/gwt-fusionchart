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
package com.raisepartner.chartfusion.web.client.servletapi.xmlchart;

/**
 * This interface define default/common parameter name to send to 
 * chart servlet.
 * 
 * @author sebastien
 */
public interface ChartParamName {
        String CHART_TYPE                       = "chart_type";

        String DATE                             = "date";
        String BEGIN_DATE                       = "begin_date";
        String END_DATE                         = "end_date";
        
        String MAX_NUMBER_OF_SERIES 			= "max_number_of_series";
        
        String SESSION_ID                       = "session_id";
        String USER_ID                          = "user_id";
        
        String VALUE_TYPE                       = "value_type";
        String X_AXIS_TYPE                      = "x_axis_type";
        String Y_AXIS_TYPE                      = "y_axis_type";
}
