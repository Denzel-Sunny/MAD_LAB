package com.example.sjcet.calc;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private String currentInput = "";
    private String operator = "";
    private double firstOperand = 0;
    private double secondOperand = 0;
    private boolean isNewInput = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing textview
        textView = findViewById(R.id.textview);

        // initializing gridlayout
        GridLayout gridLayout = findViewById(R.id.gridLayout);

        // define button labels
        String[] buttonlabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+",
        };

        // create and add buttons to gridlayout
        for (String label : buttonlabels){
            Button button = new Button(this);
            button.setText(label);
            button.setTextSize(24);
            button.setOnClickListener(this);
            gridLayout.addView(button);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String buttonText = button.getText().toString();

        switch (buttonText) {
            case "=":
                calculateResult();
                break;
            case "C":
                clearInput();
                break;
            default:
                handleInput(buttonText);
                break;
        }
    }

    private void handleInput(String input) {
        if (isNewInput) {
            currentInput = input;
            isNewInput = false;
        } else {
            currentInput += input;
        }
        updateDisplay();
    }

    private void clearInput() {
        currentInput = "";
        operator = "";
        firstOperand = 0;
        secondOperand = 0;
        isNewInput = true;
        updateDisplay();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void calculateResult() {
        if (!isNewInput) {
            String expression = currentInput;
            try {
                // Use JavaScript eval() to evaluate the expression
                WebView webView = new WebView(this);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.addJavascriptInterface(new Object() {
                    @JavascriptInterface
                    public void processHTML(String html) {
                        // Process the result returned from JavaScript
                        currentInput = html;
                        isNewInput = true;
                        updateDisplay();
                    }
                }, "Android");

                webView.evaluateJavascript("javascript:Android.processHTML(eval('" + expression + "'))", null);
            } catch (Exception e) {
                currentInput = "Error: Invalid expression";
                isNewInput = true;
                updateDisplay();
            }
        }
    }



    private void updateDisplay() {
        textView.setText(currentInput);
    }
}

