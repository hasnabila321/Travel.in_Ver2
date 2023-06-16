package com.example.travelin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class LocationPage extends AppCompatActivity implements LocationAdapter.ListItemClickListener{
    private String destination;
    private RecyclerView rvLocation;
    private List<LocationItemsRV> locationList;
    LocationAdapter locationAdapter;

    @Override
    protected void onStart() {
        super.onStart();
        locationAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        locationAdapter.stopListening();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_page);

        rvLocation = findViewById(R.id.locationRV);

        Bundle data = getIntent().getExtras();
        destination = data.getString("destination");

        Toast.makeText(getApplicationContext(), "You Click On "+"Location/Departure", Toast.LENGTH_SHORT).show();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvLocation.setLayoutManager(layoutManager);

        FirebaseRecyclerOptions<LocationItemsRV> options=
                new FirebaseRecyclerOptions.Builder<LocationItemsRV>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child(destination), LocationItemsRV.class)
                        .build();
        locationAdapter = new LocationAdapter(options, LocationPage.this);
        locationAdapter.setListener(this);
        rvLocation.setAdapter(locationAdapter);

    }

    @Override
    public void onListItemClick(View v, int position) {
//        String getPosition = Integer.toString(position+1);
//        LocationItemsRV selectedLocation = locationList.get(position);

//        Bundle dataLocation = getIntent().getExtras();

//        Intent intent = new Intent();
//        intent.putExtra("city", selectedLocation.getLocationCity());
//        intent.putExtra("cityDetails", selectedLocation.getLocationDetails());
//        setResult(RESULT_FIRST_USER, intent);
//        finish();
//        startActivity(intent);
    }
}