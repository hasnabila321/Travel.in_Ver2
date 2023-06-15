package com.example.travelin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BusListPage extends AppCompatActivity implements BusListAdapter.ListItemClickListener, View.OnClickListener {
    private Button btnChangeSearch;
    private TextView tvDeparture;
    private TextView tvArrival;
    private TextView tvDate;
    private RecyclerView rvBus;
    private List<BusItem> busList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list_page);

        btnChangeSearch = findViewById(R.id.btnChangeSearch);
        tvDeparture = findViewById(R.id.tvDepartureLocation);
        tvArrival = findViewById(R.id.tvArrivalLocation);
        tvDate = findViewById(R.id.tvDate);
        rvBus = findViewById(R.id.rvBusList);

        Bundle data = getIntent().getExtras();
        String arrivalLocation = data.getString("arrivalLocation");
        String departureLocation = data.getString("departureLocation");
        String date = data.getString("date");

        tvDeparture.setText(departureLocation);
        tvArrival.setText(arrivalLocation);
        tvDate.setText(date);

        btnChangeSearch.setOnClickListener(this);

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
        Intent intent = new Intent(this, BookingSeatPage.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnChangeSearch){
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
        }
    }
}