package com.example.cahpintar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class cahMainActivity extends AppCompatActivity implements View.OnClickListener {

    private PertanyaanBank mQuestionLibrary = new PertanyaanBank();
    private TextView txtSoalCah, txtScore;
    private ImageButton opsi1, opsi2, opsi3, opsi4;

    private int mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    String scoreScr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cah_main);

        /*txtSoalNo = findViewById(R.id.txtSoalNo);*/
        txtSoalCah = findViewById(R.id.txtSoalCah);
        txtScore = findViewById(R.id.txtScore);

        opsi1 = findViewById(R.id.opsi1);
        opsi1.setOnClickListener(this);
        opsi2 = findViewById(R.id.opsi2);
        opsi2.setOnClickListener(this);
        opsi3 = findViewById(R.id.opsi3);
        opsi3.setOnClickListener(this);
        opsi4 = findViewById(R.id.opsi4);
        opsi4.setOnClickListener(this);


        updateQuestion();
        updateScore(mScore);

    }

    private void updateScore(int mScore) {
        /*txtScore.setText("" + mScore + "/" + mQuestionLibrary.getLength());*/
        txtScore.setText("" + mScore + "/" + "110 Point");
    }

    private void updateQuestion() {
        if (mQuestionNumber < mQuestionLibrary.getLength()) {


            txtSoalCah.setText(mQuestionLibrary.getQuestion(mQuestionNumber));

            //menampilkan Image
            opsi1.setImageResource(mQuestionLibrary.getChoice(mQuestionNumber, 1));
            opsi2.setImageResource(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            opsi3.setImageResource(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            opsi4.setImageResource(mQuestionLibrary.getChoice(mQuestionNumber, 4));

            /*opsi4.setImageResource(mQuestionLibrary.getChoice(mQuestionNumber,4));*/

            //koreksi jawaban
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        } else {
            Toast.makeText(cahMainActivity.this, "Soal Terakhir! ",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(cahMainActivity.this, endCahMain.class);
            intent.putExtra("HasilScore", txtScore.getText().toString()); // pass the current score to the second screen
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {

        int answerOptionNum = 0;
        switch (view.getId()) {
            case R.id.opsi1:
                answerOptionNum = Integer.parseInt(opsi1.getTag().toString());
                displayToastAnswerCorrect(answerOptionNum);
                break;
            case R.id.opsi2:
                answerOptionNum = Integer.parseInt(opsi2.getTag().toString());
                displayToastAnswerCorrect(answerOptionNum);
                break;
            case R.id.opsi3:
                answerOptionNum = Integer.parseInt(opsi3.getTag().toString());
                displayToastAnswerCorrect(answerOptionNum);
                break;
            case R.id.opsi4:
                answerOptionNum = Integer.valueOf(opsi4.getTag().toString());
                displayToastAnswerCorrect(answerOptionNum);
                break;
        }
        displayToastAnswerCorrect(answerOptionNum);
    }

    private void displayToastAnswerCorrect(int answerOptionNum) {
        if (answerOptionNum == mAnswer) {
            Toast.makeText(this, "Correct !", Toast.LENGTH_SHORT).show();
            mScore = mScore + 10;

            updateScore(mScore);
            updateQuestion();
        }else {
            Toast.makeText(this, "Salah!", Toast.LENGTH_SHORT).show();

        }



    /*public void onClick(View view) {
        //all logic for all answers buttons in one method
        ImageButton answer = (ImageButton) view;

        // if the answer is correct, increase the score
        if (  == mAnswer){
            mScore = mScore + 1;
            Toast.makeText(cahMainActivity.this, "Benar!",
                    Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(cahMainActivity.this, "Salah!",
                    Toast.LENGTH_SHORT).show();

        updateScore(mScore);
        updateQuestion();
    }*/


    }
}
