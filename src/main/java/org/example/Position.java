package org.example;

import java.util.Objects;

public class Position implements Positionable{
    public static DIRECTION[] DIRECTIONS = {DIRECTION.N, DIRECTION.E, DIRECTION.S, DIRECTION.W};
    public static int lastCardinalPointIndex = DIRECTIONS.length - 1;
    public static Position facingNorth = new Position(5, 5, DIRECTION.N);
    public static Position facingEast = new Position(5, 5, DIRECTION.E);
    public static Position facingSouth = new Position(5, 5, DIRECTION.S);
    public static Position facingWest = new Position(5, 5, DIRECTION.W);

    private int x;
    private int y;
    private DIRECTION facing; // this type can be whatever your direction enum is called

    public Position(int x, int y, DIRECTION facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
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
}
