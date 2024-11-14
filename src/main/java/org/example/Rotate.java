package org.example;

import java.util.Arrays;

import static org.example.Position.DIRECTIONS;
import static org.example.Position.totalDirectionCount;

public class Rotate {
    public static Position rotate (Position position, ROTATE_INSTRUCTION ROTATEINSTRUCTION){
        int cardinalIndex = Arrays.binarySearch(DIRECTIONS, position.getFacing());

        if (ROTATEINSTRUCTION.equals(ROTATE_INSTRUCTION.L)){
            if (cardinalIndex == 0){
                position.setFacing(DIRECTIONS[totalDirectionCount]);
            }else {
                position.setFacing(DIRECTIONS[cardinalIndex - 1]);
            }
        }

        if (ROTATEINSTRUCTION.equals(ROTATE_INSTRUCTION.R)){
            if (cardinalIndex == totalDirectionCount){
                position.setFacing(DIRECTIONS[0]);
            }else {
                position.setFacing(DIRECTIONS[cardinalIndex + 1]);
            }
        }

        return position;
    }
}
