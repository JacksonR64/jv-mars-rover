package org.example.input.parsers;
import org.example.enums.DIRECTION;
import org.example.core.Position;
import org.example.entities.Rover;

import static org.example.exceptions.InvalidUserInputException.generalRoverInputException;

public class RoverCreationParser {
    // TODO: Improve Error handling
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
