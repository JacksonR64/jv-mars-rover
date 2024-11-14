package org.example;

public class Position {
    public static DIRECTION[] DIRECTIONS = {DIRECTION.N, DIRECTION.E, DIRECTION.S, DIRECTION.W};
    public static int totalDirectionCount = DIRECTIONS.length - 1;
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
}
