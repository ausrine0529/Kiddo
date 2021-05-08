package com.example.edukacine2;

public class Result {
    int result_id;
    int kid_id;
    String username;
    String taskType;
    int level;
    int task_id;
    int correctAnsw;
    int questionQntt;
    String date;

    public Result(int result_id, int kid_id, String username, String taskType, int level, int task_id, int correctAnsw, int questionQntt, String date) {
        this.result_id = result_id;
        this.kid_id = kid_id;
        this.username = username;
        this.taskType = taskType;
        this.level = level;
        this.task_id = task_id;
        this.correctAnsw = correctAnsw;
        this.questionQntt = questionQntt;
        this.date = date;
    }

    public Result() {
    }

    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
    }

    public int getKid_id() {
        return kid_id;
    }

    public void setKid_id(int kid_id) {
        this.kid_id = kid_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getCorrectAnsw() {
        return correctAnsw;
    }

    public void setCorrectAnsw(int correctAnsw) {
        this.correctAnsw = correctAnsw;
    }

    public int getQuestionQntt() {
        return questionQntt;
    }

    public void setQuestionQntt(int questionQntt) {
        this.questionQntt = questionQntt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}


