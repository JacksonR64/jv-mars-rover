package org.example;

import java.util.Arrays;

import static org.example.Input.InvalidUserInputException.InvalidDirectionException;
import static org.example.Position.DIRECTIONS;
import static org.example.Position.lastCardinalPointIndex;

public interface Movable {
    Position getPosition();

    default void move(MOVEMENT_INSTRUCTION movementInstruction){
        Position position = getPosition();
        switch (position.getFacing()) {
            case DIRECTION.N:
                position.setX(position.getX() + 1);
                break;
            case DIRECTION.E:
                position.setY(position.getY() + 1);
                break;
            case DIRECTION.S:
                position.setX(position.getX() - 1);
                break;
            case DIRECTION.W:
                position.setY(position.getY() - 1);
                break;
            default:
                throw InvalidDirectionException;
        }
        
    }
    default void rotate (ROTATE_INSTRUCTION rotateInstruction){
        Position position = getPosition();
        int cardinalIndex = Arrays.binarySearch(DIRECTIONS, position.getFacing());

        if (rotateInstruction.equals(ROTATE_INSTRUCTION.L)){
            if (cardinalIndex == 0){
                position.setFacing(DIRECTIONS[lastCardinalPointIndex]);
            }else {
                position.setFacing(DIRECTIONS[cardinalIndex - 1]);
            }
        }

        if (rotateInstruction.equals(ROTATE_INSTRUCTION.R)){
            if (cardinalIndex == lastCardinalPointIndex){
                position.setFacing(DIRECTIONS[0]);
            }else {
                position.setFacing(DIRECTIONS[cardinalIndex + 1]);
            }
        }
    }
}
