package com.example.deepanshu.tourguideapp.foodcourt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.deepanshu.tourguideapp.R;
import com.example.deepanshu.tourguideapp.adapter.HomelistViewAdapter;
import com.example.deepanshu.tourguideapp.data.Data;
import com.example.deepanshu.tourguideapp.data.DataManger;
import com.example.deepanshu.tourguideapp.detail.DetailActivity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by deepanshu on 4/4/17.
 */

public class FoodCourt extends Fragment {

    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_court, container, false);
        mListView = (ListView) view.findViewById(R.id.partyplacelistview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DataManger.getInstance().init(getActivity());
        DataManger.getInstance().addSampleData();

        // get Hash Map Data
        final HashMap<String, Data> dataHashMap = DataManger.getInstance().getSampleData();

        final ArrayList<Data> sampleDataListValue = new ArrayList<>();

        // get all keys
        for (String key : dataHashMap.keySet()) {
            sampleDataListValue.add(dataHashMap.get(key));
        }

        // Set Adapter
        HomelistViewAdapter homelistViewAdapter = new HomelistViewAdapter(
                getActivity(), sampleDataListValue
        );
        mListView.setAdapter(homelistViewAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(getString(R.string.share_intent), sampleDataListValue.get(i).getCity());
                startActivity(intent);
            }
        });
    }
}
