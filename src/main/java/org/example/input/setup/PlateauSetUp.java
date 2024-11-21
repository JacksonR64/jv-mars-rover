package org.example.input.setup;

import org.example.exceptions.InvalidUserInputException;
import org.example.input.SetUpInput;

import java.util.Scanner;

import static org.example.config.AppConfig.EXAMPLE_MODE_ON;
import static org.example.config.ExampleConfig.EXAMPLE_INPUT;
import static org.example.config.MessageProvider.*;
import static org.example.input.parsers.PlateauCreationParser.plateauCreationParser;

public class PlateauSetUp {
    public static void setUpPlateau(Scanner scanner) {
        String input;
        System.out.println(PLATEAU_SET_UP_MESSAGE);
        while (SetUpInput.inputCounter < SetUpInput.totalInitialInputs) {
            try {
                if (EXAMPLE_MODE_ON) {
                    System.out.println(EXAMPLE_INPUT[SetUpInput.inputCounter]);
                    plateauCreationParser(EXAMPLE_INPUT[SetUpInput.inputCounter]);
                    System.out.print(PLATEAU_CREATED_MESSAGE);
                    return;}
                else input = scanner.nextLine();

                if (plateauCreationParser(input)) {
                    System.out.print(PLATEAU_CREATED_MESSAGE);
                    break;
                } else {
                    System.out.print(INVALID_INPUT_MESSAGE);
                }
            } catch (InvalidUserInputException e) {
                System.out.println(e.getMessage());
                System.out.println(TRY_AGAIN_MESSAGE);
            }
        }
    }
}
