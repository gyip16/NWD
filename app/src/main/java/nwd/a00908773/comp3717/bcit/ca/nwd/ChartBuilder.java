package nwd.a00908773.comp3717.bcit.ca.nwd;

import android.util.Log;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

import nwd.a00908773.comp3717.bcit.ca.nwd.CSVhandler.Csvhold;
import nwd.a00908773.comp3717.bcit.ca.nwd.DataHandlers.DataHandler;
import nwd.a00908773.comp3717.bcit.ca.nwd.Handlers.ChartHandler;
import nwd.a00908773.comp3717.bcit.ca.nwd.Handlers.LineChartHandler;
import nwd.a00908773.comp3717.bcit.ca.nwd.SetHandlers.LineSetHandler;
import nwd.a00908773.comp3717.bcit.ca.nwd.SetHandlers.SetHandler;

/**
 * Created by Pkao on 2017-04-12.
 */

public class ChartBuilder {
    Chart chart;
    Legend legend;
    ArrayList<Csvhold> table;
    String name;

    public ChartBuilder(Chart chart, ArrayList<Csvhold> arr, String name){
        this.chart = chart;
        table = arr;
        this.name = name;
        legend = new Legend();
    }

    public void reset(){
        chart.clear();
    }

    public void changeDescripion(){
        Description desc = new Description();
        desc.setText(name);
        chart.setDescription(desc);
    }

    public void buildChart() {
        reset();
        changeDescripion();
        if(chart instanceof LineChart){
            buildLineChart() ;
        }
    }

    public void buildLineChart() {

        LineChartHandler lch = new LineChartHandler(chart);
        reset();
        LineData ld = new LineData();

        for(Csvhold csv : table){
            List<Entry> tempList = new ArrayList<>();
            for(String s : csv.getData()){
                float f = 0;
                float g = 0;
                char[] cs = s.toCharArray();
                for(int i = 0; i < cs.length; i ++){
                    if(i % 2 == 1) {
                        f = (float) cs[i];
                    } else {
                        g = (float) cs[i];
                    }

                    tempList.add(new Entry(f, g));
                }
            }
            int theme = (int)(Math.random() * 6);
            LineDataSet lds = new LineDataSet(tempList, csv.getName());
            LineSetHandler lsh = new LineSetHandler(lds);
            lds.setDrawCircles(false);
            lsh.setTheme(theme);
            ld.addDataSet(lds);
        }
        lch.setData(ld);
        lch.draw();
    }
}
