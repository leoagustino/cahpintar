package com.example.cahpintar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class soal_jarimatika_lv411 extends AppCompatActivity {
    private static final String isPlaying = "Sound is Playing";
    private MediaPlayer player;
    private ImageButton volume1, btnBack, quest, next41;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_jarimatika_lv411);
        btnBack = (ImageButton)findViewById(R.id.backj411);
        volume1 = (ImageButton) this.findViewById(R.id.vol2);
        quest = (ImageButton) this.findViewById(R.id.qust2);
        next41 = (ImageButton) this.findViewById(R.id.next2);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(soal_jarimatika_lv411.this, soal_jarimatika_lv41.class);
                startActivity(intent);
            }
        });

        volume1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                playSound(1);
            }
        });

        quest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(soal_jarimatika_lv411.this, pengenalanjarimatika_lv4.class);
            }
        });

        next41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(soal_jarimatika_lv411.this, soal_jarimatika_lv412.class);
            }
        });
    }

    public void onPause() {
        try{
            super.onPause();
            player.pause();
        }catch (Exception e){
        }
    }
    private void playSound(int arg){
        try{
            if (player.isPlaying()) {
                player.stop();
                player.release();
            }
        }catch(Exception e){
            Toast.makeText(this, " Masuk Exception", Toast.LENGTH_LONG).show();
        }
        if (arg == 1) {
            Toast.makeText(this, isPlaying, Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.hitunglah);
        }
        player.setLooping(false); // Set looping
        player.start();
    }
}