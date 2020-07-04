package com.example.constantinekim.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> countries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        GridView gridView = findViewById(R.id.grid_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, countries);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                makeToast(parent.getItemAtPosition(position).toString());
            }
        });
    }

    private void makeToast(String value) {
        Toast.makeText(this, value + " selected", Toast.LENGTH_LONG).show();
    }

    private void initialize() {
        countries.add("Great Britain");
        countries.add("Sweden");
        countries.add("Austria");
        countries.add("Germany");
        countries.add("Russia");
        countries.add("China");
        countries.add("Canada");
        countries.add("UAE");

        Collections.sort(countries);
    }
}