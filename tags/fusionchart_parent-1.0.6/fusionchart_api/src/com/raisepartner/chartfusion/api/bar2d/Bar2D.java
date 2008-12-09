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
package com.raisepartner.chartfusion.api.bar2d;

public class Bar2D extends com.raisepartner.chartfusion.api.Chart {

	public final static String PARAMETER_LABELDISPLAY = "labelDisplay";
	public final static String PARAMETER_ROTATELABELS = "rotateLabels";
	public final static String PARAMETER_SLANTLABELS = "slantLabels";
	public final static String PARAMETER_LABELSTEP = "labelStep";
	public final static String PARAMETER_STAGGERLINES = "staggerLines";
	public final static String PARAMETER_ROTATEVALUES = "rotateValues";
	public final static String PARAMETER_PLACEVALUESINSIDE = "placeValuesInside";
	public final static String PARAMETER_SHOWYAXISVALUES = "showYAxisValues";
	public final static String PARAMETER_SHOWLIMITS = "showLimits";
	public final static String PARAMETER_SHOWDIVLINEVALUES = "showDivLineValues";
	public final static String PARAMETER_YAXISVALUESSTEP = "yAxisValuesStep";
	public final static String PARAMETER_SHOWSHADOW = "showShadow";
	public final static String PARAMETER_ADJUSTDIV = "adjustDiv";
	public final static String PARAMETER_ROTATEYAXISNAME = "rotateYAxisName";
	public final static String PARAMETER_YAXISNAMEWIDTH = "yAxisNameWidth";
	public final static String PARAMETER_YAXISMINVALUE = "yAxisMinValue";
	public final static String PARAMETER_YAXISMAXVALUE = "yAxisMaxValue";
	public final static String PARAMETER_SETADAPTIVEYMIN = "setAdaptiveYMin";
	public final static String PARAMETER_XAXISNAME = "xAxisName";
	public final static String PARAMETER_YAXISNAME = "yAxisName";
	public final static String PARAMETER_CANVASBGCOLOR = "canvasBgColor";
	public final static String PARAMETER_CANVASBGALPHA = "canvasBgAlpha";
	public final static String PARAMETER_CANVASBGRATIO = "canvasBgRatio";
	public final static String PARAMETER_CANVASBGANGLE = "canvasBgAngle";
	public final static String PARAMETER_CANVASBORDERCOLOR = "canvasBorderColor";
	public final static String PARAMETER_CANVASBORDERTHICKNESS = "canvasBorderThickness";
	public final static String PARAMETER_CANVASBORDERALPHA = "canvasBorderAlpha";
	public final static String PARAMETER_USEROUNDEDGES = "useRoundEdges";
	public final static String PARAMETER_SHOWPLOTBORDER = "showPlotBorder";
	public final static String PARAMETER_PLOTBORDERCOLOR = "plotBorderColor";
	public final static String PARAMETER_PLOTBORDERTHICKNESS = "plotBorderThickness";
	public final static String PARAMETER_PLOTBORDERALPHA = "plotBorderAlpha";
	public final static String PARAMETER_PLOTBORDERDASHED = "plotBorderDashed";
	public final static String PARAMETER_PLOTBORDERDASHLEN = "plotBorderDashLen";
	public final static String PARAMETER_PLOTBORDERDASHGAP = "plotBorderDashGap";
	public final static String PARAMETER_PLOTFILLANGLE = "plotFillAngle";
	public final static String PARAMETER_PLOTFILLRATIO = "plotFillRatio";
	public final static String PARAMETER_PLOTFILLALPHA = "plotFillAlpha";
	public final static String PARAMETER_PLOTGRADIENTCOLOR = "plotGradientColor";
	public final static String PARAMETER_NUMDIVLINES = "numDivLines";
	public final static String PARAMETER_DIVLINECOLOR = "divLineColor";
	public final static String PARAMETER_DIVLINETHICKNESS = "divLineThickness";
	public final static String PARAMETER_DIVLINEALPHA = "divLineAlpha";
	public final static String PARAMETER_DIVLINEISDASHED = "divLineIsDashed";
	public final static String PARAMETER_DIVLINEDASHLEN = "divLineDashLen";
	public final static String PARAMETER_DIVLINEDASHGAP = "divLineDashGap";
	public final static String PARAMETER_ZEROPLANECOLOR = "zeroPlaneColor";
	public final static String PARAMETER_ZEROPLANETHICKNESS = "zeroPlaneThickness";
	public final static String PARAMETER_ZEROPLANEALPHA = "zeroPlaneAlpha";
	public final static String PARAMETER_SHOWALTERNATEHGRIDCOLOR = "showAlternateHGridColor";
	public final static String PARAMETER_ALTERNATEHGRIDCOLOR = "alternateHGridColor";
	public final static String PARAMETER_ALTERNATEHGRIDALPHA = "alternateHGridAlpha";
	public final static String PARAMETER_YAXISVALUEDECIMALS = "yAxisValueDecimals";
	public final static String PARAMETER_OUTCNVBASEFONT = "outCnvBaseFont";
	public final static String PARAMETER_OUTCNVBASEFONTSIZE = "outCnvBaseFontSize";
	public final static String PARAMETER_OUTCNVBASEFONTCOLOR = "outCnvBaseFontColor";
	public final static String PARAMETER_XAXISNAMEPADDING = "xAxisNamePadding";
	public final static String PARAMETER_YAXISNAMEPADDING = "yAxisNamePadding";
	public final static String PARAMETER_YAXISVALUESPADDING = "yAxisValuesPadding";
	public final static String PARAMETER_LABELPADDING = "labelPadding";
	public final static String PARAMETER_VALUEPADDING = "valuePadding";
	public final static String PARAMETER_PLOTSPACEPERCENT = "plotSpacePercent";

	public Bar2D() {
	}

	/**
	 * Type: String 
	 * Range value: WRAP, STAGGER, ROTATE or NONE 
	 * Description :
	 * Using this attribute, you can control how your data labels (x-axis
	 *  labels) would appear on the chart. There are 4 options: WRAP, 
	 * STAGGER, ROTATE or NONE. WRAP wraps the label text if it's longer than
	 *  the allotted area. ROTATE rotates the label in vertical or slanted 
	 * position. STAGGER divides the labels into multiple lines. 
	 */
	public void setLabelDisplay(String value) {
		setAttribute(PARAMETER_LABELDISPLAY, value);
	}

	/**
	 * Type: Boolean 
	 * Range value: 0/1 
	 * Description :
	 * This attribute lets you set whether the data labels would show up 
	 * as rotated labels on the chart. 
	 */
	public void setRotateLabels(String value) {
		setAttribute(PARAMETER_ROTATELABELS, value);
	}

	/**
	 * Type: Boolean 
	 * Range value: 0/1 
	 * Description :
	 * If you've opted to show rotated labels on chart, this attribute 
	 * lets you set the configuration whether the labels would show as 
	 * slanted labels or fully vertical ones. 
	 */
	public void setSlantLabels(String value) {
		setAttribute(PARAMETER_SLANTLABELS, value);
	}

	/**
	 * Type: Number 
	 * Range value: 1 or above 
	 * Description :
	 * By default, all the labels are displayed on the chart. However, if
	 *  you've a set of streaming data (like name of months or days of week),
	 *  you can opt to hide every n-th label for better clarity. This 
	 * attributes just lets you do so. It allows to skip every n(th) X-axis 
	 * label. 
	 */
	public void setLabelStep(String value) {
		setAttribute(PARAMETER_LABELSTEP, value);
	}

	/**
	 * Type: Number 
	 * Range value: 2 or above 
	 * Description :
	 * If you've opted for STAGGER mode as labelDisplay, using this 
	 * attribute you can control how many lines to stagger the label to. By 
	 * default, all labels are displayed in a single line. 
	 */
	public void setStaggerLines(String value) {
		setAttribute(PARAMETER_STAGGERLINES, value);
	}

	/**
	 * Type: Boolean 
	 * Range value: 0/1 
	 * Description :
	 * If you've opted to show data values, you can rotate them using 
	 * this attribute. 
	 */
	public void setRotateValues(String value) {
		setAttribute(PARAMETER_ROTATEVALUES, value);
	}

	/**
	 * Type: Boolean 
	 * Range value: 0/1 
	 * Description :
	 * If you've opted to show data values, you can show them inside the 
	 * columns using this attribute. By default, the data values show outside
	 *  the column. 
	 */
	public void setPlaceValuesInside(String value) {
		setAttribute(PARAMETER_PLACEVALUESINSIDE, value);
	}

	/**
	 * Type: Boolean 
	 * Range value: 0/1 
	 * Description :
	 * FusionCharts y-axis is divided into vertical sections using div 
	 * (divisional) lines. Each div line assumes a value based on its 
	 * position. Using this attribute you can set whether to show those div 
	 * line (y-axis) values or not. 
	 */
	public void setShowYAxisValues(String value) {
		setAttribute(PARAMETER_SHOWYAXISVALUES, value);
	}

	/**
	 * Type: Boolean 
	 * Range value: 0/1 
	 * Description :
	 * Whether to show chart limit values? showYAxisValues is the single 
	 * new attribute in v3 which over-rides this value. 
	 */
	public void setShowLimits(String value) {
		setAttribute(PARAMETER_SHOWLIMITS, value);
	}

	/**
	 * Type: Boolean 
	 * Range value: 0/1 
	 * Description :
	 * Whether to show div line values? showYAxisValues is the single new
	 *  attribute in v3 which over-rides this value. 
	 */
	public void setShowDivLineValues(String value) {
		setAttribute(PARAMETER_SHOWDIVLINEVALUES, value);
	}

	/**
	 * Type: Number 
	 * Range value: 1 or above 
	 * Description :
	 * By default, all div lines show their values. However, you can opt 
	 * to skip every x(th) div line value using this attribute. 
	 */
	public void setYAxisValuesStep(String value) {
		setAttribute(PARAMETER_YAXISVALUESSTEP, value);
	}

	/**
	 * Type: Boolean 
	 * Range value: 0/1 
	 * Description :
	 * Whether to show column shadows? 
	 */
	public void setShowShadow(String value) {
		setAttribute(PARAMETER_SHOWSHADOW, value);
	}

	/**
	 * Type: Boolean 
	 * Range value: 0/1 
	 * Description :
	 * FusionCharts automatically tries to adjust divisional lines and 
	 * limit values based on the data provided. However, if you want to set 
	 * your explicit lower and upper limit values and number of divisional 
	 * lines, first set this attribute to false. That would disable automatic
	 *  adjustment of divisional lines. 
	 */
	public void setAdjustDiv(String value) {
		setAttribute(PARAMETER_ADJUSTDIV, value);
	}

	/**
	 * Type: Boolean 
	 * Range value: 0/1 
	 * Description :
	 * If you do not wish to rotate y-axis name, set this as 0. It 
	 * specifically comes to use when you've special characters (UTF8) in 
	 * your y-axis name that do not show up in rotated mode. 
	 */
	public void setRotateYAxisName(String value) {
		setAttribute(PARAMETER_ROTATEYAXISNAME, value);
	}

	/**
	 * Type: Number 
	 * Range value: (In Pixels) 
	 * Description :
	 * If you opt to not rotate y-axis name, you can choose a maximum 
	 * width that will be applied to y-axis name. 
	 */
	public void setYAxisNameWidth(String value) {
		setAttribute(PARAMETER_YAXISNAMEWIDTH, value);
	}

	/**
	 * Type: Number 
	 * Range value: 
	 * Description :
	 * This attribute helps you explicitly set the lower limit of the 
	 * chart. If you don't specify this value, it is automatically calculated
	 *  by FusionCharts based on the data provided by you. 
	 */
	public void setYAxisMinValue(String value) {
		setAttribute(PARAMETER_YAXISMINVALUE, value);
	}

	/**
	 * Type: Number 
	 * Range value: 
	 * Description :
	 * This attribute helps you explicitly set the upper limit of the 
	 * chart. If you don't specify this value, it is automatically calculated
	 *  by FusionCharts based on the data provided by you. 
	 */
	public void setYAxisMaxValue(String value) {
		setAttribute(PARAMETER_YAXISMAXVALUE, value);
	}

	/**
	 * Type: Boolean 
	 * Range value: 0/1 
	 * Description :
	 * This attribute lets you set whether the y-axis lower limit would 
	 * be 0 (in case of all positive values on chart) or should the y-axis 
	 * lower limit adapt itself to a different figure based on values 
	 * provided to the chart.
	 */
	public void setSetAdaptiveYMin(String value) {
		setAttribute(PARAMETER_SETADAPTIVEYMIN, value);
	}

	/**
	 * Type: String 
	 * Range value: 
	 * Description :
	 * X-Axis Title of the Chart. 
	 */
	public void setXAxisName(String value) {
		setAttribute(PARAMETER_XAXISNAME, value);
	}

	/**
	 * Type: String 
	 * Range value: 
	 * Description :
	 * Y-Axis Title of the chart. 
	 */
	public void setYAxisName(String value) {
		setAttribute(PARAMETER_YAXISNAME, value);
	}

	/**
	 * Type: Color 
	 * Range value: 
	 * Description :
	 * Sets Canvas background color. For Gradient effect, enter colors 
	 * separated by comma. 
	 */
	public void setCanvasBgColor(String value) {
		setAttribute(PARAMETER_CANVASBGCOLOR, value);
	}

	/**
	 * Type: Number 
	 * Range value: 
	 * Description :
	 * Sets alpha for Canvas Background. For gradient, enter alpha list 
	 * separated by commas. 
	 */
	public void setCanvasBgAlpha(String value) {
		setAttribute(PARAMETER_CANVASBGALPHA, value);
	}

	/**
	 * Type: Number 
	 * Range value: 0-100 
	 * Description :
	 * Helps you specify canvas background ratio for gradients. 
	 */
	public void setCanvasBgRatio(String value) {
		setAttribute(PARAMETER_CANVASBGRATIO, value);
	}

	/**
	 * Type: Number 
	 * Range value: 
	 * Description :
	 * Helps you specify canvas background angle in case of gradient. 
	 */
	public void setCanvasBgAngle(String value) {
		setAttribute(PARAMETER_CANVASBGANGLE, value);
	}

	/**
	 * Type: Color 
	 * Range value: 
	 * Description :
	 * Lets you specify canvas border color. 
	 */
	public void setCanvasBorderColor(String value) {
		setAttribute(PARAMETER_CANVASBORDERCOLOR, value);
	}

	/**
	 * Type: Number 
	 * Range value: 0-5 
	 * Description :
	 * Lets you specify canvas border thickness. 
	 */
	public void setCanvasBorderThickness(String value) {
		setAttribute(PARAMETER_CANVASBORDERTHICKNESS, value);
	}

	/**
	 * Type: Number 
	 * Range value: 0-100 
	 * Description :
	 * Lets you control transparency of canvas border. 
	 */
	public void setCanvasBorderAlpha(String value) {
		setAttribute(PARAMETER_CANVASBORDERALPHA, value);
	}

	/**
	 * Type: Boolean 
	 * Range value: 0/1 
	 * Description :
	 * If you wish to plot columns with round edges and fill them with a 
	 * glass effect gradient, set this attribute to 1.
The following 
	 * functionalities wouldn't work when this attribute is set to 1:
	 * 
showShadow attribute doesn't work any more. If you want to remove 
	 * shadow from columns, you'll have to over-ride the shadow with a new 
	 * shadow style (applied to DATAPLOT) with alpha as 0. 
Plot fill 
	 * properties like gradient color, angle etc. wouldn't work any more, as 
	 * the colors for gradient are now calculated by the chart itself. 
Plot 
	 * border properties also do not work in this mode. Also, you cannot 
	 * render the border as dash in this mode. 
	 */
	public void setUseRoundEdges(String value) {
		setAttribute(PARAMETER_USEROUNDEDGES, value);
	}

	/**
	 * Type: Boolean 
	 * Range value: 0/1 
	 * Description :
	 * Whether the column, area, pie etc. border would show up. 
	 */
	public void setShowPlotBorder(String value) {
		setAttribute(PARAMETER_SHOWPLOTBORDER, value);
	}

	/**
	 * Type: Color 
	 * Range value: 
	 * Description :
	 * Color for column, area, pie border 
	 */
	public void setPlotBorderColor(String value) {
		setAttribute(PARAMETER_PLOTBORDERCOLOR, value);
	}

	/**
	 * Type: Number 
	 * Range value: 0-5 (Pixels) 
	 * Description :
	 * Thickness for column, area, pie border 
	 */
	public void setPlotBorderThickness(String value) {
		setAttribute(PARAMETER_PLOTBORDERTHICKNESS, value);
	}

	/**
	 * Type: Number 
	 * Range value: 0-100 
	 * Description :
	 * Alpha for column, area, pie border 
	 */
	public void setPlotBorderAlpha(String value) {
		setAttribute(PARAMETER_PLOTBORDERALPHA, value);
	}

	/**
	 * Type: Boolean 
	 * Range value: 0/1 
	 * Description :
	 * Whether the plot border should appear as dashed? 
	 */
	public void setPlotBorderDashed(String value) {
		setAttribute(PARAMETER_PLOTBORDERDASHED, value);
	}

	/**
	 * Type: Number 
	 * Range value: In Pixels 
	 * Description :
	 * If plot border is to appear as dash, this attribute lets you 
	 * control the length of each dash. 
	 */
	public void setPlotBorderDashLen(String value) {
		setAttribute(PARAMETER_PLOTBORDERDASHLEN, value);
	}

	/**
	 * Type: Number 
	 * Range value: In Pixels 
	 * Description :
	 * If plot border is to appear as dash, this attribute lets you 
	 * control the length of each gap between two dash. 
	 */
	public void setPlotBorderDashGap(String value) {
		setAttribute(PARAMETER_PLOTBORDERDASHGAP, value);
	}

	/**
	 * Type: Number 
	 * Range value: 0-360 
	 * Description :
	 * If you've opted to fill the plot (column, area etc.) as gradient, 
	 * this attribute lets you set the fill angle for gradient. 
	 */
	public void setPlotFillAngle(String value) {
		setAttribute(PARAMETER_PLOTFILLANGLE, value);
	}

	/**
	 * Type: Number 
	 * Range value: 0-100 
	 * Description :
	 * If you've opted to fill the plot (column, area etc.) as gradient, 
	 * this attribute lets you set the ratio for gradient. 
	 */
	public void setPlotFillRatio(String value) {
		setAttribute(PARAMETER_PLOTFILLRATIO, value);
	}

	/**
	 * Type: Number 
	 * Range value: 0-100 
	 * Description :
	 * If you've opted to fill the plot (column, area etc.) as gradient, 
	 * this attribute lets you set the fill alpha for gradient. 
	 */
	public void setPlotFillAlpha(String value) {
		setAttribute(PARAMETER_PLOTFILLALPHA, value);
	}

	/**
	 * Type: Color 
	 * Range value: Hex Color 
	 * Description :
	 * You can globally add a gradient color to the entire plot of chart 
	 * by specifying the second color as this attribute. For example, if you'
	 * ve specified individual colors for your columns and now you want a 
	 * gradient that ends in white. So, specify FFFFFF (white) as this color 
	 * and the chart will now draw plots as gradient.
	 */
	public void setPlotGradientColor(String value) {
		setAttribute(PARAMETER_PLOTGRADIENTCOLOR, value);
	}

	/**
	 * Type: Number 
	 * Range value: Numeric value > 0 
	 * Description :
	 * Number of horizontal axis division lines that you want on the 
	 * chart. 
	 */
	public void setNumDivLines(String value) {
		setAttribute(PARAMETER_NUMDIVLINES, value);
	}

	/**
	 * Type: Color 
	 * Range value: 
	 * Description :
	 * Color for divisional lines 
	 */
	public void setDivLineColor(String value) {
		setAttribute(PARAMETER_DIVLINECOLOR, value);
	}

	/**
	 * Type: Number 
	 * Range value: 39203.0
	 * Description :
	 * Thickness of divisional lines 
	 */
	public void setDivLineThickness(String value) {
		setAttribute(PARAMETER_DIVLINETHICKNESS, value);
	}

	/**
	 * Type: Number 
	 * Range value: 0-100 
	 * Description :
	 * Alpha of divisional lines. 
	 */
	public void setDivLineAlpha(String value) {
		setAttribute(PARAMETER_DIVLINEALPHA, value);
	}

	/**
	 * Type: Boolean 
	 * Range value: 0/1 
	 * Description :
	 * Whether the divisional lines should display as dash? 
	 */
	public void setDivLineIsDashed(String value) {
		setAttribute(PARAMETER_DIVLINEISDASHED, value);
	}

	/**
	 * Type: Number 
	 * Range value: In Pixels 
	 * Description :
	 * If the divisional lines are to be displayed as dash, this 
	 * attribute lets you control the length of each dash. 
	 */
	public void setDivLineDashLen(String value) {
		setAttribute(PARAMETER_DIVLINEDASHLEN, value);
	}

	/**
	 * Type: Number 
	 * Range value: In Pixels 
	 * Description :
	 * If the divisional lines are to be displayed as dash, this 
	 * attribute lets you control the length of each gap between dash. 
	 */
	public void setDivLineDashGap(String value) {
		setAttribute(PARAMETER_DIVLINEDASHGAP, value);
	}

	/**
	 * Type: Color 
	 * Range value: 
	 * Description :
	 * Color for the Zero Plane. Zero Plane is the line/plane that 
	 * appears at 0 y-position on canvas, when negative data is being shown 
	 * on the chart. 
	 */
	public void setZeroPlaneColor(String value) {
		setAttribute(PARAMETER_ZEROPLANECOLOR, value);
	}

	/**
	 * Type: Number 
	 * Range value: In Pixels 
	 * Description :
	 * Thickness of zero plane. 
	 */
	public void setZeroPlaneThickness(String value) {
		setAttribute(PARAMETER_ZEROPLANETHICKNESS, value);
	}

	/**
	 * Type: Number 
	 * Range value: 0-100 
	 * Description :
	 * Alpha of zero plane. 
	 */
	public void setZeroPlaneAlpha(String value) {
		setAttribute(PARAMETER_ZEROPLANEALPHA, value);
	}

	/**
	 * Type: Boolean 
	 * Range value: 0/1 
	 * Description :
	 * Whether to show alternate colored horizontal grid bands? 
	 */
	public void setShowAlternateHGridColor(String value) {
		setAttribute(PARAMETER_SHOWALTERNATEHGRIDCOLOR, value);
	}

	/**
	 * Type: Color 
	 * Range value: 
	 * Description :
	 * Color of the alternate horizontal grid bands. 
	 */
	public void setAlternateHGridColor(String value) {
		setAttribute(PARAMETER_ALTERNATEHGRIDCOLOR, value);
	}

	/**
	 * Type: Number 
	 * Range value: 
	 * Description :
	 * Alpha (transparency) of the alternate horizontal grid bands.
	 */
	public void setAlternateHGridAlpha(String value) {
		setAttribute(PARAMETER_ALTERNATEHGRIDALPHA, value);
	}

	/**
	 * Type: Number 
	 * Range value: 0-10 
	 * Description :
	 * If you've opted to not adjust div lines, you can specify the div 
	 * line values decimal precision using this attribute.
	 */
	public void setYAxisValueDecimals(String value) {
		setAttribute(PARAMETER_YAXISVALUEDECIMALS, value);
	}

	/**
	 * Type: String 
	 * Range value: Font Name 
	 * Description :
	 * This attribute sets the base font family of the chart font which 
	 * lies outside the canvas i.e., all the values and the names in the 
	 * chart which lie outside the canvas will be displayed using the font 
	 * name provided here. 
	 */
	public void setOutCnvBaseFont(String value) {
		setAttribute(PARAMETER_OUTCNVBASEFONT, value);
	}

	/**
	 * Type: Number 
	 * Range value: 0-72 
	 * Description :
	 * This attribute sets the base font size of the chart i.e., all the 
	 * values and the names in the chart which lie outside the canvas will be
	 *  displayed using the font size provided here. 
	 */
	public void setOutCnvBaseFontSize(String value) {
		setAttribute(PARAMETER_OUTCNVBASEFONTSIZE, value);
	}

	/**
	 * Type: Color 
	 * Range value: 
	 * Description :
	 * This attribute sets the base font color of the chart i.e., all the
	 *  values and the names in the chart which lie outside the canvas will 
	 * be displayed using the font color provided here.
	 */
	public void setOutCnvBaseFontColor(String value) {
		setAttribute(PARAMETER_OUTCNVBASEFONTCOLOR, value);
	}

	/**
	 * Type: Number 
	 * Range value: In Pixels 
	 * Description :
	 * Using this, you can set the distance between the top end of x-axis
	 *  title and the bottom end of data labels (or canvas, if data labels 
	 * are not to be shown). 
	 */
	public void setXAxisNamePadding(String value) {
		setAttribute(PARAMETER_XAXISNAMEPADDING, value);
	}

	/**
	 * Type: Number 
	 * Range value: In Pixels 
	 * Description :
	 * Using this, you can set the distance between the right end of y-
	 * axis title and the start of y-axis values (or canvas, if the y-axis 
	 * values are not to be shown). 
	 */
	public void setYAxisNamePadding(String value) {
		setAttribute(PARAMETER_YAXISNAMEPADDING, value);
	}

	/**
	 * Type: Number 
	 * Range value: In Pixels 
	 * Description :
	 * This attribute helps you set the horizontal space between the 
	 * canvas left edge and the y-axis values or trend line values (on left/
	 * right side). This is particularly useful, when you want more space 
	 * between your canvas and y-axis values. 
	 */
	public void setYAxisValuesPadding(String value) {
		setAttribute(PARAMETER_YAXISVALUESPADDING, value);
	}

	/**
	 * Type: Number 
	 * Range value: In Pixels 
	 * Description :
	 * This attribute sets the vertical space between the labels and 
	 * canvas bottom edge. If you want more space between the canvas and the 
	 * x-axis labels, you can use this attribute to control it. 
	 */
	public void setLabelPadding(String value) {
		setAttribute(PARAMETER_LABELPADDING, value);
	}

	/**
	 * Type: Number 
	 * Range value: In Pixels 
	 * Description :
	 * It sets the vertical space between the end of columns and start of
	 *  value textboxes. This basically helps you control the space you want 
	 * between your columns/anchors and the value textboxes. 
	 */
	public void setValuePadding(String value) {
		setAttribute(PARAMETER_VALUEPADDING, value);
	}

	/**
	 * Type: Number 
	 * Range value: 0-80 (In Percent) 
	 * Description :
	 * On a column chart, there is spacing defined between two columns. 
	 * By default, the spacing is set to 20% of canvas width. If you intend 
	 * to increase or decrease the spacing between columns, you can do so 
	 * using this attribute. For example, if you wanted all columns to stick 
	 * to each other without any space in between, you can set 
	 * plotSpacePercent to 0. Similarly, if you want very thin columns, you 
	 * can set plotSpacePercent to its max value of 80. 
	 */
	public void setPlotSpacePercent(String value) {
		setAttribute(PARAMETER_PLOTSPACEPERCENT, value);
	}
        /**
         * @see com.raisepartner.chartfusion.api.bar2d.Set
         */
        public Set createSetNode() {
                Set node = new Set();
		addNode(node);
		return node;
        }

        /**
         * @see com.raisepartner.chartfusion.api.bar2d.VLine
         */
        public VLine createVLineNode() {
                VLine node = new VLine();
		addNode(node);
		return node;
        }

        /**
         * @see com.raisepartner.chartfusion.api.bar2d.TrendLines
         */
        public TrendLines createTrendLinesNode() {
                TrendLines node = new TrendLines();
		addNode(node);
		return node;
        }

}
