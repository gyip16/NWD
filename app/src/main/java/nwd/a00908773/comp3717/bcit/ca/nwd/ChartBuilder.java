package nwd.a00908773.comp3717.bcit.ca.nwd;

import android.util.Log;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
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
    ArrayList<Csvhold> table;

    public ChartBuilder(Chart chart, ArrayList<Csvhold> arr){
        this.chart = chart;
        table = arr;
    }

    public void reset(){
        chart.clear();
    }

    public void buildChart() {
        reset();
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
            SetHandler lsh = new LineSetHandler(lds);
            lsh.setTheme(theme);
            ld.addDataSet(lds);
        }
        lch.setData(ld);
        lch.draw();
    }
}
