package com.example.cahpintar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class jarimatikaLv11 extends AppCompatActivity {

    private mathBank mMathQLibrary = new mathBank();
    ImageView gbrMathSoal;
    TextView txtJudulAngka;
    EditText txtAnswer;
    String[] keys;

    private String kunciJawaban;
    private int presCounter = 0;
    private int noMathQuest = 0;
    private int maxPresCounter = 6;
    private int jawabBenar;
    Animation smallbig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jarimatika_lv11);

        smallbig = AnimationUtils.loadAnimation(this, R.anim.smallbig);

        gbrMathSoal = findViewById(R.id.imgKali);
        txtJudulAngka = findViewById(R.id.txtJudulAngka);
        txtAnswer = findViewById(R.id.txtJawab);
        updateMathQuestion();

        keys = mMathQLibrary.getKeys(shuffleArray(keys).length);

        /*keys = shuffleArray(keys);*/

        for (String key : keys) {
            addView(((LinearLayout) findViewById(R.id.layoutParent)), key, ((EditText) findViewById(R.id.txtJawab)));
        }

        maxPresCounter = 6;
    }

    private void updateMathQuestion() {
        if (noMathQuest < mMathQLibrary.getLength2()) {

            //Soal Math
            txtAnswer.setText(mMathQLibrary.getQuestion(noMathQuest));

            //menampilkan OpsiImage
           /* opsi1.setImageResource(mQuestionLibrary.getChoice(mQuestionNumber, 1));
            opsi2.setImageResource(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            opsi3.setImageResource(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            opsi4.setImageResource(mQuestionLibrary.getChoice(mQuestionNumber, 4));
*/

            //koreksi jawaban
            kunciJawaban = mMathQLibrary.getJawabenar(noMathQuest);
            noMathQuest++;
        } else {
            Toast.makeText(jarimatikaLv11.this, "Soal Terakhir! ",
                    Toast.LENGTH_SHORT).show();

        }

    }


    private String[] shuffleArray(String[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }

    private void addView(LinearLayout viewParent, final String text, final EditText editText) {
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT

        );

        linearLayoutParams.rightMargin = 30;

        final TextView textView = new TextView(this);


        textView.setLayoutParams(linearLayoutParams);
        textView.setBackground(this.getResources().getDrawable(R.drawable.bggrey));
        textView.setTextColor(this.getResources().getColor(R.color.cardcolor1));
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setTextSize(32);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/poppins_semibold.ttf");

        txtAnswer.setTypeface(typeface);
        txtJudulAngka.setTypeface(typeface);
        editText.setTypeface(typeface);
        textView.setTypeface(typeface);

        textView.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (presCounter < maxPresCounter) {
                    if (presCounter == 0)
                        editText.setText("");

                    editText.setText(editText.getText().toString() + text);
                    textView.startAnimation(smallbig);
                    textView.animate().alpha(0).setDuration(300);
                    presCounter++;

                    if (presCounter == maxPresCounter)
                        doValidate();
                }
            }
        });


        viewParent.addView(textView);


    }

    private void doValidate() {
        presCounter = 0;

        EditText editText = findViewById(R.id.txtJawab);
        LinearLayout linearLayout = findViewById(R.id.layoutParent);

        if (editText.getText().toString().equals(kunciJawaban)) {
//            Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

            Intent a = new Intent(jarimatikaLv11.this, Home.class);
            startActivity(a);

            editText.setText("");
        } else {
            Toast.makeText(jarimatikaLv11.this, "Wrong", Toast.LENGTH_SHORT).show();
            editText.setText("");
        }

        keys = shuffleArray(keys);
        linearLayout.removeAllViews();
        for (String key : keys) {
            addView(linearLayout, key, editText);
        }
    }
}