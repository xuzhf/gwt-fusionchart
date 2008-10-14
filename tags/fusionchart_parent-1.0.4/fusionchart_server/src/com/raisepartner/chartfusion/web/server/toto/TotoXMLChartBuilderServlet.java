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

package com.raisepartner.chartfusion.web.server.toto;

import com.raisepartner.chartfusion.api.bar2d.Bar2D;
import com.raisepartner.chartfusion.api.bar2d.Set;
import com.raisepartner.chartfusion.web.client.servletapi.toto.TotoChartType;
import com.raisepartner.chartfusion.web.client.servletapi.xmlchart.ChartType;
import com.raisepartner.chartfusion.web.server.xmlchartbuilder.MapParameterProvider;
import com.raisepartner.chartfusion.web.server.xmlchartbuilder.ParameterProvider;
import com.raisepartner.chartfusion.web.server.xmlchartbuilder.XMLChartBuilder;
import com.raisepartner.chartfusion.web.server.xmlchartbuilder.XMLChartBuilderServlet;

/**
 * This class is an example of Servlet providing XML data required for the 
 * chart building based on the FusionChart product. 
 * This examples contains an example of XMLChartBuilder.
 * 
 * @author S.Chassande-Barrioz
 */
public class TotoXMLChartBuilderServlet extends XMLChartBuilderServlet {

	private static final long serialVersionUID = 8847855115581995274L;

	public XMLChartBuilder getXMLChartBuilder(int chartType) {
		switch (chartType) {
		case ChartType.CHART_DEFAULT:
		case TotoChartType.MY_CHART_1:
		default:
			return new TotoChartXMLChartBuilder();
		}
	}
}

/**
 *  
 * @author sebastien
 */
class TotoChartXMLChartBuilder extends XMLChartBuilder {
	
	/**
	 * A main method to test xml produces by this XMlChart builder.
	 */
	public static void main(String[] args) {
		//add parameter
		ParameterProvider pp = new MapParameterProvider();
		//pp.setParameter("", 12);
		//...
		System.out.println(new TotoChartXMLChartBuilder().getXMLData(pp, pp));
	}
	
	public int getChartType() { return 0; }
	public String getRequestIdFromParameter(ParameterProvider pp) { return null;}

	private Set setValue(Bar2D chart, String label, String value) {
		Set s = chart.createSetNode();
		s.setLabel(label);
		s.setValue(value);
		return s;
	}
	
	public String getXMLData(
			ParameterProvider requestParameterProvider, 
			ParameterProvider sessionParamterProvider) {
		//here you can use 'requestParameterProvider' to access to servlet parameters
		//here you can use 'sessionParamterProvider' to access to session parameters
	
		//Build the chart
		Bar2D chart = new Bar2D();
		chart.setCaption("Monthly Sales Summary");
		chart.setSubCaption("For the year 2006");
		chart.setXAxisName("Month");
		chart.setYAxisName("Sales");
		chart.setNumberPrefix("$");
		setValue(chart, "Jan", "17400");
		setValue(chart, "Feb", "19800");
		setValue(chart, "Mar", "21800");
		setValue(chart, "Apr", "23800");
		setValue(chart, "May", "29600");
		setValue(chart, "Jun", "27600");
		setValue(chart, "Jul", "31800");
		setValue(chart, "Aug", "39700");
		setValue(chart, "Sep", "37800");
		setValue(chart, "Oct", "21900");
		setValue(chart, "Nov", "32900");
		setValue(chart, "Dec", "39800");
		
		//at the end, transform the Chart object into xml string
		return chart.toString();
	}
	
}