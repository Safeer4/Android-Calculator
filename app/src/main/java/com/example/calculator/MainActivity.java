package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button btn;

    double operand1, operand2, add = 0, subtract = 0, multiply = 0, divide = 0, result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void digit(View view) {

        text = (TextView)findViewById(R.id.view);
        String currentText = text.getText().toString();

        btn = (Button)view;
        String btnValue = btn.getText().toString();

        if (currentText != "" && currentText.length() < 12)
        {
            if (Double.parseDouble(currentText) != 0)
            {
                text.setText(currentText + btnValue);
            }
            else
            {
                text.setText(btnValue);
            }

        }
        else if(currentText.length() != 12)
        {
            text.setText(btnValue);
        }


    }

    public void clear(View view) {
        operand1 = operand2 = add = subtract = multiply = divide = 0;
        text = (TextView)findViewById(R.id.view);
        text.setText("");
    }

    public void operator(View view)
    {
        text = (TextView)findViewById(R.id.view);
        String currentText = text.getText().toString();

        if (currentText != "")
        {
            if (view.getId() == R.id.add)
            {
                if (add == 0)
                {
                    operand1 = Double.parseDouble(currentText);
                    text.setText("");
                    add = 1;
                }

            }

            if (view.getId() == R.id.subtract)
            {
                if (subtract == 0)
                {
                    operand1 = Double.parseDouble(currentText);
                    text.setText("");
                    subtract = 1;
                }

            }

            if (view.getId() == R.id.multiply)
            {
                if (multiply == 0)
                {
                    operand1 = Double.parseDouble(currentText);
                    text.setText("");
                    multiply = 1;
                }

            }

            if (view.getId() == R.id.divide)
            {
                if (divide == 0)
                {
                    operand1 = Double.parseDouble(currentText);
                    text.setText("");
                    divide = 1;
                }

            }
        }




        if (view.getId() == R.id.equals && currentText != "")
        {
            if (add == 1)
            {
                operand2 = Double.parseDouble(currentText);
                result = operand1 + operand2;
                text.setText(result <=999999999999.0 ? String.format("%.2f", result) : "Error");
            }
            else if (subtract == 1)
            {
                operand2 = Double.parseDouble(currentText);
                result = operand1 - operand2;
                text.setText(result <=999999999999.0 ? String.format("%.2f", result) : "Error");
            }
            else if (multiply == 1)
            {
                operand2 = Double.parseDouble(currentText);
                result = operand1 * operand2;
                text.setText(result <=999999999999.0 ? String.format("%.2f", result) : "Error");
            }
            else if (divide == 1)
            {
                operand2 = Double.parseDouble(currentText);
                result = operand1 / operand2;
                text.setText(result <=999999999999.0 ? String.format("%.2f", result) : "Error");
            }
            operand1 = operand2 = add = subtract = multiply = divide = 0;
        }
    }
}