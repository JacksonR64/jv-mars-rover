package org.example;

public class Plateau {
    static int plateauCount = 0;
    int plateauID;
    PlateauSize plateauSize;

    public Plateau(PlateauSize plateauSize) {
        this.plateauID = plateauCount++;
        this.plateauSize = plateauSize;
    }
}
