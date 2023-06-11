package com.example.travelin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity implements View.OnClickListener {
    private TextView departure;
    private TextView arrival;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        departure = findViewById(R.id.textDeparture);
        arrival = findViewById(R.id.textArrival);

        departure.setOnClickListener(this);
        arrival.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.textArrival){
            Intent intent = new Intent(HomePage.this, SearchLocationResultPage.class);
            startActivityForResult(intent, 1);
        }else if(v.getId() == R.id.textDeparture){
            Intent intent = new Intent(HomePage.this, SearchLocationResultPage.class);
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if(resultCode == RESULT_FIRST_USER){
                SearchLocationItemsRV location = data.getParcelableExtra("location");
                Toast.makeText(getApplicationContext(), "You Click On "+location.getSearchLocationInput(), Toast.LENGTH_SHORT).show();
                departure.setText(location.getSearchLocationInput());
            }
        }
    }
}