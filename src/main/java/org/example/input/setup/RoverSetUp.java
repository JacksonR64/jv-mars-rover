package org.example.input.setup;

import org.example.exceptions.InvalidUserInputException;
import org.example.input.SetUpInput;

import java.util.Scanner;

import static org.example.config.AppConfig.EXAMPLE_MODE_ON;
import static org.example.config.ExampleConfig.EXAMPLE_INPUT;
import static org.example.config.MessageProvider.*;
import static org.example.entities.Rover.roverList;
import static org.example.input.ErrorHandler.handleError;
import static org.example.input.SetUpInput.inputCounter;
import static org.example.input.SetUpInput.totalInitialInputs;
import static org.example.input.parsers.RoverCreationParser.roverCreationParser;

public class RoverSetUp {
    public static void setUpRover(Scanner scanner) {
        String input;
        while (inputCounter < totalInitialInputs) {
            System.out.print(ROVER_SET_UP_MESSAGE);
            try {
                if (EXAMPLE_MODE_ON) {
                    System.out.println(EXAMPLE_INPUT[inputCounter]);
                    roverCreationParser(EXAMPLE_INPUT[inputCounter]);
                    System.out.println(ROVER_CREATED_MESSAGE);
                    return;
                } else input = scanner.nextLine();

                if (roverCreationParser(input)) {
                        System.out.println(ROVER_CREATED_MESSAGE);
                    break;
                } else {
                    System.out.print(INVALID_INPUT_MESSAGE);
                }
            } catch (Exception e) {
                handleError("Rover");
            }


        }
    }
}
