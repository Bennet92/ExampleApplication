package com.example.exampleapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartThreadActivity extends AppCompatActivity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_thread);
    }

    public void run2(View view){
        run();
    }
    @Override
    public void run() {
        try {
            appNotResp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TextView textView = findViewById(R.id.textView2);
        if (textView.getText() == "UI Änderung"){
            textView.setText("UI Änderung 2");
        }else{
            textView.setText("UI Änderung");
        }
    }
    public void appNotResp() throws InterruptedException {
        synchronized (this){
            wait(6000);
        }
    }
}