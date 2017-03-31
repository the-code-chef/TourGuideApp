package com.example.deepanshu.tourguideapp.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.deepanshu.tourguideapp.R;
import com.example.deepanshu.tourguideapp.data.Data;
import com.example.deepanshu.tourguideapp.data.DataManger;
import com.example.deepanshu.tourguideapp.detail.DetailActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        DataManger.getInstance().init(this);
        DataManger.getInstance().addSampleData();

        // Initialize and declare listview
        ListView listview = (ListView) findViewById(R.id.homelistview);

        // get Hash Map Data
        final HashMap<String, Data> dataHashMap = DataManger.getInstance().getSampleData();

        final ArrayList<Data> sampleDataListValue = new ArrayList<>();

        // get all keys
        for (String key : dataHashMap.keySet()) {
            sampleDataListValue.add(dataHashMap.get(key));
        }

        // Set Adapter
        HomelistViewAdapter homelistViewAdapter = new HomelistViewAdapter(
                HomeActivity.this, sampleDataListValue
        );
        listview.setAdapter(homelistViewAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
                intent.putExtra(getString(R.string.share_intent),
                        sampleDataListValue.get(i).getCity()
                );
                startActivity(intent);
            }
        });
    }
}
