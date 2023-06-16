package com.example.travelin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class HomePage extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    private Button btnDeparture;
    private Button btnArrival;
    private Button btnDate;
    private Button btnSearchBus;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btnDeparture = findViewById(R.id.btnDeparture);
        btnArrival = findViewById(R.id.btnArrival);
        btnDate = findViewById(R.id.btnDate);
        btnSearchBus = findViewById(R.id.btnSearchBus);

        //DisableKeyboard
        btnDeparture.setShowSoftInputOnFocus(false);
        btnArrival.setShowSoftInputOnFocus(false);

        btnDeparture.setOnClickListener(this);
        btnArrival.setOnClickListener(this);
        btnDate.setOnClickListener(this);
        btnSearchBus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnDeparture){
            Intent intent = new Intent(HomePage.this, LocationPage.class);
            intent.putExtra("destination", "Location/Departure");
            startActivityForResult(intent, 1);
        }else if(v.getId() == R.id.btnArrival){
            Intent intent = new Intent(HomePage.this, LocationPage.class);
            intent.putExtra("destination", "Location/Arrival");
            startActivityForResult(intent, 2);
        }else if(v.getId() == R.id.btnDate){
            DialogFragment datePicker = new DatePickerFragment();
            datePicker.show(getSupportFragmentManager(), "date picker");
        }else if(v.getId() == R.id.btnSearchBus){
            Intent intent = new Intent(HomePage.this, BusListPage.class);
            intent.putExtra("departureLocation", btnDeparture.getText().toString());
            intent.putExtra("arrivalLocation", btnArrival.getText().toString());
            intent.putExtra("date", btnDate.getText().toString());
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if(resultCode == RESULT_FIRST_USER){
                LocationItemsRV location = data.getParcelableExtra("location");
                Toast.makeText(getApplicationContext(), "You Click On "+location.getLocationCity()+location.getLocationDetails(), Toast.LENGTH_SHORT).show();
                btnDeparture.setText(location.getLocationDetails());
            }
        }else if (requestCode == 2){
            if(resultCode == RESULT_FIRST_USER){
                LocationItemsRV location = data.getParcelableExtra("location");
                Toast.makeText(getApplicationContext(), "You Click On "+location.getLocationCity()+location.getLocationDetails(), Toast.LENGTH_SHORT).show();
                btnArrival.setText(location.getLocationDetails());
            }
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        btnDate.setText(currentDateString);
    }
}