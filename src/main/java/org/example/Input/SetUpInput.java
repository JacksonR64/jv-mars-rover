package org.example.Input;

import org.example.Rover;

import java.util.Scanner;

import static org.example.Input.PlateauCreationParser.plateauCreationParser;
import static org.example.Input.RoverCreationParser.roverCreationParser;

public class SetUpInput {
    public static void setUpInput () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter Plateau size X and Y: ");
        setUpPlateau(scanner);

        System.out.println("Please enter Rover X, Y, and Facing Direction: ");
        SetUpRover(scanner);

    }

    private static void setUpPlateau(Scanner scanner) {
        while (true){
            try {
                String input = scanner.nextLine();
                if (plateauCreationParser(input)){
                    System.out.println("Valid input accepted, Plateau created.\n");
                    break;
                } else {
                    System.out.println("Invalid input, Please try again.");
                }
            } catch (InvalidUserInputException e) {
                System.out.println(e.getMessage() + " Please try again!!!");;
            }
        }
    }

    private static void SetUpRover(Scanner scanner) {
        while (true){
            try {
                String input = scanner.nextLine();
                if (roverCreationParser(input)){
                    System.out.println("Valid input accepted, Rover created.\n");
                    break;
                } else {
                    System.out.println("Invalid input, Please try again.");
                }
            } catch (InvalidUserInputException e) {
                System.out.println(e.getMessage() + " Please try again!!!");;
            }
        }
    }
}
