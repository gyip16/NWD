package nwd.a00908773.comp3717.bcit.ca.nwd.Handlers;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;

/**
 * Created by Pkao on 2017-03-29.
 */

public class PieChartHandler extends ChartHandler {

    public PieChartHandler(Chart chart) {
        super(chart);
    }

    /**
     * Sets the text String that is displayed in the center of the PieChart.
     * @param text
     */
    public void setCentreText(String text) {
        ((PieChart)chart).setCenterText(text);
    }

    /**
     * Set this to true to draw the x-value text into the pie slices.
     * @param isEnabled
     */
    public void setDrawEnties(Boolean isEnabled) {
        ((PieChart)chart).setDrawEntryLabels(isEnabled);
    }
}
