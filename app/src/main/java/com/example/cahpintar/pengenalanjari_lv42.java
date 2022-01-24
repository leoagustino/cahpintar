package com.example.cahpintar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class pengenalanjari_lv42 extends AppCompatActivity {
    private ImageButton btnback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalanjari_lv42);

        btnback = (ImageButton)findViewById(R.id.arrowback3);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pengenalanjari_lv42.this, soal_jarimatika_lv42.class);
                startActivity(intent);
            }
        });
    }
}