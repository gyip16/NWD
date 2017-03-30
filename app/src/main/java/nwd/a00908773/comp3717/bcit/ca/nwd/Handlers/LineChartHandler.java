package nwd.a00908773.comp3717.bcit.ca.nwd.Handlers;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;

/**
 * Created by Pkao on 2017-03-29.
 */

public class LineChartHandler extends ChartHandler {
    public LineChartHandler (Chart chart){
        super(chart);
    }

    public void setAutoScaleMinMax(Boolean isEnabled){
        ((LineChart)chart).setAutoScaleMinMaxEnabled(isEnabled);
    }
}
