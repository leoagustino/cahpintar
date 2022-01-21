package com.example.cahpintar;

import java.util.ArrayList;

public class PertanyaanBank {


    private String textQuestions [] = {
            "1. Berikut ini mana yang gambarnya berbeda dari yang lain?",
            "2. Berikut ini mana yang gambarnya berbeda dari yang lain",
            "3. Berikut ini mana yang gambarnya berbeda dari yang lain",
            "4. Berikut ini mana yang gambarnya berbeda dari yang lain",
            "5. Berikut ini mana yang gambarnya berbeda dari yang lain ?"
    };

    // array of multiple choices for each question
    private Integer multipleChoice [][]= {
            {R.drawable.ops_a1, R.drawable.ops_b1, R.drawable.ops_c1, R.drawable.ops_d1},
            {R.drawable.ops_a2, R.drawable.ops_b2, R.drawable.ops_c2, R.drawable.ops_d2},
            {R.drawable.ops_a3, R.drawable.ops_b3, R.drawable.ops_c3, R.drawable.ops_d3},
            {R.drawable.ops_a4, R.drawable.ops_b4, R.drawable.ops_c4, R.drawable.ops_d4},
            {R.drawable.ops_a5, R.drawable.ops_b5, R.drawable.ops_c5, R.drawable.ops_d5}
    };

    private Integer mCorrectAnswers[] = {2, 3, 4, 2, 1};

    public int getLength(){
        return textQuestions.length;
    }

    public String getQuestion(int a) {
        String question = textQuestions[a];
        return question;
    }

    public int getChoice(int index, int num) {
        int choice0 = multipleChoice[index][num-1];
        return choice0;
    }

    public int getCorrectAnswer(int a) {
        int answer = mCorrectAnswers[a];
        return answer;
    }

}
