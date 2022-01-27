package com.example.cahpintar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class endCahMain extends AppCompatActivity {
    TextView point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_cah_main);

    point = findViewById(R.id.ScoreCahmain);
    String Score = getIntent().getStringExtra("HasilScore");
    point.setText(Score);

        findViewById(R.id.btnToHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Home.class));
            }
        });


    }
}