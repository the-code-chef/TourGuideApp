package com.example.deepanshu.tourguideapp.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {

    private int image;
    private String city;
    private String hotel;
    private String date;
    private String bed;
    private String adult;
    private String children;
    private String address;

    Data(int image, String city, String hotel) {
        this.image = image;
        this.city = city;
        this.hotel = hotel;
    }

    Data(int image, String city, String hotel, String date, String bed,
         String adult, String children, String address) {
        this.image = image;
        this.city = city;
        this.hotel = hotel;
        this.date = date;
        this.bed = bed;
        this.adult = adult;
        this.children = children;
        this.address = address;
    }

    public int getImage() {
        return image;
    }

    public String getCity() {
        return city;
    }

    public String getHotel() {
        return hotel;
    }

    public String getDate() {
        return date;
    }

    public String getBed() {
        return bed;
    }

    public String getAdult() {
        return adult;
    }

    public String getChildren() {
        return children;
    }

    public String getAddress() {
        return address;
    }

    protected Data(Parcel in) {
        image = in.readInt();
        city = in.readString();
        hotel = in.readString();
        date = in.readString();
        bed = in.readString();
        adult = in.readString();
        children = in.readString();
        address = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Storing the Student data to Parcel object
     *
     * @param parcel
     * @param i
     */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeString(city);
        parcel.writeString(hotel);
        parcel.writeString(date);
        parcel.writeString(bed);
        parcel.writeString(adult);
        parcel.writeString(children);
        parcel.writeString(address);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}

