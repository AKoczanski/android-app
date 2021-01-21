package com.example.akproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView calc, weat, todo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc = (CardView)findViewById(R.id.calculatorCard);
        weat = (CardView)findViewById(R.id.weatherCard);
        todo = (CardView)findViewById(R.id.todoCard);


        calc.setOnClickListener(this);
        weat.setOnClickListener(this);
        todo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.calculatorCard :
                intent = new Intent(this, CalculatorActivity.class);
                startActivity(intent);
                break;
            case R.id.weatherCard :
                intent = new Intent(this, WeatherActivity.class);
                startActivity(intent);
                break;
            case R.id.todoCard :
                intent = new Intent(this, ToDoActivity.class);
                startActivity(intent);
                break;
        }
    }
}