package org.example;

public enum MOVEMENT_INSTRUCTION implements INSTRUCTION {
    M;
    /*MOVE_FORWARD("F"),
    MOVE_BACKWARD("B");*/

    public static boolean isValid(String input) {
        for (MOVEMENT_INSTRUCTION movementInstruction : MOVEMENT_INSTRUCTION.values()) {
            if (movementInstruction.name().equalsIgnoreCase(input))
                return true;
        }
        return false;
    }

}
