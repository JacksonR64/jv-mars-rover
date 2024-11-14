package org.example;

import java.util.Arrays;

import static org.example.Position.DIRECTIONS;
import static org.example.Position.totalDirectionCount;

public class Rotate {
    public static Position rotate (Position position, RotateInstruction rotateInstruction){
        int cardinalIndex = Arrays.binarySearch(DIRECTIONS, position.getFacing());

        if (rotateInstruction.equals(RotateInstruction.L)){
            if (cardinalIndex == 0){
                position.setFacing(DIRECTIONS[totalDirectionCount]);
            }else {
                position.setFacing(DIRECTIONS[cardinalIndex - 1]);
            }
        }

        if (rotateInstruction.equals(RotateInstruction.R)){
            if (cardinalIndex == totalDirectionCount){
                position.setFacing(DIRECTIONS[0]);
            }else {
                position.setFacing(DIRECTIONS[cardinalIndex + 1]);
            }
        }

        return position;
    }
}
