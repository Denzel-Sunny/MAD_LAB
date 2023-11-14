package com.example.sjcet.imagetoggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView img;
    boolean flg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.btn);
        img = (ImageView) findViewById(R.id.img);
        btn.setOnClickListener(this);
        flg = false;
    }

    @Override
    public void onClick(View v) {
        if (flg) {
            img.setImageResource(R.drawable.skytower_model);
            flg = false;
        }
        else{
            img.setImageResource(R.drawable.ternarytower);
            flg = true;
        }


    }
}
