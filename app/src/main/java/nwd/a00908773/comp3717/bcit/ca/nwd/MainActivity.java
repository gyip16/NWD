package nwd.a00908773.comp3717.bcit.ca.nwd;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.*;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import nwd.a00908773.comp3717.bcit.ca.nwd.SetHandlers.LineSetHandler;
import nwd.a00908773.comp3717.bcit.ca.nwd.SetHandlers.SetHandler;
import nwd.a00908773.comp3717.bcit.ca.nwd.CSVhandler.CSVFile;
import nwd.a00908773.comp3717.bcit.ca.nwd.CSVhandler.Csvhold;

public class MainActivity extends FragmentActivity {

    LineChart lChart;
    BarChart bChart;
    HorizontalBarChart hbChart;
    PieChart pChart;
    RadarChart rChart;

    ListView drawerList;
    DrawerLayout drawerLayout;
    String selectedFile;
    ChartDialog chartDialog;

    ChartBuilder chartBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);
        //getSupportActionBar().hide();

        lChart = (LineChart) findViewById(R.id.lChart);
        bChart = (BarChart) findViewById(R.id.bChart);
        hbChart = (HorizontalBarChart) findViewById(R.id.hbChart);
        pChart = (PieChart) findViewById(R.id.pChart);
        rChart = (RadarChart) findViewById(R.id.rChart);

        List<String> listOfFiles = listFiles();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listOfFiles);
        drawerList.setAdapter(adapter);

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String filename = parent.getAdapter().getItem(position).toString();
                chartDialog = new ChartDialog();
                FragmentManager fragmentManager = getFragmentManager();
                selectedFile = filename;
                chartDialog.show(fragmentManager, "myTag");
            }
        });

    }

    public void selectChart(View view){
        chartDialog.dismiss();
        drawerLayout.closeDrawers();
        switch(view.getId()){
            case R.id.line:
                changeView(lChart);
                chartBuilder = new ChartBuilder(lChart, getFile(selectedFile));
                chartBuilder.buildChart();
                break;
            case R.id.bar:
                changeView(bChart);
                break;
            case R.id.hbar:
                changeView(hbChart);
                break;
            case R.id.radar:
                changeView(rChart);
                break;
            case R.id.pie:
                changeView(pChart);
                break;
            default:
                break;
        }
    }

    public void changeView(View v){
        lChart.setVisibility(View.GONE);
        bChart.setVisibility(View.GONE);
        hbChart.setVisibility(View.GONE);
        pChart.setVisibility(View.GONE);
        rChart.setVisibility(View.GONE);

        v.setVisibility(View.VISIBLE);
    }

    public ArrayList<Csvhold> getFile(String filename) {
        int rawId = getResources().getIdentifier(filename, "raw", getPackageName());
        ArrayList<Csvhold> listhold = new ArrayList<>();
        InputStream inputStream = getResources().openRawResource(rawId);
        try {
            listhold = CSVFile.read(inputStream);
        } catch (IOException e){
            Toast t = Toast.makeText(getApplicationContext(), "File Not Found Error", Toast.LENGTH_SHORT);
            t.show();
        }
        return listhold;
    }

    /**
     * Returns an ArrayList of files currently in app/res/raw
     * @return
     */
    public ArrayList<String> listFiles(){
        ArrayList<String> files = new ArrayList<String>();
        Field[] fields = R.raw.class.getFields();
        for(int count=0; count < fields.length; count++){
            files.add(fields[count].getName());
        }
        return files;
    }

    /**
     public void addSpinner(){
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
     }

     public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
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
     */
}
