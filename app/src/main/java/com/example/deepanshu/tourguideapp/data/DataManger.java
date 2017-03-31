package com.example.deepanshu.tourguideapp.data;

import android.content.Context;

import com.example.deepanshu.tourguideapp.R;

import java.util.HashMap;

/**
 * Created by deepanshu on 31/3/17.
 */

public class DataManger {
    private static final DataManger sDATA_MANGER = new DataManger();
    private Context context;

    private HashMap<String, Data> dataMapList = new HashMap<>();

    public static DataManger getInstance() {
        return sDATA_MANGER;
    }

    private DataManger() {
    }

    public void init(Context context) {
        this.context = context;
    }

    public void addSampleData() {
        dataMapList.put(getString(R.string.one_name),
                getValue(R.drawable.hotel1, R.string.one_name, R.string.one_hotel,
                        R.string.one_date, R.string.one_bed, R.string.one_adult,
                        R.string.one_children, R.string.one_address)
        );
        dataMapList.put(getString(R.string.two_name),
                getValue(R.drawable.hotel2, R.string.two_name, R.string.two_hotel,
                        R.string.two_date, R.string.two_bed, R.string.two_adult,
                        R.string.two_children, R.string.two_address)
        );
        dataMapList.put(getString(R.string.three_name),
                getValue(R.drawable.hotel3, R.string.three_name, R.string.three_hotel,
                        R.string.three_date, R.string.three_bed, R.string.three_adult,
                        R.string.three_children, R.string.three_address)
        );
        dataMapList.put(getString(R.string.four_name),
                getValue(R.drawable.hotel4, R.string.four_name, R.string.four_hotel,
                        R.string.four_date, R.string.four_bed, R.string.four_adult,
                        R.string.four_children, R.string.four_address)
        );
        dataMapList.put(getString(R.string.five_name),
                getValue(R.drawable.hotel5, R.string.five_name, R.string.five_hotel,
                        R.string.five_date, R.string.five_bed, R.string.five_adult,
                        R.string.five_children, R.string.five_address)
        );
    }

    /**
     * To get info detail for detail activity
     * @param imageId - id of image
     * @param cityId - id of city name
     * @param hotelId - id of hotel
     * @param dateId - id of date
     * @param bedId -  id of bed
     * @param adultId - id of adult
     * @param childId - id of children
     * @param addressId - id of address
     * @return - return the Data Object
     */
    private Data getValue(int imageId, int cityId, int hotelId, int dateId,
                          int bedId, int adultId, int childId, int addressId) {
        return new Data(
                imageId,
                getString(cityId),
                getString(hotelId),
                getString(dateId),
                getString(bedId),
                getString(adultId),
                getString(childId),
                getString(addressId)
        );
    }

    /**
     * To extract the string from resource
     * @param ids - take id to get string
     * @return - return the string according to their ids
     */
    private String getString(int ids) {
        return context.getString(ids);
    }

    /**
     * To get sample data hash map
     * @return -  reutrn hashmap list
     */
    public HashMap<String, Data> getSampleData() {
        return dataMapList;
    }
}
