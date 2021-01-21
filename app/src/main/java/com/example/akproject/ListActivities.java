package com.example.akproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivities extends AppCompatActivity {

    private static final String TAG = "ListDataActivity";
    DataBaseHelper dataBaseHelper;
    private ListView listView;
    private Button back, backToMenu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activities);
        listView = (ListView)findViewById(R.id.listView);
        dataBaseHelper = new DataBaseHelper(this);
        back = (Button)findViewById(R.id.backBtn);
        backToMenu = (Button)findViewById(R.id.backToMenuBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivities.this, ToDoActivity.class);
                startActivity(intent);
            }
        });
        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivities.this, MainActivity.class);
                startActivity(intent);
            }
        });
        showList();

    }

    private void showList() {
        Log.d(TAG, "Date: ");
        Cursor data = dataBaseHelper.getData();
        ArrayList<String> list = new ArrayList<>();
        while (data.moveToNext()){
            list.add(data.getString(1));
        }
        final ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = parent.getItemAtPosition(position).toString();
                Log.d(TAG, "Clicked: " + name);
                Cursor data = dataBaseHelper.getId(name);
                int idData = -1;
                while(data.moveToNext()){
                    idData = data.getInt(0);
                }
                if(idData > -1){
                    Log.d(TAG, "ID: " + idData);
                    Intent editActivity = new Intent(ListActivities.this, EditActivity.class);
                    editActivity.putExtra("id", idData);
                    editActivity.putExtra("name", name);
                    startActivity(editActivity);
                }else {
                    toastMessage("Invalid ID");
                }
            }
        });
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}