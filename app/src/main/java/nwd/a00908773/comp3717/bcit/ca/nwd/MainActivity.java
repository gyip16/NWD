package nwd.a00908773.comp3717.bcit.ca.nwd;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        PieChart pchart = (PieChart) findViewById(R.id.pChart);

        String desc = "What shall we do with the drunken sailor?";

        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(15.0f, "Shave his belly with a rusty razor"));
        entries.add(new PieEntry(25.0f, "Put him in a long boat til he's sober"));
        entries.add(new PieEntry(50.0f, "Stick him in a scupper with a horsepipe on him"));
        entries.add(new PieEntry(10.0f, "Put him in the bed with the captain's daughter"));

        PieChartHandler pch = new PieChartHandler(pchart, entries, desc, 2);

        pch.drawChart();




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

}
