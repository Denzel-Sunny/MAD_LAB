package com.example.sjcet.q1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.Toast;

public class activity2 extends AppCompatActivity {

    TextView text_username, text_enail;
    Button btnLogOut;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mtpref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        text_username = findViewById(R.id.text_username);
        text_enail = findViewById(R.id.text_email);
        btnLogOut = findViewById(R.id.btnLogOut);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);

        if (name != null || email != null) {

            text_username.setText("Name: "+name);
            text_enail.setText("Email: "+email);
        }

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                Toast.makeText(activity2.this, "Log Out Successful", Toast.LENGTH_SHORT).show();
            }
        });




    }
}
