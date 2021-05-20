package com.nirmitthummar.popupmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ShowPopUp(View view){
        PopupMenu popupMenu =new PopupMenu(this,view);
        popupMenu.setOnMenuItemClickListener(this::onContextItemSelected);
        popupMenu.inflate(R.menu.popupmenu);
        popupMenu.show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getGroupId();
        if (itemId == R.id.save){
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        }
        if (itemId == R.id.forward){
            Toast.makeText(this, "Forward", Toast.LENGTH_SHORT).show();
        }
        if (itemId == R.id.reply){
            Toast.makeText(this, "Reply", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}