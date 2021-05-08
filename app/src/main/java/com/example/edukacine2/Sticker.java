package com.example.edukacine2;

public class Sticker {
    private int ID;
    private int Kid_ID;
    private int Sticker_ID;

    public Sticker(int ID, int kid_ID, int sticker_ID) {
        this.ID = ID;
        Kid_ID = kid_ID;
        Sticker_ID = sticker_ID;
    }

    public Sticker() {
    }

    @Override
    public String toString() {
        return "Sticker{" +
                "ID=" + ID +
                ", Kid_ID=" + Kid_ID +
                ", Sticker_ID=" + Sticker_ID +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getKid_ID() {
        return Kid_ID;
    }

    public void setKid_ID(int kid_ID) {
        Kid_ID = kid_ID;
    }

    public int getSticker_ID() {
        return Sticker_ID;
    }

    public void setSticker_ID(int sticker_ID) {
        Sticker_ID = sticker_ID;
    }
}
