package com.example.akproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button zero,one,two,three,four,five,six,seven,eight,nine,plusMinus,comma,equals,plus,minus,divide,multiply,percentage,brackets,delete;
    private TextView output;
    CalculatorHelper calculatorHelper = new CalculatorHelper();
    float firstInput = 0, secondInput = 0;
    boolean add, min, div, mul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        zero = (Button)findViewById(R.id.calc0Btn);
        one = (Button)findViewById(R.id.calc1Btn);
        two = (Button)findViewById(R.id.calc2Btn);
        three = (Button)findViewById(R.id.calc3Btn);
        four = (Button)findViewById(R.id.calc4Btn);
        five = (Button)findViewById(R.id.calc5Btn);
        six = (Button)findViewById(R.id.calc6Btn);
        seven = (Button)findViewById(R.id.calc7Btn);
        eight = (Button)findViewById(R.id.calc8Btn);
        nine = (Button)findViewById(R.id.calc9Btn);
        plusMinus = (Button)findViewById(R.id.calcPlusMinusBtn);
        comma = (Button)findViewById(R.id.calcCommaBtn);
        equals = (Button)findViewById(R.id.calcEqualsBtn);
        plus = (Button)findViewById(R.id.calcPlusBtn);
        minus = (Button)findViewById(R.id.calcMinusBtn);
        divide = (Button)findViewById(R.id.calcDivisionBtn);
        multiply = (Button)findViewById(R.id.calcMultiplyBtn);
        percentage = (Button)findViewById(R.id.calcPercentageBtn);
        brackets = (Button)findViewById(R.id.calcBracketsBtn);
        delete = (Button)findViewById(R.id.calcCBtn);
        output = (TextView)findViewById(R.id.calcOutput);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        delete.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiply.setOnClickListener(this);
        equals.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.calc0Btn :
                calculatorHelper.concatenateNumbers(output, "0");
                break;
            case R.id.calc1Btn:
                calculatorHelper.concatenateNumbers(output, "1");
                break;
            case R.id.calc2Btn:
                calculatorHelper.concatenateNumbers(output, "2");
                break;
            case R.id.calc3Btn:
                calculatorHelper.concatenateNumbers(output, "3");
                break;
            case R.id.calc4Btn:
                calculatorHelper.concatenateNumbers(output, "4");
                break;
            case R.id.calc5Btn:
                calculatorHelper.concatenateNumbers(output, "5");
                break;
            case R.id.calc6Btn:
                calculatorHelper.concatenateNumbers(output, "6");
                break;
            case R.id.calc7Btn:
                calculatorHelper.concatenateNumbers(output, "7");
                break;
            case R.id.calc8Btn:
                calculatorHelper.concatenateNumbers(output, "8");
                break;
            case R.id.calc9Btn:
                calculatorHelper.concatenateNumbers(output, "9");
                break;
            case R.id.calcCBtn:
                calculatorHelper.deleteAll(output);
                break;
            case R.id.calcPlusBtn:
                firstInput = calculatorHelper.addToFirstVariable(firstInput, output);
                add = true;
                calculatorHelper.setTextNull(output);
                break;
            case R.id.calcMinusBtn:
                firstInput = calculatorHelper.addToFirstVariable(firstInput, output);
                min = true;
                calculatorHelper.setTextNull(output);
                break;
            case R.id.calcDivisionBtn:
                firstInput = calculatorHelper.addToFirstVariable(firstInput, output);
                div = true;
                calculatorHelper.setTextNull(output);
                break;
            case R.id.calcMultiplyBtn:
                firstInput = calculatorHelper.addToFirstVariable(firstInput, output);
                mul = true;
                calculatorHelper.setTextNull(output);
                break;
            case R.id.calcEqualsBtn:
                secondInput = calculatorHelper.addToSecondVariable(secondInput, output);
                if(calculatorHelper.checkCondition(add)){
                    output = calculatorHelper.addValues(firstInput, secondInput, output);
                    add = false;
                } else if(calculatorHelper.checkCondition(min)){
                    output = calculatorHelper.minusValues(firstInput, secondInput, output);
                    min = false;
                } else if(calculatorHelper.checkCondition(mul)){
                    output = calculatorHelper.multiplyValues(firstInput, secondInput, output);
                    mul = false;
                } else {
                    output = calculatorHelper.divideValues(firstInput, secondInput, output);
                    div = false;
                }
                break;
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}