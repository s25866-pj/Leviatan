package com.example.leviatan.Utilz;

import java.util.ArrayList;

public class ShipPart {
    int ID;
    int count;
    int sizeW;
    int sizeH;
    Type type;
    boolean possibyMoveHorisontal;
    ArrayList<String> itemStored;

    public ShipPart(int ID,int count, int sizeW, int sizeH, Type type, boolean possibyMoveHorisontal, ArrayList<String> itemStored) {
        this.ID=ID;
        this.count = count;
        this.sizeW = sizeW;
        this.sizeH = sizeH;
        this.type = type;
        this.possibyMoveHorisontal = possibyMoveHorisontal;
        this.itemStored = itemStored;
    }

    public ShipPart(int ID,int count, int sizeW, int sizeH, Type type, boolean possibyMoveHorisontal) {
        this.ID=ID;
        this.count = count;
        this.sizeW = sizeW;
        this.sizeH = sizeH;
        this.type = type;
        this.possibyMoveHorisontal = possibyMoveHorisontal;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSizeW() {
        return sizeW;
    }

    public void setSizeW(int sizeW) {
        this.sizeW = sizeW;
    }

    public int getSizeH() {
        return sizeH;
    }

    public void setSizeH(int sizeH) {
        this.sizeH = sizeH;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isPossibyMoveHorisontal() {
        return possibyMoveHorisontal;
    }

    public void setPossibyMoveHorisontal(boolean possibyMoveHorisontal) {
        this.possibyMoveHorisontal = possibyMoveHorisontal;
    }

    public ArrayList<String> getItemStored() {
        return itemStored;
    }

    public void setItemStored(ArrayList<String> itemStored) {
        this.itemStored = itemStored;
    }
}
