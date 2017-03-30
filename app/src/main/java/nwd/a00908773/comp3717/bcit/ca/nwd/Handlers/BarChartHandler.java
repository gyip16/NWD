package nwd.a00908773.comp3717.bcit.ca.nwd.Handlers;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;

/**
 * Created by Pkao on 2017-03-29.
 */

public class BarChartHandler extends ChartHandler {

    public BarChartHandler (Chart chart){
        super(chart);
    }

    /**
     * If set to true, all values are drawn above their bars, instead of below their top.
     * @param isEnabled
     */
    public void setValuesEnabled(Boolean isEnabled) {
        ((BarChart)chart).setDrawValueAboveBar(isEnabled);
    }

    /**
     * If set to true, all values of stacked bars are drawn individually, and not just their sum on top of all.
     * @param isEnabled
     */
    public void setBarShadowEnabled(Boolean isEnabled) {
        ((BarChart)chart).setDrawBarShadow(isEnabled);

    }
}
