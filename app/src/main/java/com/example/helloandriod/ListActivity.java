package com.example.helloandriod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
    ListView listview;
    TextView textView;
    String[] listitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listview= (ListView)findViewById(R.id.listview);
        listitem=getResources().getStringArray(R.array.array_technology);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.my_list, R.id.textView, listitem);
        listview.setAdapter(adapter);
    }
}