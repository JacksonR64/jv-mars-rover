package org.example;

import static org.example.Input.InvalidUserInputException.InvalidDirectionException;

public class Move {
    public static Position move (Position position, MOVEMENT_INSTRUCTION movementInstruction){
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
        return position;
    }
}
