package com.example.exampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {



    private static final String TAG = "MyActivity";
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void sendMessage(View view) throws InterruptedException {
        //log.i(TAG, "index=" + nr);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    warten();
                    Button button = (Button) findViewById(R.id.button);
                    button.setText("Gedrückt!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void warten() throws InterruptedException {
        synchronized (this){
            wait(5000);
        }
    }
}
