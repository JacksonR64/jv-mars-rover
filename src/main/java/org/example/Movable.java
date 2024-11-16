package org.example;

import java.util.Arrays;

import static org.example.Input.InvalidUserInputException.InvalidDirectionException;
import static org.example.Input.InvalidUserInputException.generalRoverInputException;
import static org.example.Position.DIRECTIONS;
import static org.example.Position.lastCardinalPointIndex;
import static org.example.Settings.DEFAULT_TICK;

public interface Movable {
    Position getPosition();
    Plateau getPlateau();


    default void move(MOVEMENT_INSTRUCTION movementInstruction) {
        if (!isInBounds()) {
            System.out.println("Move failed: Rover is out of bounds.");
            return;
        }

        Position position = getPosition();
        switch (position.getFacing()) {
            case DIRECTION.N -> position.setX(position.getX() + DEFAULT_TICK);
            case DIRECTION.E -> position.setY(position.getY() + DEFAULT_TICK);
            case DIRECTION.S -> position.setX(position.getX() - DEFAULT_TICK);
            case DIRECTION.W -> position.setY(position.getY() - DEFAULT_TICK);
            default -> throw InvalidDirectionException;
        }

    }

    default void rotate(ROTATE_INSTRUCTION rotateInstruction) {
        Position position = getPosition();
        int currentCardinalIndex = Arrays.binarySearch(DIRECTIONS, position.getFacing());
        int indexTotal = lastCardinalPointIndex + 1;

        int newCardinalIndex = switch (rotateInstruction) {
            case ROTATE_INSTRUCTION.L -> (currentCardinalIndex - 1 + indexTotal) % indexTotal;
            case ROTATE_INSTRUCTION.R -> (currentCardinalIndex + 1 + indexTotal) % indexTotal;
            default -> throw generalRoverInputException;
        };
        position.setFacing(Position.DIRECTIONS[newCardinalIndex]);
    }

    default boolean isInBounds() {
        PlateauSize plateauSize = getPlateau().plateauSize;
        Position position = getPosition();
        DIRECTION facing = position.getFacing();


        if (!position.getIsAlive()) {
            return (position.getX() > plateauSize.getxAxisStart()
                    && position.getX() < plateauSize.getxAxisEnd()
                    && position.getY() > plateauSize.getyAxisStart()
                    && position.getY() < plateauSize.getyAxisEnd());
        }

//        System.out.println("BOOOOOOM 💥💥💥 ");

        int axisPosition = switch (facing) {
            case DIRECTION.N, DIRECTION.S -> position.getX();
            case DIRECTION.E, DIRECTION.W -> position.getY();
            default -> throw generalRoverInputException;
        };

        int boundaryLimit = switch (facing) {
            case DIRECTION.N -> plateauSize.getxAxisEnd();
            case DIRECTION.E -> plateauSize.getyAxisEnd();
            case DIRECTION.S -> plateauSize.getxAxisStart();
            case DIRECTION.W -> plateauSize.getyAxisStart();
            default -> throw generalRoverInputException;
        };


        boolean headingOutwards = (facing == DIRECTION.N || facing == DIRECTION.E);
        boolean headingInwards =  (facing == DIRECTION.S || facing == DIRECTION.W);

        System.out.println("HEADING OUT: " + headingOutwards
                + "\nHEADING IN: " + headingInwards +
                "INDEX: " + axisPosition);

        if (headingOutwards && axisPosition + DEFAULT_TICK >= boundaryLimit) {
            System.out.println("Out of bounds - BONK!");
            return false;
        } else if (headingInwards && axisPosition - DEFAULT_TICK <= boundaryLimit) {
            System.out.println("Out of bounds - BONK!");
            return false;
        }
        return true;
    }
}
