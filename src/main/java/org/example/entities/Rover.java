package org.example.entities;

import org.example.enums.DIRECTION;
import org.example.enums.MOVEMENT_INSTRUCTION;
import org.example.core.Position;
import org.example.enums.ROTATE_INSTRUCTION;
import org.example.core.Movable;
import org.example.core.Positionable;

import java.util.ArrayList;
import java.util.Objects;

import static org.example.config.MessageProvider.*;
import static org.example.entities.Plateau.plateauList;

public class Rover implements Movable, Positionable {

    public static int roverCount = 1;
    public static ArrayList<Rover> roverList = new ArrayList<>();
    final private int id;
    private boolean isAlive;
    final private Position position;
    final private Plateau plateau;




    // constructor
    public Rover(Position position) {
        this.position = position;
        this.id = roverCount;
        this.plateau = plateauList.getFirst();
        if (this.isInBounds(false)) {
            roverList.add(this);
            roverCount++;
            position.setIsAlive(true);
            this.isAlive = true;
            plateau.objectList.add(this);
        }
        else {
            System.out.println(ROVER_PLACED_OOB_MESSAGE);
        }
    }

    // getters and setters

    public Position getPosition() {return position;}

    public Plateau getPlateau() {return plateau;}

    @Override
    public boolean getIsAlive() {
        return false;
    }

    @Override
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setY(int y) {}

    @Override
    public DIRECTION getFacing() {
        return null;
    }

    @Override
    public void setFacing(DIRECTION direction) {

    }

    // methods
    @Override
    public void move(MOVEMENT_INSTRUCTION movementInstruction) {
        Movable.super.move(movementInstruction);
    }

    @Override
    public void rotate(ROTATE_INSTRUCTION rotateInstruction) {
        Movable.super.rotate(rotateInstruction);
    }

    @Override
    public boolean isInBounds(boolean isMoving) {
        return Movable.super.isInBounds(isMoving);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(position, rover.position);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "ID=" + id +
                " " + position +
                '}';
    }
}
