package nwd.a00908773.comp3717.bcit.ca.nwd;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.mikephil.charting.charts.*;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import nwd.a00908773.comp3717.bcit.ca.nwd.Handlers.ChartHandler;
import nwd.a00908773.comp3717.bcit.ca.nwd.Handlers.LineChartHandler;
import nwd.a00908773.comp3717.bcit.ca.nwd.SetHandlers.LineSetHandler;
import nwd.a00908773.comp3717.bcit.ca.nwd.SetHandlers.SetHandler;
import nwd.a00908773.comp3717.bcit.ca.nwd.SetHandlers.CSVFile;
import nwd.a00908773.comp3717.bcit.ca.nwd.SetHandlers.Csvhold;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    LineChart lChart;
    BarChart bChart;
    HorizontalBarChart hbChart;
    PieChart pChart;
    RadarChart rChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lChart = (LineChart) findViewById(R.id.lChart);
        bChart = (BarChart) findViewById(R.id.bChart);
        hbChart = (HorizontalBarChart) findViewById(R.id.hbChart);
        pChart = (PieChart) findViewById(R.id.pChart);
        rChart = (RadarChart) findViewById(R.id.rChart);

        Spinner spinner = (Spinner) findViewById(R.id.graph_type);
        Spinner spinner2 = (Spinner) findViewById(R.id.opendata);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.graph_type, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.opendata, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        InputStream istream = getResources().openRawResource(R.raw.washrooms);
        BufferedReader bReader = new BufferedReader(new InputStreamReader(istream));

        List arr = new ArrayList();

        String temp;
        try {
            while((temp = bReader.readLine()) != null) {
                String[] row = temp.split(",");
                for(String s : row) {
                    char[] cs = s.toCharArray();
                    float total = 0f;
                    for(char c: cs) {
                        total = total + (int) c;
                    }
                    arr.add(total);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("CSV failed to read");
        } finally {
            try {
                istream.close();
            } catch (IOException e) {
                throw new RuntimeException("istream failed to close");
            }
        }
        List<Entry> entries1 = new ArrayList<Entry>();
        List<Entry> entries2 = new ArrayList<Entry>();

        for(int i = 0; i < arr.size() / 4; i++) {
            entries1.add(new Entry((float) arr.get(4 * i), (float) arr.get(4 * i + 1)));
            entries2.add(new Entry((float)arr.get(4 * i + 2), (float)arr.get(4 * i + 3)));
        }

        /**
        changeView(bChart);
        BarDataSet set1 = new BarDataSet(entries1, "Group 1");
        set1.setColors(ColorTemplate.JOYFUL_COLORS);
        BarDataSet set2 = new BarDataSet(entries2, "Group 2");
        set2.setColors(ColorTemplate.PASTEL_COLORS);

        ChartData data = new BarData();
        data.addDataSet(set1);
        data.addDataSet(set2);
        bChart.setData((BarData)data);
        bChart.invalidate();
        */


        changeView(lChart);
        DataSet set1 = new LineDataSet(entries1, "line 1");
        set1.setColors(ColorTemplate.JOYFUL_COLORS);
        SetHandler lsh1 = new LineSetHandler(set1);

        DataSet set2 = new LineDataSet(entries2, "line 2");
        set2.setColors(ColorTemplate.PASTEL_COLORS);
        SetHandler lsh2 = new LineSetHandler(set2);


        ChartData data = new LineData();

        data.addDataSet(set1);
        data.addDataSet(set2);

        lChart.setData((LineData)data);
        lChart.invalidate();


    }

    public void changeView(View v){
        this.lChart.setVisibility(View.GONE);
        this.bChart.setVisibility(View.GONE);
        this.hbChart.setVisibility(View.GONE);
        this.pChart.setVisibility(View.GONE);
        this.rChart.setVisibility(View.GONE);

        v.setVisibility(View.VISIBLE);
    }

    public void download(View v)
    {
        // TODO Auto-generated method stub
        Intent dlIntent = new Intent(getApplicationContext(),DownloadActivity.class);
        startActivity(dlIntent);

    }

    public void setting(View v) {

        Intent settingsIntent = new Intent(getApplicationContext(),SettingsActivity.class);
        startActivity(settingsIntent);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        TextView v;
        switch(parent.getId()){
            case R.id.graph_type:
                v = (TextView) findViewById(R.id.graphtext);
                v.setText(parent.getItemAtPosition(pos).toString());
                break;
            case R.id.opendata:
                v = (TextView) findViewById(R.id.openDataset);
                v.setText(parent.getItemAtPosition(pos).toString());
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public ArrayList<Csvhold> getFile(String filename) {
        int rawId = getResources().getIdentifier(filename, "raw", getPackageName());
        ArrayList<Csvhold> listhold = new ArrayList<Csvhold>();
        InputStream inputStream = getResources().openRawResource(rawId);
        CSVFile csvFile = new CSVFile(inputStream);
        listhold = csvFile.read();
        return listhold;
    }

    public ArrayList<String> listRaw(){
        ArrayList<String> getRaw = new ArrayList<String>();
        Field[] fields=R.raw.class.getFields();
        for(int count=0; count < fields.length; count++){
            getRaw.add(fields[count].getName());
        }
        return getRaw;
    }

}
