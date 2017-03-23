package nwd.a00908773.comp3717.bcit.ca.nwd;

import android.graphics.Color;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.List;

/**
 * Created by Pkao on 2017-03-23.
 */

public class PieChartHandler {
    private PieChart pieChart;
    private PieData data;
    private PieDataSet set;
    private Description desc;
    private Legend legend;
    private int style;

    public PieChartHandler (PieChart pChart, List<PieEntry> pies, String s, int style){
        pieChart = pChart;
        set = new PieDataSet(pies, "");
        desc = new Description();
        desc.setText(s);
        data = new PieData(set);
        pieChart.setData(data);
        pieChart.setDescription(desc);
        legend = pieChart.getLegend();
        this.style = style;
    }

    public void drawChart(){
        changeChart();
        changeLegend();
        changeSet();

        pieChart.invalidate();
    }

    private void changeChart(){
        pieChart.setDrawEntryLabels(false);
        pieChart.setHoleRadius(45f);
    }

    private void changeLegend() {
        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(true);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
    }

    private void changeSet() {
        //set.setColors(new int[] {Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN, Color.MAGENTA});
        switch(style) {
            case 0:
                set.setColors(ColorTemplate.MATERIAL_COLORS);
                break;
            case 1:
                set.setColors(ColorTemplate.JOYFUL_COLORS);
                break;
            case 2:
                set.setColors(ColorTemplate.PASTEL_COLORS);
                break;
            case 3:
                set.setColors(ColorTemplate.LIBERTY_COLORS);
                break;
            case 4:
                set.setColors(ColorTemplate.VORDIPLOM_COLORS);
                break;
            case 5:
                set.setColors(ColorTemplate.COLORFUL_COLORS);
            default:
                set.setColors(ColorTemplate.COLOR_NONE);

        }
        set.setSliceSpace(15f);
        set.setSelectionShift(20f);
    }


}
