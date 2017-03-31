package com.example.deepanshu.tourguideapp.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deepanshu.tourguideapp.R;
import com.example.deepanshu.tourguideapp.data.Data;

import java.util.ArrayList;

class HomelistViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Data> beanClassArrayList;

    HomelistViewAdapter(Context context, ArrayList<Data> beanClassArrayList) {
        this.context = context;
        this.beanClassArrayList = beanClassArrayList;
    }

    @Override
    public int getCount() {
        return beanClassArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return beanClassArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHoder viewHoder;
        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.home_listview, parent, false);

            viewHoder = new ViewHoder();

            viewHoder.city = (TextView) convertView.findViewById(R.id.city);
            viewHoder.hotel = (TextView) convertView.findViewById(R.id.hotel);
            viewHoder.image = (ImageView) convertView.findViewById(R.id.image);

            convertView.setTag(viewHoder);

        } else {

            viewHoder = (ViewHoder) convertView.getTag();
        }

        Data beanClass = (Data) getItem(position);

        viewHoder.city.setText(beanClass.getCity());
        viewHoder.hotel.setText(beanClass.getHotel());
        viewHoder.hotel.append(" Hotels");
        viewHoder.image.setImageResource(beanClass.getImage());

        return convertView;
    }

    private class ViewHoder {

        ImageView image;
        TextView city;
        TextView hotel;

    }
}
