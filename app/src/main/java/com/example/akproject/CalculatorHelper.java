package com.example.akproject;

import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class CalculatorHelper extends AppCompatActivity {

    float firstNumber = 0, secondNumber = 0, equal = 0;


    public void deleteAll(TextView textView){
        textView.setText("");
        textView.setHint("0");
    }

    public float addToFirstVariable(float v, TextView textView) {
        String temp;
        temp = textView.getText().toString();
        v = Float.parseFloat(temp);
        return v;
    }

    public float addToSecondVariable(float v, TextView textView){
        String temp;
        temp = textView.getText().toString();
        v = Float.parseFloat(temp);
        return v;
    }

    public boolean changeIntoTruthy(boolean b){
        b = true;
        return b;
    }

    public void setTextNull(TextView text){
        text.setText(null);
    }

    public void concatenateNumbers(TextView textView, String number){
        textView.setText(textView.getText() + number);
    }

    public boolean checkCondition(boolean bool){
        if(bool){
            return true;
        } else {
            return false;
        }
    }


    public TextView addValues(float a, float b, TextView textView){
        textView.setText(String.valueOf(a + b));
        return textView;
    }

    public TextView minusValues(float a, float b, TextView textView){
        textView.setText(String.valueOf(a - b));
        return textView;
    }

    public TextView multiplyValues(float a, float b, TextView textView){
        textView.setText(String.valueOf(a * b));
        return textView;
    }

    public TextView divideValues(float a, float b, TextView textView){
        if (a == 0 || b == 0){
            textView.setText("");
            textView.setHint("0");
        }else {
            textView.setText(String.valueOf(a / b));
        }
        return textView;
    }

}
