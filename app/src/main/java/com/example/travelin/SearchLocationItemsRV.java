package com.example.travelin;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class SearchLocationItemsRV implements Parcelable {
    private String searchLocationInput;

    protected SearchLocationItemsRV(Parcel in){
        searchLocationInput = in.readString();
    }

    public static final Creator<SearchLocationItemsRV> CREATOR = new Creator<SearchLocationItemsRV>() {
        @Override
        public SearchLocationItemsRV createFromParcel(Parcel in) {
            return new SearchLocationItemsRV(in);
        }

        @Override
        public SearchLocationItemsRV[] newArray(int size) {
            return new SearchLocationItemsRV[size];
        }
    };

    public SearchLocationItemsRV(String searchLocationInput) {
        this.searchLocationInput = searchLocationInput;
    }

    public String getSearchLocationInput() {
        return searchLocationInput;
    }

    public void setSearchLocationInput(String searchLocationInput) {
        this.searchLocationInput = searchLocationInput;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(searchLocationInput);
    }
}
