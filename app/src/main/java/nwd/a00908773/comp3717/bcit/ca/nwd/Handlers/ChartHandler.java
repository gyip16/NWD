package nwd.a00908773.comp3717.bcit.ca.nwd.Handlers;


import android.content.Context;
import android.widget.Toast;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.ChartData;

/**
 * Created by Pkao on 2017-03-29.
 */

public abstract class ChartHandler {
    protected Chart chart;

    protected ChartHandler(Chart chart){
        this.chart = chart;
    }

    /**
     * draws the graph
     */
    protected void draw() {
        chart.invalidate();
    }

    /**
     * Sets a new data object for the chart. The data object contains all values and information needed for displaying.
     * @param data ChartData object
     */
    protected void setData(ChartData data){
        chart.setData(data);
    }

    /**
     * Returns the ChartData object that has been set for the chart.
     * @return
     */
    protected ChartData getData() {
        return chart.getData();
    }

    /**
     * Clears the chart from all data (sets it to null) and refreshes it (by calling invalidate()).
     */
    protected void clearData() {
        chart.clear();
    }

    /**
     * Sets a new Description object for the chart.
     * @param desc Description object
     */
    protected void setDescription(Description desc) {
        chart.setDescription(desc);
    }

    /**
     * Set background colour of view
     * @param colour colour to be set
     */
    public void setColour(int colour) {
        chart.setBackgroundColor(colour);
    }

    /**
     * Saves the current chart state with the given name to the given path on the sdcard leaving the
     * path empty "" will put the saved file directly on the SD card chart is saved as a PNG image,
     * example: saveToPath("myfilename", "foldername1/foldername2");
     * @param title name of file
     * @param path path under SD card
     * @param context context of where to show message
     */
    protected void saveChartAsPNG(String title, String path, Context context) {
        if(!(chart.saveToPath(title, path))) {
            Toast.makeText(context, "Could not save file", Toast.LENGTH_SHORT).show();
        }
    }

}
