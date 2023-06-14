package com.example.travelin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BusListPage extends AppCompatActivity implements BusListAdapter.ListItemClickListener{
    private RecyclerView rvBus;
    private List<BusItem> busList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list_page);

        rvBus = findViewById(R.id.rvBusList);

        busList = new ArrayList<>();

        busList.add(new BusItem("Damri", "D 1234 ABC", "Bandung", "Buah Batu",
                "05.00", "Jakarta Selatan", "Bintaro", "08:00",
                120000, 4.9f, 100, 10));
        busList.add(new BusItem("Budiman", "D 5678 BBC", "Jakarta Selatan", "Bintaro",
                "10.00", "Bandung", "Buah Batu", "14:00",
                120000, 4.8f, 120, 8));

        BusListAdapter busListAdapter = new BusListAdapter(this, busList);
        busListAdapter.setListener(this);
        rvBus.setAdapter(busListAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvBus.setLayoutManager(layoutManager);
    }

    @Override
    public void onListItemClick(View v, int position) {
        BusItem selectedItems = busList.get(position);
        Toast.makeText(getApplicationContext(), "You Click On "+position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}