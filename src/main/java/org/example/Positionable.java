package org.example;

public interface Positionable {
    boolean getIsAlive();
    void setIsAlive(boolean isAlive);

    int getX ();
    void setX (int x);

    int getY ();
    void setY (int y);

    DIRECTION getFacing();
    void setFacing (DIRECTION direction);
}
