package com.example.sjcet.a3q1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        final List<String> data = fetchData();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    String item = data.get(position);
                    // Handle item click
                    Toast.makeText(MainActivity.this, "Clicked: " + item, Toast.LENGTH_SHORT).show();
                } catch (IndexOutOfBoundsException e) {
                    // Handle the exception
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Item not found", Toast.LENGTH_SHORT).show();
                }
            }
    });
}

    private List<String> fetchData() {
        List<String> data = new ArrayList<>();
        // Populate the data list here
        data.add("Item 1");
        data.add("Item 2");
        data.add("Item 3");
        return data;

    }
}

