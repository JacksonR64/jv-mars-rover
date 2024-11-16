package org.example;

import java.util.ArrayList;
import java.util.Objects;

import static org.example.Plateau.plateauList;

public class Rover implements Movable, Positionable{

    public static int roverCount = 0;
    public static ArrayList<Rover> roverList = new ArrayList<>();
    private int id;
    private boolean isAlive;
    private Position position;
    private Plateau plateau;




    // constructor
    public Rover(Position position) {
        this.position = position;
        this.id = roverCount;
        this.plateau = plateauList.getFirst();
        if (this.isInBounds()) {
            roverList.add(this);
            roverCount++;
            position.setIsAlive(true);
            this.isAlive = true;
            plateau.objectList.add(this);

        }
        else {
            System.out.println("Rover placed out of bounds and exploded on impact ‼️");
        }
    }

    // getters and setters
    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public Position getPosition() {return position;}

    public void setPosition(Position position) {this.position = position;}

    public Plateau getPlateau() {return plateau;}

    public void setPlateau(Plateau plateau) {this.plateau = plateau;}

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
    public boolean isInBounds() {
        return Movable.super.isInBounds();
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
                "id=" + id +
                ", isAlive=" + isAlive +
                ", position=" + position +
                ", plateau=" + plateau.getPlateauID() +
                '}';
    }
}
