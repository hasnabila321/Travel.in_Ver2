package com.example.travelin;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class LocationItemsRV implements Parcelable {
    private String locationInput;
    private String locationDetails;

    protected LocationItemsRV(Parcel in){
        locationInput = in.readString();
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

    public LocationItemsRV(String locationInput, String locationDetails) {
        this.locationInput = locationInput;
        this.locationDetails = locationDetails;
    }

    public String getLocationInput() {
        return locationInput;
    }

    public void setLocationInput(String locationInput) {
        this.locationInput = locationInput;
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
        dest.writeString(locationInput);
        dest.writeString(locationDetails);
    }
}
