package org.example.core;

import org.example.entities.Plateau;
import org.example.entities.PlateauSize;
import org.example.enums.DIRECTION;
import org.example.enums.MOVEMENT_INSTRUCTION;
import org.example.enums.ROTATE_INSTRUCTION;

import java.util.Arrays;

import static org.example.exceptions.InvalidUserInputException.InvalidDirectionException;
import static org.example.core.Position.DIRECTIONS;
import static org.example.core.Position.lastCardinalPointIndex;
import static org.example.config.AppConfig.*;

public interface Movable {
    Position getPosition();
    Plateau getPlateau();

    default void move(MOVEMENT_INSTRUCTION movementInstruction) {
        if (!isInBounds(true)) {
            return;
        }

        Position position = getPosition();
        switch (position.getFacing()) {
            case DIRECTION.N -> position.setY(position.getY() + DEFAULT_TICK);
            case DIRECTION.E -> position.setX(position.getX() + DEFAULT_TICK);
            case DIRECTION.S -> position.setY(position.getY() - DEFAULT_TICK);
            case DIRECTION.W -> position.setX(position.getX() - DEFAULT_TICK);
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
        };

        position.setFacing(Position.DIRECTIONS[newCardinalIndex]);
    }

    default boolean isInBounds(boolean isMoving) {
        PlateauSize plateauSize = getPlateau().getPlateauSize();
        Position position = getPosition();
        DIRECTION facing = position.getFacing();
        int tick = 0;

        if (isMoving) tick = DEFAULT_TICK;

        // General bounds check if rover is not alive
        if (!position.getIsAlive()) {
            return position.getX() >= plateauSize.getxAxisStart()
                    && position.getX() <= plateauSize.getxAxisEnd()
                    && position.getY() >= plateauSize.getyAxisStart()
                    && position.getY() <= plateauSize.getyAxisEnd();
        }

        // Determine axis position and boundary based on direction
        int axisPosition = switch (facing) {
            case DIRECTION.N, DIRECTION.S -> position.getY(); // Y-axis for N/S
            case DIRECTION.E, DIRECTION.W -> position.getX(); // X-axis for E/W
        };

        int boundaryLimit = switch (facing) {
            case DIRECTION.N -> plateauSize.getyAxisEnd();
            case DIRECTION.E -> plateauSize.getxAxisEnd();
            case DIRECTION.S -> plateauSize.getyAxisStart();
            case DIRECTION.W -> plateauSize.getxAxisStart();
        };

        // Check out-of-bounds conditions
        if ((facing == DIRECTION.N || facing == DIRECTION.E) && axisPosition + tick > boundaryLimit) {
            return false;
        } else return (facing != DIRECTION.S && facing != DIRECTION.W) || axisPosition - tick >= boundaryLimit;
    }
}
