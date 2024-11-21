package org.example.enums;

public enum DIRECTION {
    N,
    E,
    S,
    W;

    public static boolean isValid (String input){
        for (DIRECTION direction : DIRECTION.values()){
            if (direction.name().equalsIgnoreCase(input))
                return true;
        }
        return false;
    }
}
