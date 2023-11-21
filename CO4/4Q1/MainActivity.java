package com.example.sjcet.a4q1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = findViewById(R.id.gridView);
        final List<String> data = fetchData();


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);


        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    String item = data.get(position);

                    Toast.makeText(MainActivity.this, "Clicked " + item, Toast.LENGTH_SHORT).show();
                }
                catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Item not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private List<String> fetchData() {
        List<String> data = new ArrayList<>();

        data.add("Item 1");
        data.add("Item 2");
        data.add("Item 3");
        data.add("Item 4");

        return data;
    }
}
