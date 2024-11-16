package org.example.Input;

import java.util.Scanner;

import static org.example.Input.PlateauCreationParser.plateauCreationParser;
import static org.example.Input.RoverCreationParser.roverCreationParser;
import static org.example.Settings.*;

public class SetUpInput {
    public static void setUpInput() {
        Scanner scanner = new Scanner(System.in);

        setUpPlateau(scanner);

        SetUpRover(scanner);

    }

    private static void setUpPlateau(Scanner scanner) {
        System.out.println(PLATEAU_SET_UP_MESSAGE);
        while (true) {
            try {
                String input = scanner.nextLine();
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
        System.out.print(ROVER_SET_UP_MESSAGE);
        while (true){
            try {
                String input = scanner.nextLine();
                if (roverCreationParser(input)){
//                    System.out.println(ROVER_CREATED_MESSAGE);
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
