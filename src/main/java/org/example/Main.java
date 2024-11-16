package org.example;

import static org.example.Input.InstructionInput.instructionInput;
import static org.example.Input.SetUpInput.setUpInput;
import static org.example.Rover.roverCount;
import static org.example.Rover.roverList;
import static org.example.Settings.*;

public class Main {
    public static void main(String[] args) {

        setUpInput();
        if (roverCount != 0) {
            Rover rover1 = roverList.get(0);
            System.out.print(GREEN + "START: " + rover1 + RESET);
            instructionInput();
            System.out.print(GREEN + "END: " + rover1 + RESET);
        }

    }

}
