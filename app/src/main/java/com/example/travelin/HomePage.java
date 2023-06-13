package com.example.travelin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class HomePage extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    private Button departure;
    private Button arrival;
    private Button date;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        departure = findViewById(R.id.inputDeparture);
        arrival = findViewById(R.id.inputArrival);
        date = findViewById(R.id.editDate);

        //DisableKeyboard
        departure.setShowSoftInputOnFocus(false);
        arrival.setShowSoftInputOnFocus(false);

        departure.setOnClickListener(this);
        arrival.setOnClickListener(this);
        date.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.inputDeparture){
            Intent intent = new Intent(HomePage.this, LocationPage.class);
            startActivityForResult(intent, 1);
        }else if(v.getId() == R.id.inputArrival){
            Intent intent = new Intent(HomePage.this, LocationPage.class);
            startActivityForResult(intent, 2);
        }else if(v.getId() == R.id.editDate){
            DialogFragment datePicker = new DatePickerFragment();
            datePicker.show(getSupportFragmentManager(), "date picker");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if(resultCode == RESULT_FIRST_USER){
                LocationItemsRV location = data.getParcelableExtra("location");
                Toast.makeText(getApplicationContext(), "You Click On "+location.getLocationInput()+location.getLocationDetails(), Toast.LENGTH_SHORT).show();
                departure.setText(location.getLocationDetails());
            }
        }else if (requestCode == 2){
            if(resultCode == RESULT_FIRST_USER){
                LocationItemsRV location = data.getParcelableExtra("location");
                Toast.makeText(getApplicationContext(), "You Click On "+location.getLocationInput()+location.getLocationDetails(), Toast.LENGTH_SHORT).show();
                arrival.setText(location.getLocationDetails());
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
        date.setText(currentDateString);
    }
}