package org.example.core;

import org.example.enums.DIRECTION;

import java.util.Objects;

public class Position implements Positionable {
    public static DIRECTION[] DIRECTIONS = {DIRECTION.N, DIRECTION.E, DIRECTION.S, DIRECTION.W};
    public static int lastCardinalPointIndex = DIRECTIONS.length - 1;

    private int x;
    private int y;
    private DIRECTION facing;
    private boolean isAlive;

    public Position(int x, int y, DIRECTION facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
        this.isAlive = false;
    }

    @Override
    public boolean getIsAlive() {
        return isAlive;
    }

    @Override
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }

    public DIRECTION getFacing() {
        return facing;
    }
    public void setFacing(DIRECTION facing) {
        this.facing = facing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y && facing == position.facing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, facing);
    }

    @Override
    public String toString() {
        return "Position{" +
                "X=" + x +
                ", Y=" + y +
                ", Facing=" + facing +
                '}';
    }
    public String toSimpleString() {
        return  x + " " + y + " " + facing;
    }
}
