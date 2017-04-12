package nwd.a00908773.comp3717.bcit.ca.nwd;

import android.util.Log;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nwd.a00908773.comp3717.bcit.ca.nwd.CSVhandler.Csvhold;
import nwd.a00908773.comp3717.bcit.ca.nwd.DataHandlers.DataHandler;
import nwd.a00908773.comp3717.bcit.ca.nwd.Handlers.BarChartHandler;
import nwd.a00908773.comp3717.bcit.ca.nwd.Handlers.ChartHandler;
import nwd.a00908773.comp3717.bcit.ca.nwd.Handlers.LineChartHandler;
import nwd.a00908773.comp3717.bcit.ca.nwd.Handlers.PieChartHandler;
import nwd.a00908773.comp3717.bcit.ca.nwd.SetHandlers.LineSetHandler;
import nwd.a00908773.comp3717.bcit.ca.nwd.SetHandlers.PieSetHandler;
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
    }

    public void reset(){
        chart.clear();
    }

    public void changeDescripion(){
        Description desc = new Description();
        desc.setText(name);
        chart.setDescription(desc);
    }

    public void setLegend(){
        legend = chart.getLegend();
        legend.setWordWrapEnabled(true);
        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
    }

    public void buildChart() {
        reset();
        changeDescripion();
        setLegend();
        if(chart instanceof LineChart) {
            buildLineChart();
        } else if(chart instanceof BarChart){
            buildBarChart();
        } else if(chart instanceof HorizontalBarChart){
            buildHBChart();
        } else if(chart instanceof PieChart){
            buildPChart();
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

    public void buildBarChart(){
        BarChartHandler bch = new BarChartHandler(chart);
        reset();
        BarData bd = new BarData();

        for(Csvhold csv : table){
            List<BarEntry> tempList = new ArrayList<>();
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

                    tempList.add(new BarEntry(f, g));
                }
            }
            int theme = (int)(Math.random() * 6);
            BarDataSet bds = new BarDataSet(tempList, csv.getName());;
            SetHandler bdsh = new SetHandler(bds);
            bdsh.setTheme(theme);
            bd.addDataSet(bds);
        }
        bch.setData(bd);
        bch.draw();
    }

    public void buildHBChart(){
        BarChartHandler bch = new BarChartHandler(chart);
        reset();
        BarData bd = new BarData();

        for(Csvhold csv : table){
            List<BarEntry> tempList = new ArrayList<>();
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

                    tempList.add(new BarEntry(f, g));
                }
            }
            int theme = (int)(Math.random() * 6);
            BarDataSet bds = new BarDataSet(tempList, csv.getName());;
            SetHandler bdsh = new SetHandler(bds);
            bdsh.setTheme(theme);
            bd.addDataSet(bds);
        }
        bch.setData(bd);
        bch.draw();
    }
    public void buildPChart(){
        PieChartHandler pch = new PieChartHandler(chart);
        reset();
        List<PieEntry> pieEntryList = new ArrayList<>();
        Map<String, Float> map = new HashMap<>();

        int rand = (int) (Math.random() * table.size());
        for(String s : table.get(rand).getData()){
            if(map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 0f);
            }
        }

        for(String key : map.keySet()){
            PieEntry temp = new PieEntry(map.get(key)/map.size(), key);
            pieEntryList.add(temp);
        }
        PieDataSet set = new PieDataSet(pieEntryList, name);
        PieSetHandler psh = new PieSetHandler(set);
        int theme = (int)(Math.random() * 6);
        psh.setTheme(theme);
        psh.setShift(20f);
        psh.setSpace(4f);
        PieData pd = new PieData(set);
        pch.setData(pd);
        pch.draw();
    }
}
