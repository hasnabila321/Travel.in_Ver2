package com.example.travelin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class LocationPage extends AppCompatActivity implements LocationAdapter.ListItemClickListener{

    private RecyclerView rvLocation;

    private List<LocationItemsRV> locationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_page);

        rvLocation = findViewById(R.id.locationRV);

        locationList = new ArrayList<>();

        locationList.add(new LocationItemsRV("Bandung", "Buah Batu"));
        locationList.add(new LocationItemsRV("Jakarta Selatan ", "Bintaro"));

        LocationAdapter locationAdapter = new LocationAdapter(this, locationList);
        locationAdapter.setListener(this);
        rvLocation.setAdapter(locationAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvLocation.setLayoutManager(layoutManager);
    }

    @Override
    public void onListItemClick(View v, int position) {
        LocationItemsRV selectedLocation = locationList.get(position);

        Intent intent = new Intent();
        intent.putExtra("location", selectedLocation);
        setResult(RESULT_FIRST_USER, intent);
        finish();
//        startActivity(intent);
    }
}