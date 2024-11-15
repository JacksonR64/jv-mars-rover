package org.example;

import static org.example.Input.InvalidUserInputException.InvalidDirectionException;

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
}
