package com.nirmitthummar.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.text);
        registerForContextMenu(tv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getGroupId();
        if (itemId == R.id.share){
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        }
        if (itemId == R.id.forward){
            Toast.makeText(this, "Forward", Toast.LENGTH_SHORT).show();
        }
        if (itemId == R.id.replay){
            Toast.makeText(this, "Replay", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}