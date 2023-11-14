package com.example.sjcet.q1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText etUsername, etEmail;
    Button btnRegister;
    SharedPreferences sharedPreferences;

    // create a shared preferences name and create a key name

    private static final String SHARED_PREF_NAME = "mtpref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        btnRegister = findViewById(R.id.btnRegister);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        // when open activity check if shared pref data available or not

        String name = sharedPreferences.getString(KEY_NAME,null);

        if(name != null){
            // if data available directly call
            Intent intent = new Intent(MainActivity.this,activity2.class);
            startActivity(intent);
        }

        btnRegister.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // when click put data in shared preferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME,etUsername.getText().toString());
                editor.putString(KEY_EMAIL,etEmail.getText().toString());
                editor.apply();

                Intent intent = new Intent(MainActivity.this,activity2.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();


            }
        });



            }
}





