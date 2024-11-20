package org.example;

import java.util.ArrayList;

public class Plateau {
    static int plateauCount = 0;
    public static ArrayList<Plateau> plateauList = new ArrayList<>();
    public ArrayList<Positionable> objectList = new ArrayList<>();

    int plateauID;
    PlateauSize plateauSize;

    // constructor
    public Plateau(PlateauSize plateauSize) {
        this.plateauID = plateauCount++;
        this.plateauSize = plateauSize;
        plateauList.add(this);
    }

    // getters and setters
    public static int getPlateauCount() {
        return plateauCount;
    }

    public static void setPlateauCount(int plateauCount) {
        Plateau.plateauCount = plateauCount;
    }

    public int getPlateauID() {
        return plateauID;
    }

    public void setPlateauID(int plateauID) {
        this.plateauID = plateauID;
    }

    public static ArrayList<Plateau> getPlateauList() {
        return plateauList;
    }

    public static void setPlateauList(ArrayList<Plateau> plateauList) {
        Plateau.plateauList = plateauList;
    }

    public PlateauSize getPlateauSize() {
        return plateauSize;
    }

    public void setPlateauSize(PlateauSize plateauSize) {
        this.plateauSize = plateauSize;
    }

    @Override
    public String toString() {
        return "Plateau{" +
                "ID=" + plateauID +
                ", " + plateauSize +
                ", objectCount=" + objectList.size() +
                '}';
    }
}
