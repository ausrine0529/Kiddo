package com.example.edukacine2;

public class Question {
    private int id;
    private String question_txt;
    private int image;
    private int level;
    private int type;
    private String option1;
    private String option2;
    private String option3;
    private int correctAnsw;

    public Question(int id, String question_txt, int image, int level, int type, String option1, String option2, String option3, int correctAnsw) {
        this.id = id;
        this.question_txt = question_txt;
        this.image = image;
        this.level = level;
        this.type = type;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.correctAnsw = correctAnsw;
    }

    public Question(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion_txt() {
        return question_txt;
    }

    public void setQuestion_txt(String question_txt) {
        this.question_txt = question_txt;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getCorrectAnsw() {
        return correctAnsw;
    }

    public void setCorrectAnsw(int correctAnsw) {
        this.correctAnsw = correctAnsw;
    }
}
