package org.example.input;

import org.example.entities.Rover;
import org.example.input.setup.PlateauSetUp;
import org.example.input.setup.RoverSetUp;

import java.util.Scanner;

import static org.example.config.AppConfig.*;
import static org.example.config.ExampleConfig.CUSTOM_EXAMPLE_INPUT;
import static org.example.config.ExampleConfig.EXAMPLE_INPUT;
import static org.example.entities.Plateau.plateauList;
import static org.example.entities.Rover.roverList;
import static org.example.input.ErrorHandler.errorCounter;
import static org.example.input.setup.InstructionSetUp.instructionInput;

public class SetUpInput {
    // TODO: Refactor, rename
    public static int inputCounter = 0;
    public static int totalInitialInputs = 0;

    public static void setUpInput() {

        Scanner scanner = new Scanner(System.in);
        Rover rover1 = null;

        if (CUSTOM_EXAMPLE_ON) EXAMPLE_INPUT = CUSTOM_EXAMPLE_INPUT;
        if (EXAMPLE_MODE_ON) {
            totalInitialInputs = EXAMPLE_INPUT.length;
        } else totalInitialInputs = 3;

        while (inputCounter < totalInitialInputs) {
            if (inputCounter == 0) {
                PlateauSetUp.setUpPlateau(scanner);
                System.out.println(GREEN + "\n              NEW: " + plateauList.getLast() + RESET);
            } else if ((inputCounter - errorCounter) % 2 != 0) {
                RoverSetUp.setUpRover(scanner);
                rover1 = roverList.getLast();
                System.out.print(GREEN + "             START: " + rover1 + RESET);
            } else if ((inputCounter - errorCounter) % 2 == 0) {
                instructionInput();
                System.out.print(GREEN + "               END: " + rover1 + RESET);
            }
            inputCounter++;
        }
        System.out.println();
        System.out.println(GREEN + "\n             END: " + plateauList.getLast() + RESET);

        if (EXAMPLE_MODE_ON) roverList.forEach(r -> System.out.println(r.getPosition().toSimpleString()));
    }

}
