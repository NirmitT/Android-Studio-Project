package com.nirmitthummar.practical_9_crud_sqlitedatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_ID,et_Name,et_Email;
    Button btn_Add, btn_View, btn_Update, btn_Delete;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new  DatabaseHelper(this);
        et_ID = findViewById(R.id.et_ID);
        et_Name = findViewById(R.id.et_Name);
        et_Email = findViewById(R.id.et_Email);
        btn_Add = findViewById(R.id.btn_Add);
        btn_View = findViewById(R.id.btn_View);
        btn_Update = findViewById(R.id.btn_Update);
        btn_Delete = findViewById(R.id.btn_Delete);

        addData();
        readData();
        updateData();
        deleteData();
    }
    private void addData() {
        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isAdded = databaseHelper.insertData(et_Name.getText().toString(),et_Email.getText().toString());
                if (isAdded==true){
                    Toast.makeText(MainActivity.this,"Data Added Successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Data not Added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void readData() {
        btn_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = databaseHelper.getData();
                if(c.getCount()==0){
                    showMessage("Error","Not Record Found");
                    return;
                }
                StringBuffer stringBuffer=new StringBuffer();
                while (c.moveToNext()){
                    stringBuffer.append("ID:"+c.getString(0)+"\n");
                    stringBuffer.append("NAME:"+c.getString(1)+"\n");
                    stringBuffer.append("EMAIL:"+c.getString(2)+"\n");
                }
                showMessage("Record",stringBuffer.toString());
            }


        });
    }

    private void showMessage(String title, String Message) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    private void updateData() {
        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated = databaseHelper.updateData(
                        et_ID.getText().toString(),
                        et_Name.getText().toString(),
                        et_Email.getText().toString());
                if(isUpdated == true){
                    Toast.makeText(MainActivity.this, "Record is Updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "No Record Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void deleteData() {
        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer row=databaseHelper.deleteData(et_ID.getText().toString());
                if(row>0){
                    Toast.makeText(MainActivity.this, "Record is Deleted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Record not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void clearData(View view){
        et_ID.setText("");
        et_Name.setText("");
        et_Email.setText("");
    }
}