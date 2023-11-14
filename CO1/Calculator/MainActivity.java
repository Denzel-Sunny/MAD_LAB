package com.example.sjcet.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2;
    TextView tv1;
    double num1, num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        tv1 = findViewById(R.id.tv1);
    }

    public void ADD(View view) {
        String num1str = ed1.getText().toString();
        String num2str = ed2.getText().toString();

        if (!num1str.isEmpty() && !num2str.isEmpty()){
            double num1 = Double.parseDouble(num1str);
            double num2 = Double.parseDouble(num2str);
            double result = num1 + num2;
            tv1.setText(String.valueOf(result));
        } else {
            tv1.setText("Result: Invalid Input!!!");
        }
    }

    public void SUB(View view) {
        String num1str = ed1.getText().toString();
        String num2str = ed2.getText().toString();

        if (!num1str.isEmpty() && !num2str.isEmpty()){
            double num1 = Double.parseDouble(num1str);
            double num2 = Double.parseDouble(num2str);
            double result = num1 - num2;
            tv1.setText(String.valueOf(result));
        } else {
            tv1.setText("Result: Invalid Input!!!");
        }
    }

    public void MULT(View view) {
        String num1str = ed1.getText().toString();
        String num2str = ed2.getText().toString();

        if (!num1str.isEmpty() && !num2str.isEmpty()){
            double num1 = Double.parseDouble(num1str);
            double num2 = Double.parseDouble(num2str);
            double result = num1 * num2;
            tv1.setText(String.valueOf(result));
        } else {
            tv1.setText("Result: Invalid Input!!!");
        }
    }

    public void DIV(View view) {
        String num1str = ed1.getText().toString();
        String num2str = ed2.getText().toString();

        if (!num1str.isEmpty() && !num2str.isEmpty()) {
            double num1 = Double.parseDouble(num1str);
            double num2 = Double.parseDouble(num2str);

            if (num2 != 0) {
                double result = num1 / num2;
                tv1.setText(String.valueOf(result));
            } else {
                tv1.setText("Result: Invalid Input");
            }
        }
    }
}
