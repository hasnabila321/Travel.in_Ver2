package com.example.travelin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchLocationResultPage extends AppCompatActivity implements SearchLocationResultAdapter.ListItemClickListener{

    private RecyclerView rvSearchLocationResult;

    private List<SearchLocationItemsRV> locationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_location_result_page);

        rvSearchLocationResult = findViewById(R.id.searchLocationResultRV);

        locationList = new ArrayList<>();

        locationList.add(new SearchLocationItemsRV("Palembang"));
        locationList.add(new SearchLocationItemsRV("Medan"));

        SearchLocationResultAdapter locationAdapter = new SearchLocationResultAdapter(this, locationList);
        locationAdapter.setListener(this);
        rvSearchLocationResult.setAdapter(locationAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvSearchLocationResult.setLayoutManager(layoutManager);
    }

    @Override
    public void onListItemClick(View v, int position) {
        SearchLocationItemsRV selectedLocation = locationList.get(position);
        Toast.makeText(getApplicationContext(), "You Click On "+position+selectedLocation.getSearchLocationInput(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra("location", selectedLocation);
        setResult(RESULT_FIRST_USER, intent);
        finish();
//        startActivity(intent);
    }
}