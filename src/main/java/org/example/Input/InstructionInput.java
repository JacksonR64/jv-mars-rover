package org.example.Input;

import org.example.INSTRUCTION;
import org.example.MOVEMENT_INSTRUCTION;
import org.example.ROTATE_INSTRUCTION;

import java.util.Scanner;

import static org.example.Input.InstructionParser.instructionParser;
import static org.example.Input.InvalidUserInputException.generalInstructionInputException;
import static org.example.InstructionsLog.*;
import static org.example.Rover.roverList;
import static org.example.Settings.*;
import static org.example.Input.SetUpInput.*;

public class InstructionInput {
    public static void instructionInput() {
        String input;
        int errorCount = 0;

        Scanner scanner = new Scanner(System.in);

        while (inputCounter < totalInitialInputs) {
            try {
                System.out.print(INSTRUCTION_PROMPT_MESSAGE);

                if (EXAMPLE_MODE_ON) {
                    System.out.println(EXAMPLE_INPUT[inputCounter]);
                    instructionParser(EXAMPLE_INPUT[inputCounter]);
                    return;}
                else input = scanner.nextLine();
                if (input.equalsIgnoreCase("END")) break;
                if (instructionParser(input)) {
                    for (INSTRUCTION instruction : instructionsLog.getLast())
                        if (instruction.getClass().getSimpleName().equals("MOVEMENT_INSTRUCTION"))
                            roverList.getLast().move((MOVEMENT_INSTRUCTION) instruction);
                        else if (instruction.getClass().getSimpleName().equals("ROTATE_INSTRUCTION"))
                            roverList.getLast().rotate((ROTATE_INSTRUCTION) instruction);

                    errorCount = 0;
                    System.out.print(VALID_INPUT_MESSAGE);
                }
            } catch (Exception e) {
                //throw new RuntimeException(e);
                errorCount++;
                if (errorCount < INSTRUCTION_ATTEMPT_WARMING_LIMIT)
                    System.out.print(INVALID_INPUT_MESSAGE);
                else if (errorCount < INSTRUCTION_ATTEMPT_END_LIMIT)
                    System.out.print(INVALID_INPUT_MESSAGE + DETAILED_INSTRUCTION_MESSAGE);
                else if (errorCount == INSTRUCTION_ATTEMPT_END_LIMIT)
                    System.out.print(INVALID_INPUT_MESSAGE + FINAL_WARNING + DETAILED_INSTRUCTION_MESSAGE);
                else throw generalInstructionInputException;
            }
            System.out.print(roverList.getLast());

        }
    }
}
