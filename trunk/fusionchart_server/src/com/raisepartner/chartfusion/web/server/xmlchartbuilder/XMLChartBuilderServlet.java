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

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raisepartner.chartfusion.web.client.servletapi.xmlchart.ChartParamName;
import com.raisepartner.chartfusion.web.client.servletapi.xmlchart.ChartType;

/**
 * Servlet retrieving xml content for the chart bulding on client side. 
 * Minimum servlet parameters are the following:
 * charttype : the type of chart (see ChartTypes)
 * userid : the identifier of the user (long value)
 * sessionid : identifier of the user session (long value)
 * 
 * @author S.Chassande-Barrioz
 */
public abstract class XMLChartBuilderServlet 
	extends HttpServlet 
	implements XMLChartBuilderFactory {

	private static final long serialVersionUID = -262595797687134902L;

	
	/**
	 * ParameterProvider encapsulating http paramters of a Http request.
	 * Setters operation does nothing !
	 * 
	 * @author S.Chassande-Barrioz
	 */
	public final static class HttpParameterProvider extends StringParameterProvider {
		private final HttpServletRequest req;
		public HttpParameterProvider(HttpServletRequest req) {
			this.req = req;
		}
		@Override
		public String getStringParameter(String paramName) {
			return req.getParameter(paramName);
		}
		@Override
		public void setParameter(String paramName, Object paramValue) {
		}
	}

    /**
     * The factory of XMLChartBuilder
     */
    private final XMLChartBuilderFactory chartBuilderFactory;
    
    
    public XMLChartBuilderServlet() {
    	chartBuilderFactory = getChartBuilderFactory();
    }
	
	@Override
	public void init() throws ServletException {
		super.init();
	}

	/**
	 * Retrieves the implementation of the XMLChartBuilderFactory. The default
	 * XMLChartBuilderFactory is this servlet. But if you override this method
	 * you can specify an external class.
	 */
	public XMLChartBuilderFactory getChartBuilderFactory() {
		return this;
	}

	/**
	 * Manges the get request.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//build an holder of request parameters
		HttpParameterProvider rpp = new HttpParameterProvider(req);
		//get the chart type from the request parameters
		int chartType = rpp.getIntParameter(ChartParamName.CHART_TYPE, ChartType.CHART_DEFAULT);
		// get a xml chart build for the chart type
		XMLChartBuilder xcb = chartBuilderFactory.getXMLChartBuilder(chartType);
		if (xcb == null) {
			throw new ServletException("No chart builder found for this type of chart"
					+ "\n\t- chart type: " + chartType
					+ "\n\t- ChartBuilderFactory: " + chartBuilderFactory);
		}
		String xmldata;
		//if (xmldata == null) {
		//xml data are not previously computed => do it now !
		xmldata = xcb.getXMLData(rpp, new HttpSessionParameterProvider(req.getSession()));
		if (xmldata == null) {
			throw new ServletException("No XML data built !");
		}
		// Write the response as xml
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
		out.write(xmldata);
		out.close();
	}
}
