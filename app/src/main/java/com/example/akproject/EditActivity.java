package com.example.akproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    private static final String TAG = "EditDataActivity";
    private Button deleteBtn, updateBtn;
    private EditText editItem;

    DataBaseHelper dataBaseHelper;
    private String itemName;
    private int idName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        deleteBtn = (Button)findViewById(R.id.todoDeleteBtn);
        updateBtn = (Button)findViewById(R.id.todoUpdateBtn);
        editItem = (EditText)findViewById(R.id.edit_text);
        dataBaseHelper = new DataBaseHelper(this);

        Intent intent = getIntent();
        idName = intent.getIntExtra("id", -1);
        itemName = intent.getStringExtra("name");
        editItem.setText(itemName);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = editItem.getText().toString();
                if(!(item.equals(""))){
                    dataBaseHelper.updateData(item, idName, itemName);
                    refresh();
                } else {
                    toastMessage("Invalid input!");
                }
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBaseHelper.deleteData(idName, itemName);
                editItem.setText("");
                toastMessage("Removed from app and database");
                refresh();
            }
        });
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void refresh(){
        Intent intent1 = new Intent(this, ListActivities.class);
        finish();
        startActivity(intent1);
    }


}