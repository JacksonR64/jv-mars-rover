package org.example.entities;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "PlateauSize{" +
                "X = " + xAxisStart +
                ":" + xAxisEnd +
                ", Y = " + yAxisStart +
                ":" + yAxisEnd +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlateauSize that = (PlateauSize) o;
        return xAxisStart == that.xAxisStart && yAxisStart == that.yAxisStart && xAxisEnd == that.xAxisEnd && yAxisEnd == that.yAxisEnd;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xAxisStart, yAxisStart, xAxisEnd, yAxisEnd);
    }
}
