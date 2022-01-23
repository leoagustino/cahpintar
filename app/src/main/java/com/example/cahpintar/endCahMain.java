package com.example.cahpintar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    }
}