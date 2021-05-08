package com.example.edukacine2;

public class Task {
    int task_id;
    int type;
    int questquantitiy;
    int level;
    String kid_name;
    Boolean wasPerformed;


    public Task(int task_id, int type, int questquantitiy, int level, String kid_name, Boolean wasPerformed) {
        this.task_id = task_id;
        this.type = type;
        this.questquantitiy = questquantitiy;
        this.level = level;
        this.kid_name = kid_name;
        this.wasPerformed = wasPerformed;
    }

    public Task() {
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", type=" + type +
                ", questquantitiy=" + questquantitiy +
                ", level=" + level +
                ", kid_id=" + kid_name +
                ", wasPerformed=" + wasPerformed +
                '}';
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getQuestquantitiy() {
        return questquantitiy;
    }

    public void setQuestquantitiy(int questquantitiy) {
        this.questquantitiy = questquantitiy;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getKid_name() {
        return kid_name;
    }

    public void setKid_name(String kid_name) {
        this.kid_name = kid_name;
    }

    public Boolean getWasPerformed() {
        return wasPerformed;
    }

    public void setWasPerformed(Boolean wasPerformed) {
        this.wasPerformed = wasPerformed;
    }
}
