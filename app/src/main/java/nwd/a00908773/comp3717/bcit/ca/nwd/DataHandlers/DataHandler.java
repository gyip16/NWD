package nwd.a00908773.comp3717.bcit.ca.nwd.DataHandlers;

import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;

/**
 * Created by Pkao on 2017-03-29.
 */

public abstract class DataHandler {
    protected ChartData data;

    public DataHandler(ChartData data) {
        this.data = data;
    }

    /**
     * Clears the data object of all DataSet objects and thereby all Entries. Does not remove the
     * provided x-values.
     */
    public void clearData() {
        data.clearValues();
    }

    /**
     * Adds a DataSet dynamically.
     * @param set
     */
    public void addDataSet(DataSet set) {
        data.addDataSet(set);
    }

    /**
     * Sets the color of the value-text (color in which the value-labels are drawn) for all DataSets
     * this data object contains.
     *
     * @param colour
     */
    public void setTextColour(int colour) {
        data.setValueTextColor(colour);
    }

    /**
     * Enables / disables drawing values (value-text) for all DataSets this data object contains.
     *
     * @param isEnabled
     */
    public void DrawValues(boolean isEnabled) {
        data.setDrawValues(isEnabled);
    }
}

