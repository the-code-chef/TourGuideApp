package com.example.deepanshu.tourguideapp.detail;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.deepanshu.tourguideapp.R;
import com.example.deepanshu.tourguideapp.data.Data;
import com.example.deepanshu.tourguideapp.data.DataManger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetailActivity extends Activity implements View.OnClickListener {

    LinearLayout location;
    ImageView image;
    TextView city;
    TextView hotel;
    TextView date;
    TextView bed;
    TextView adult;
    TextView children;
    TextView address;
    TextView changeLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        location = (LinearLayout) findViewById(R.id.location);
        image = (ImageView) findViewById(R.id.image);
        city = (TextView) findViewById(R.id.city);
        hotel = (TextView) findViewById(R.id.hotel);
        date = (TextView) findViewById(R.id.dates);
        bed = (TextView) findViewById(R.id.bed);
        adult = (TextView) findViewById(R.id.adult);
        children = (TextView) findViewById(R.id.children);
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
        hotel.append(" Hotels");
        date.setText(data.getDate());
        bed.setText(data.getBed());
        adult.setText(data.getAdult());
        children.setText(data.getChildren());
        address.setText(data.getAddress());
    }

    @Override
    public void onClick(View v) {

        List<String> stringList = new ArrayList<>(DataManger.getInstance().getSampleData().keySet());

        final CharSequence[] items = new CharSequence[stringList.size()];

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Change Your Location");
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