package com.example.cahpintar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class pengenalanjarimatika_lv4 extends AppCompatActivity {

    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalanjarimatika_lv4);

        back = (ImageButton)findViewById(R.id.arrowback1);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pengenalanjarimatika_lv4.this, soal_jarimatika_lv41.class);
                startActivity(intent);
            }
        });

    }
}