package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class menuListe extends AppCompatActivity {

    public final static String[] meinStringArray = {"Dein Kopd", "ETc", "keine Ahnung"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_liste);
        listeFuellen();
    }

    private void listeFuellen(){
        ListView unsereListe = findViewById(R.id.listView);
        ArrayAdapter<String> meinAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, meinStringArray);
        unsereListe.setAdapter(meinAdapter);
    }
}
