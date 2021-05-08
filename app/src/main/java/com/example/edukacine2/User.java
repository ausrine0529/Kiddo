package com.example.edukacine2;

public class User {
    private int ID;
    private String username;
    private String pwdhash;
    private String type;
    private Boolean isActive;

    public User(int ID, String username, String pwdhash, String type, Boolean isActive) {
        this.ID = ID;
        this.username = username;
        this.pwdhash = pwdhash;
        this.type = type;
        this.isActive = isActive;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", pwdhash='" + pwdhash + '\'' +
                ", type='" + type + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwdhash() {
        return pwdhash;
    }

    public void setPwdhash(String pwdhash) {
        this.pwdhash = pwdhash;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
