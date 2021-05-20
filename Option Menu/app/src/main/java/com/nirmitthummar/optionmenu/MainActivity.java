package com.nirmitthummar.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.file){
            Toast.makeText(this, "File", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (itemId == R.id.open){
            Toast.makeText(this, "Open", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (itemId == R.id.save){
            Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (itemId == R.id.sav){
            Toast.makeText(this, "Save As", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (itemId == R.id.edit){
            Toast.makeText(this, "Edit", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (itemId == R.id.view){
            Toast.makeText(this, "View", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}