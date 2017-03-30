package nwd.a00908773.comp3717.bcit.ca.nwd.SetHandlers;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.PieDataSet;

/**
 * Created by Pkao on 2017-03-30.
 */

public class PieSetHandler extends SetHandler {

    public PieSetHandler(DataSet set){
        super(set);
    }

    /**
     * Sets the space that is left out between the piechart-slices in dp, default: 0 --> no space,
     * maximum 20, minimum 0 (no space)
     * @param space
     */
    public void setSpace(float space) {
        ((PieDataSet)set).setSliceSpace(space);
    }

    /**
     * Sets the distance the highlighted piechart-slice of this DataSet is "shifted" away from the
     * center of the chart, default 12f
     * @param shift
     */
    public void setShift(float shift) {
        ((PieDataSet)set).setSelectionShift(shift);
    }
}
