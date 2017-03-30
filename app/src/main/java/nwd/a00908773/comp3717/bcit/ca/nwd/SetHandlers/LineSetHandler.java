package nwd.a00908773.comp3717.bcit.ca.nwd.SetHandlers;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.LineDataSet;

/**
 * Created by Pkao on 2017-03-30.
 */

public class LineSetHandler extends SetHandler {
    public LineSetHandler (DataSet set) {
        super(set);
    }

    /**
     * Sets the size (radius) of the circle shaped value indicators, default size = 4f
     * @param size
     */
    public void setRadius(float size) {
        ((LineDataSet)set).setCircleRadius(size);
    }

    /**
     * Enable dashed line with hardcoded defaults
     */
    public void setDash() {
        ((LineDataSet)set).enableDashedLine(5f, 2f, 0);
    }

    /**
     * Disable dashed line
     */
    public void unsetDash() {
        ((LineDataSet)set).disableDashedLine();
    }
}
