package com.example.cahpintar;

public class mathBank {

    private Integer imageQuestion []= {
            R.drawable.gbr6x6,
            R.drawable.gbr6x7,
            R.drawable.gbr6x8

    };


    private String[][] keys = {
            {"10", "20", "3", "40", "4", "72"},
            {"9", "90", "10", "24", "12", "41"},
            {"23", "1", "4", "22", "88", "90"}
    };




    private String[] kunciJawaban = {"2010", "200", "300"};

    public int getLength2(){
        return imageQuestion.length;
    }

    public Integer getQuestionMath(int c) {
        return imageQuestion[c];
    }

    /*public int getChoice(int index, int num) {
        int textAnswer = textAnswer[index][num-1];
        return textAnswer;
    }*/

    public String getJawabenar(int b) {
        return kunciJawaban [b];

    }

    public String getKeys(int b, int c) {
        return keys[b][c];
    }



}
