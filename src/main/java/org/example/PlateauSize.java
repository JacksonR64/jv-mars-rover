package org.example;

public class PlateauSize {

    private int xAxisStart;
    private int yAxisStart;
    private int xAxisEnd;
    private int yAxisEnd;


    public PlateauSize(int xAxisEnd, int yAxisEnd) {

        this.xAxisStart = 0;
        this.yAxisStart = 0;
        this.xAxisEnd = xAxisEnd;
        this.yAxisEnd = yAxisEnd;
    }

    public int getxAxisStart() {
        return xAxisStart;
    }

    public int getyAxisStart() {
        return yAxisStart;
    }

    public int getxAxisEnd() {
        return xAxisEnd;
    }

    public int getyAxisEnd() {
        return yAxisEnd;
    }

}
