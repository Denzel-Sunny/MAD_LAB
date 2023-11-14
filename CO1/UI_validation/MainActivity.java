package com.example.sjcet.uivalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    TextView tvUsernameError, tvPasswordError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        tvUsernameError = findViewById(R.id.tvUsernameError);
        tvPasswordError = findViewById(R.id.tvPasswordError);

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateInput();
            }
        });

    }

    private void validateInput() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        boolean isValid = true;

        // Validate username
        if (username.isEmpty()) {
            tvUsernameError.setText("Username is required");
            isValid = false;
        } else {
            tvUsernameError.setText("");
        }

        // Validate password
        if (password.isEmpty()) {
            tvPasswordError.setText("Password is required");
            isValid = false;
        } else if (password.length() < 6) {
            tvPasswordError.setText("Password must be at least 6 characters");
            isValid = false;
        } else {
            tvPasswordError.setText("");
        }

        if (isValid) {
            // Perform further actions if input is valid
            // For example, you can submit the data or navigate to another screen
        }
    }
}
