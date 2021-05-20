package com.nirmitthummar.practical_7_autocompletetext_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    AutoCompleteTextView autoCompleteTextView;
    TextView textView;

    String [] name = {"Nirmit Thummar","Sanket Thummar","Rutvik Savaliya","Meet Dabhi", "Rushabh Donda","Devansh Tadhani","Darshak Kikani",
            "Raj Dhorajiya","Mit Vaghani","Jay Godhani"};

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        List<String> list = new ArrayList<String>();

        list.add("-- Select Branch --");
        list.add("Chemical Engineering");
        list.add("Information Technology");
        list.add("Mechanical Engineering");
        list.add("Electronics & Communications");
        list.add("Mechatronics Engineering");
        list.add("Computer Engineering");
        list.add("Electrical Engineering");
        list.add("Civil Engineering");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        textView = findViewById(R.id.textView2);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, name);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText("Hi, " + adapter.getItem(position));
            }
        });

    }
}