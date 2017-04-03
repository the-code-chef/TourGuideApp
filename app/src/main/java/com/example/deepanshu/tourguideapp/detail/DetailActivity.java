package com.example.deepanshu.tourguideapp.detail;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.deepanshu.tourguideapp.R;
import com.example.deepanshu.tourguideapp.data.Data;
import com.example.deepanshu.tourguideapp.data.DataManger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailActivity extends Activity implements View.OnClickListener {

    private ImageView image;
    private TextView city;
    private TextView hotel;
    private TextView date;
    private TextView bed;
    private TextView adult;
    private TextView children;
    private TextView address;
    private ListView restaurentList;
    private TextView changeLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        LinearLayout location = (LinearLayout) findViewById(R.id.location);
        image = (ImageView) findViewById(R.id.image);
        city = (TextView) findViewById(R.id.city);
        hotel = (TextView) findViewById(R.id.hotel);
        date = (TextView) findViewById(R.id.dates);
        bed = (TextView) findViewById(R.id.bed);
        adult = (TextView) findViewById(R.id.adult);
        children = (TextView) findViewById(R.id.children);
        restaurentList = (ListView) findViewById(R.id.restaurent_list);
        address = (TextView) findViewById(R.id.address);
        changeLocation = (TextView) findViewById(R.id.changeLocation);

        location.setOnClickListener(this);

        setValues(DataManger.getInstance().getSampleData()
                .get(getIntent().getExtras().getString(getString(R.string.share_intent)))
        );
    }

    private void setValues(Data data) {
        image.setImageResource(data.getImage());
        city.setText(data.getCity());
        hotel.setText(data.getHotel());
        hotel.append(getString(R.string.append_hotels));
        date.setText(data.getDate());
        bed.setText(data.getBed());
        adult.setText(data.getAdult());
        children.setText(data.getChildren());
        address.setText(data.getAddress());

        String[] list = getList(data);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, R.layout.restaurent, list);
        restaurentList.setAdapter(stringArrayAdapter);
    }

    private String[] getList(Data data) {
        String[] restaurentList = null;

        switch (data.getCity()) {
            case "New York":
                restaurentList = getResources().getStringArray(R.array.one_restaurent);
                break;
            case "New Jersey":
                restaurentList = getResources().getStringArray(R.array.two_restaurent);
                break;
            case "New Hampshire":
                restaurentList = getResources().getStringArray(R.array.three_restaurent);
                break;
            case "Nebraska":
                restaurentList = getResources().getStringArray(R.array.fourth_restaurent);
                break;
            case "Washignton":
                restaurentList = getResources().getStringArray(R.array.fifth_restaurent);
                break;
        }

        return restaurentList;
    }

    @Override
    public void onClick(View v) {

        List<String> stringList = new ArrayList<>(DataManger.getInstance().getSampleData().keySet());

        final CharSequence[] items = stringList.toArray(new CharSequence[stringList.size()]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.change_your_hotel);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                // Do something with the selection
                DataManger.getInstance().getSampleData().keySet();
                changeLocation.setText(items[item]);

                // Update the values
                setValues(DataManger.getInstance().getSampleData().get(items[item].toString()));
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}