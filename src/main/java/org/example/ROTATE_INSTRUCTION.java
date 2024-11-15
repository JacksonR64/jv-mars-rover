package org.example;

public enum ROTATE_INSTRUCTION implements INSTRUCTION {
    L,
    R;
/*    ROTATE_LEFT("L"),
    ROTATE_RIGHT("R");*/

    public static boolean isValid(String input) {
        for (ROTATE_INSTRUCTION rotateInstruction : ROTATE_INSTRUCTION.values()) {
            if (rotateInstruction.name().equalsIgnoreCase(input))
                return true;
        }
        return false;
    }
}
