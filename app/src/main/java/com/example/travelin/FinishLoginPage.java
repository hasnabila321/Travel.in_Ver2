package com.example.travelin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FinishLoginPage extends AppCompatActivity {
    private Button btnfinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_login_page);

        btnfinish = findViewById(R.id.btnFinishRegis);

        btnfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishLoginPage.this, HomePage.class);
                startActivity(intent);
                onBackPressed();

            }
        });
    }
}