package nwd.a00908773.comp3717.bcit.ca.nwd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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
