package com.example.akproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ToDoActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    DataBaseHelper dataBaseHelper;
    private Button adBtn, showBtn;
    private EditText userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);
        adBtn = (Button)findViewById(R.id.todoAdd);
        showBtn = (Button)findViewById(R.id.todoShow);
        userInput = (EditText)findViewById(R.id.todoInput);
        dataBaseHelper = new DataBaseHelper(this);

        adBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entry = userInput.getText().toString();
                if(!(entry.equals(""))){
                    AddData(entry);
                    userInput.setText("");
                } else {
                    toastMessage("Invalid value!");
                }
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ToDoActivity.this, ListActivities.class);
                startActivity(intent);
            }
        });
    }

    public void AddData(String text){
        boolean date = dataBaseHelper.addData(text);
        if(date){
            toastMessage("Add successfully");
        } else {
            toastMessage("Ups something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}