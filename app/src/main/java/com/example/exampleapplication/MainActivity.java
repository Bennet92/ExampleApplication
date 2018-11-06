package com.example.exampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


        public void sendMessage(View view) {
            EditText editText = (EditText) findViewById(R.id.editText);
            String message = editText.getText().toString();
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }

        public void appNotResp(View view) throws InterruptedException {
            synchronized (this){
                wait(6);
            };
        }
    }
