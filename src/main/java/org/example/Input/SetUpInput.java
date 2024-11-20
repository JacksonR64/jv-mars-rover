package org.example.Input;

import org.example.Rover;
import java.util.Scanner;

import static org.example.Input.InstructionInput.errorCount;
import static org.example.Input.InstructionInput.instructionInput;
import static org.example.Input.PlateauCreationParser.plateauCreationParser;
import static org.example.Input.RoverCreationParser.roverCreationParser;
import static org.example.Plateau.plateauList;
import static org.example.Rover.roverList;
import static org.example.Settings.*;

public class SetUpInput {
    public static int inputCounter = 0;
    public static int totalInitialInputs = 0;

    public static void setUpInput() {

        Scanner scanner = new Scanner(System.in);
        Rover rover1 = null;

        if (CUSTOM_EXAMPLE_ON) EXAMPLE_INPUT = CUSTOM_EXAMPLE_INPUT;
        if (EXAMPLE_MODE_ON) {
            totalInitialInputs = EXAMPLE_INPUT.length;
        }
        else totalInitialInputs = 3;

        while (inputCounter < totalInitialInputs) {
            if (inputCounter == 0) {
                setUpPlateau(scanner);
                System.out.println(GREEN + "\n              NEW: " + plateauList.getLast() + RESET);
            }
            else if ((inputCounter - errorCount)% 2 != 0) {
                SetUpRover(scanner);
                rover1 = roverList.getLast();
                System.out.print(GREEN + "             START: " + rover1 + RESET);
            }
            else if ((inputCounter - errorCount )% 2 == 0) {
                instructionInput();
                System.out.print(GREEN + "               END: " + rover1 + RESET);
            }
            inputCounter++;
        }
        System.out.println();
        System.out.println(GREEN + "\n             END: " + plateauList.getLast() + RESET);

        if (EXAMPLE_MODE_ON) roverList.forEach(r -> System.out.println(r.getPosition().toSimpleString()));
    }

    private static void setUpPlateau(Scanner scanner) {
        String input;
        System.out.println(PLATEAU_SET_UP_MESSAGE);
        while (inputCounter < totalInitialInputs) {
            try {
                if (EXAMPLE_MODE_ON) {
                    System.out.println(EXAMPLE_INPUT[inputCounter]);
                    plateauCreationParser(EXAMPLE_INPUT[inputCounter]);
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

    private static void SetUpRover(Scanner scanner) {
        String input;
        while (inputCounter < totalInitialInputs){
            System.out.print(ROVER_SET_UP_MESSAGE);
            try {
                if (EXAMPLE_MODE_ON) {
                    System.out.println(EXAMPLE_INPUT[inputCounter]);
                    roverCreationParser(EXAMPLE_INPUT[inputCounter]);
                    System.out.println(ROVER_CREATED_MESSAGE);
                    return;}
                else input = scanner.nextLine();


                if (roverCreationParser(input)){
                    if (roverList.getLast().getIsAlive())
                        System.out.println(ROVER_CREATED_MESSAGE);
                    break;
                } else {
                    System.out.print(INVALID_INPUT_MESSAGE);
                }
            } catch (InvalidUserInputException e) {
                System.out.print(e.getMessage());
                System.out.print(TRY_AGAIN_MESSAGE);
            }

        }
    }
}
