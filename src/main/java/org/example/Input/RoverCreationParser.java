package org.example.Input;

import org.example.DIRECTION;
import org.example.Position;
import org.example.Rover;

import static org.example.Input.InvalidUserInputException.generalRoverInputException;

public class RoverCreationParser {
    public static boolean roverCreationParser (String input) {
        if (input == null || input.isEmpty()) throw generalRoverInputException;
        int x;
        int y;
        DIRECTION facing;

        String[] inputArray = input.toUpperCase().split(" ");
        if (inputArray.length != 3) throw generalRoverInputException;


        if (inputArray[0].matches("[0-9]*")) {
            x = Integer.parseInt(inputArray[0]);
        } else throw generalRoverInputException;

        if (inputArray[1].matches("[0-9]*"))
            y = Integer.parseInt(inputArray[1]);
        else throw generalRoverInputException;

        if (DIRECTION.isValid(inputArray[2]))
            facing = DIRECTION.valueOf(inputArray[2]);
        else throw generalRoverInputException;

        new Rover(new Position(x, y, facing));
        return true;
    }
}
