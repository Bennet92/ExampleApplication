package com.example.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class menuDynamischeListe extends AppCompatActivity {

   public ArrayList<String> meineDynamischeListe = new ArrayList<String>();
   public ArrayAdapter<String> unserAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_dynamische_liste);

        //UI Elemente
        ListView unsereListe = (ListView) findViewById(R.id.dynamicList);
        Button unserKnopf = (Button) findViewById(R.id.button);
        EditText unsereEingabe = (EditText) findViewById(R.id.editText);

        unserAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, meineDynamischeListe);
        unsereListe.setAdapter(unserAdapter);
    }


    public void knopfWurdeGedrueckt(View view){
        EditText unsereEingabe = (EditText) findViewById(R.id.editText);
        ListView unsereListe = (ListView) findViewById(R.id.dynamicList);
        meineDynamischeListe.add(unsereEingabe.getText().toString());
        unserAdapter.notifyDataSetChanged();
    }

}
