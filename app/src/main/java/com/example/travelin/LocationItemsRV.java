package com.example.travelin;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class LocationItemsRV implements Parcelable {
    private String locationCity;
    private String locationDetails;

    protected LocationItemsRV(Parcel in){
        locationCity = in.readString();
        locationDetails = in.readString();
    }

    public static final Creator<LocationItemsRV> CREATOR = new Creator<LocationItemsRV>() {
        @Override
        public LocationItemsRV createFromParcel(Parcel in) {
            return new LocationItemsRV(in);
        }

        @Override
        public LocationItemsRV[] newArray(int size) {
            return new LocationItemsRV[size];
        }
    };

    public LocationItemsRV(){}
    public LocationItemsRV(String locationCity, String locationDetails) {
        this.locationCity = locationCity;
        this.locationDetails = locationDetails;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(String locationDetails) {
        this.locationDetails = locationDetails;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(locationCity);
        dest.writeString(locationDetails);
    }
}
