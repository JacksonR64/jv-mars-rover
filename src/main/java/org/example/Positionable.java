package org.example;

public interface Positionable {
    int getX ();
    void setX (int x);

    int getY ();
    void setY (int y);

    DIRECTION getFacing();
    void setFacing (DIRECTION direction);
}
