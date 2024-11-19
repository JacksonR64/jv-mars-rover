package org.example.Input;

import java.util.Scanner;

import static org.example.Input.InstructionInput.instructionInput;
import static org.example.Input.PlateauCreationParser.plateauCreationParser;
import static org.example.Input.RoverCreationParser.roverCreationParser;
import static org.example.Rover.roverList;
import static org.example.Settings.*;

public class SetUpInput {
    public static int inputCounter = -1;
    public static int totalInitialInputs = 0;

    public static void setUpInput() {




        Scanner scanner = new Scanner(System.in);

        if (EXAMPLE_MODE_ON) {
            totalInitialInputs = EXAMPLE_INPUT.length;
        }

        while (inputCounter++ < totalInitialInputs) {
            if (inputCounter == 0) setUpPlateau(scanner);

            else if (inputCounter % 2 != 0) SetUpRover(scanner);

            else if (inputCounter % 2 == 0) instructionInput();
        }
        if (EXAMPLE_MODE_ON) System.out.println(roverList.getFirst());

//            Rover rover1 = roverList.get(0);
//            System.out.print(GREEN + "START: " + rover1 + RESET);
//        instructionInput();
//            System.out.print(GREEN + "END: " + rover1 + RESET);



    }

    private static void setUpPlateau(Scanner scanner) {
        String input;
        System.out.println(PLATEAU_SET_UP_MESSAGE);
        while (inputCounter < EXAMPLE_INPUT.length) {
            try {
                if (EXAMPLE_MODE_ON) {
                    System.out.println(EXAMPLE_INPUT[inputCounter]);
                    plateauCreationParser(EXAMPLE_INPUT[inputCounter]);
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
        System.out.print(ROVER_SET_UP_MESSAGE);
        while (inputCounter < EXAMPLE_INPUT.length){
            try {
                if (EXAMPLE_MODE_ON) {
                    System.out.println(EXAMPLE_INPUT[inputCounter]);
                    roverCreationParser(EXAMPLE_INPUT[inputCounter]);
                    return;}
                else input = scanner.nextLine();
                if (roverCreationParser(input)){
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
