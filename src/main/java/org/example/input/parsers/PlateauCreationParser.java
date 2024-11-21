package org.example.input.parsers;

import org.example.entities.Plateau;
import org.example.entities.PlateauSize;

import static org.example.exceptions.InvalidUserInputException.*;
import static org.example.config.AppConfig.*;

public class PlateauCreationParser {
    public static boolean plateauCreationParser (String input) {

        if (input == null || input.isEmpty()) throw generalPlateauSizeInputException;
        int x = 0;
        int y = 0;
        String[] inputArray = input.split(" ");
        if (inputArray.length != 2) throw generalPlateauSizeInputException;

        for (String s : input.split(" ")) {
            if (s.matches("[0-9]*")) {
                if (x < X_AXIS_MIN) {
                    try {
                        x = Integer.parseInt(s);
                        if (x < X_AXIS_MIN) throw InvalidXAxisSizeInputException;
                    } catch (NumberFormatException e) {
                        throw InvalidXAxisSizeInputException;
                    }
                }
                else if (y < Y_AXIS_MIN) {
                    try {
                        y = Integer.parseInt(s);
                        if (y< Y_AXIS_MIN) throw InvalidYAxisSizeInputException;

                    } catch (NumberFormatException e) {
                        throw InvalidYAxisSizeInputException;
                    }
                }
                else throw generalPlateauSizeInputException;
            }
            else throw generalPlateauSizeInputException;
        }
        new Plateau(new PlateauSize(x, y));
        return true;
    }

}
