package com.nirmitthummar.practical_3_loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName);
        password =findViewById(R.id.Password);
    }

    public void loginActivity(View view){
        String uname = editText.getText().toString();
        String pass = password.getText().toString();
        if(uname.equals("") || pass.equals("")){
            Toast.makeText(this, "Enter Username & Password", Toast.LENGTH_SHORT).show();
        }
        else {
            if (uname.equals("Nirmit") && pass.equals("nirmit")){
                // Toast.makeText(this, "Valid Username & Password", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Login Successful...", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Invalid Username & Password", Toast.LENGTH_SHORT).show();
            }
        }
    }
}