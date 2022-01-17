package com.example.cahpintar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class cahMainActivity extends AppCompatActivity {
    private TextView txtSoalNo, txtSoalCah, txtScore;
    private RadioGroup rg1;
    private RadioButton opsi1, opsi2, opsi3, opsi4;
    private Button btnNext;

    private List<pertanyaanModel> questionsList;
    int totalQuestion;
    int qCounter = 0;
    int score = 0;

    private pertanyaanModel currentQuestion;

    ColorStateList radioColor;
    boolean answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cah_main);

        questionsList = new ArrayList<>();
        txtSoalNo = findViewById(R.id.txtSoalNo);
        txtSoalCah = findViewById(R.id.txtSoalCah);
        txtScore = findViewById(R.id.txtScore);

        rg1 = findViewById(R.id.rg1);
        opsi1 = findViewById(R.id.opsi1);
        opsi2 = findViewById(R.id.opsi2);
        opsi3 = findViewById(R.id.opsi3);
        opsi4 = findViewById(R.id.opsi4);
        btnNext = findViewById(R.id.btn_submit_cah);


        addQuestion();
        totalQuestion = questionsList.size();
        showNextQuestion();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answered == false) {
                    if (opsi1.isChecked() || opsi2.isChecked() || opsi3.isChecked() || opsi4.isChecked()) {
                        checkAnswer();

                    } else {
                        Toast.makeText(cahMainActivity.this, "Please Select an Option", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }

        });
    }

    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(rg1.getCheckedRadioButtonId());
        int answerNo = rg1.indexOfChild(rbSelected)+1;
        if(answerNo == currentQuestion.getCorrectAnsNo()){
            score++;
            txtScore.setText("Score: "+score);
        }
        opsi1.setTextColor(Color.RED);
        opsi2.setTextColor(Color.RED);
        opsi3.setTextColor(Color.RED);
        opsi4.setTextColor(Color.RED);
        switch (currentQuestion.getCorrectAnsNo()){
            case 1 :
                opsi1.setTextColor(Color.GREEN);
                break;
            case 2 :
                opsi2.setTextColor(Color.GREEN);
                break;
            case 3 :
                opsi3.setTextColor(Color.GREEN);
                break;
            case 4 :
                opsi4.setTextColor(Color.GREEN);
                break;
        }
        if(qCounter < totalQuestion){
            btnNext.setText("Next");
        } else {
            btnNext.setText("finish");
        }
    }

    private void showNextQuestion() {
        rg1.clearCheck();
        opsi1.setTextColor(radioColor);
        opsi2.setTextColor(radioColor);
        opsi3.setTextColor(radioColor);
        opsi4.setTextColor(radioColor);

        if(qCounter < totalQuestion) {

            currentQuestion = questionsList.get(qCounter);
            txtSoalCah.setText(currentQuestion.getPertanyaan());

            opsi1.setText(currentQuestion.getOpsi1());
            opsi2.setText(currentQuestion.getOpsi2());
            opsi3.setText(currentQuestion.getOpsi3());
            opsi4.setText(currentQuestion.getOpsi4());

            qCounter++;
           // btnNext.setText("Submit");
            txtSoalNo.setText( "Pertanyaan"+qCounter+ "/" + totalQuestion);
            answered = false;

        } else {
            finish();
        }

    }

    private void addQuestion(){
        questionsList.add(new pertanyaanModel("Berikut ini mana yang gambarnya berbeda dari yang lain", "A", "B", "C", "D", 1));
        questionsList.add(new pertanyaanModel("Berikut ini mana yang gambarnya berbeda dari yang lain", "A", "B", "C", "D", 1));
        questionsList.add(new pertanyaanModel("Berikut ini mana yang gambarnya berbeda dari yang lain", "A", "B", "C", "D", 1));
        questionsList.add(new pertanyaanModel("Berikut ini mana yang gambarnya berbeda dari yang lain", "A", "B", "C", "D", 1));
    }

}
