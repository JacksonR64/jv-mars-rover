package org.example.Input;

import org.example.INSTRUCTION;
import org.example.MOVEMENT_INSTRUCTION;
import org.example.ROTATE_INSTRUCTION;

import java.util.Scanner;

import static org.example.Input.InstructionParser.instructionParser;
import static org.example.Input.InvalidUserInputException.generalInstructionInputException;
import static org.example.InstructionsLog.instructionsLog;
import static org.example.Rover.roverList;
import static org.example.Settings.*;

public class InstructionInput {
    public static void instructionInput() {
        Scanner scanner = new Scanner(System.in);

        String input;
        int errorCount = 0;

        while (true) {
            try {
                System.out.println("Please enter instructions: ");
                input = scanner.nextLine();

                if (input.equalsIgnoreCase("END")) break;
                if (instructionParser(input)) {
                    for (INSTRUCTION instruction : instructionsLog.getLast())
                        if (instruction.getClass().getSimpleName().equals("MOVEMENT_INSTRUCTION"))
                            roverList.get(0).move((MOVEMENT_INSTRUCTION) instruction);
                        else if (instruction.getClass().getSimpleName().equals("ROTATE_INSTRUCTION"))
                            roverList.get(0).rotate((ROTATE_INSTRUCTION) instruction);

                    errorCount = 0;
                    System.out.println(VALID_INPUT_MESSAGE);
                    System.out.println(roverList.get(0) + "\n");
                }
            } catch (Exception e) {
                //throw new RuntimeException(e);
                errorCount++;
                if (errorCount < INSTRUCTION_ATTEMPT_WARMING_LIMIT)
                    System.out.println(INVALID_INPUT_MESSAGE);
                else if (errorCount < INSTRUCTION_ATTEMPT_END_LIMIT)
                    System.out.println(INVALID_INPUT_MESSAGE + DETAILED_INSTRUCTION_MESSAGE);
                else if (errorCount == INSTRUCTION_ATTEMPT_END_LIMIT)
                    System.out.println(INVALID_INPUT_MESSAGE + FINAL_WARNING + DETAILED_INSTRUCTION_MESSAGE);
                else throw generalInstructionInputException;
            }
        }
    }
}
