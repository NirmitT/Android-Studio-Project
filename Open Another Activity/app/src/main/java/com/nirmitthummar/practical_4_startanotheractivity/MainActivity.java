package com.nirmitthummar.practical_4_startanotheractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bt;
    TextView et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void clickOnterActivity(View view){
        bt = findViewById(R.id.button);
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        et = findViewById(R.id.editTextTextPersonName);
        String st = et.getText().toString();
        intent.putExtra("value", st);
        startActivity(intent);
    }
}