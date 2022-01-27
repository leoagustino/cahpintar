package com.example.cahpintar;

public class mathBank {

    private Integer imageQuestion [] = {
            R.drawable.gbr6x6,
            R.drawable.gbr6x7,
            R.drawable.gbr6x8

    };


    private String[][] keys = {
            {"10", "20", "3", "40", "4", "72"},
            {"9", "90", "10", "24", "12", "41"},
            {"23", "1", "4", "22", "88", "90"}
    };




    private String[] kunciJawaban = {"101", "200", "300"};

    public int getLength2(){
        return imageQuestion.length;
    }

    public Integer getQuestion(int b) {
        Integer mathQuestion = imageQuestion[b];
        return mathQuestion;
    }

   /* public String getJawabUser(int index, int num) {
        int textAnswer = textAnswer[index][num-1];
        return textAnswer;
    } */

    public String getJawabenar(int b) {
        String kunciJawaban = kunciJawaban[b];
        return kunciJawaban;
    }

    public String getKeys(int b) {
        String keys = keys[b];
        return keys;
    }



}
