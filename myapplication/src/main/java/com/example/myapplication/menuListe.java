package com.example.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        ListView unsereListe = (ListView) findViewById(R.id.listView);
        final ArrayAdapter<String> meinAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, meinStringArray);
        unsereListe.setAdapter(meinAdapter);
        unsereListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //System.out.println("Funktioniert!");
                String item = (String) parent.getItemAtPosition(position);
                Snackbar snackbar = Snackbar.make(view, item + " an Position " + position + " wrude gedrückt. ", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
    }

}
