package com.example.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class sensorenList extends AppCompatActivity {

    private SensorManager mSensorManager;
    private List<Sensor> meineSensoren = null;
    private ArrayAdapter<String> meinAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensoren_list);

        ListView meineListe = (ListView) findViewById(R.id.sensorenListView);
        List<String> meineSauberenSensoren = new ArrayList<String>();


        meineSensoren = getSensorenListe();


        for (Sensor sensor : meineSensoren) {
            meineSauberenSensoren.add(sensor.getName());
        }


        //System.out.println("Sensoren: " + meineSensoren.toString());
        meinAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, meineSauberenSensoren);
        meineListe.setAdapter(meinAdapter);

    }

    public List<Sensor> getSensorenListe(){
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //meineSensoren = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        //meineSensoren = mSensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        meineSensoren = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        return meineSensoren;
    }
}
