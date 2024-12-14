package org.example.input.setup;

import org.example.enums.INSTRUCTION;
import org.example.enums.MOVEMENT_INSTRUCTION;
import org.example.enums.ROTATE_INSTRUCTION;
import org.example.entities.Rover;
import org.example.exceptions.InvalidUserInputException;

import java.util.Scanner;

import static org.example.config.ExampleConfig.*;
import static org.example.config.MessageProvider.*;
import static org.example.input.ErrorHandler.handleError;
import static org.example.input.parsers.InstructionParser.instructionParser;
import static org.example.instructions.InstructionsLog.*;
import static org.example.entities.Rover.roverList;
import static org.example.config.AppConfig.*;
import static org.example.input.SetUpInput.*;
import static org.example.input.ErrorHandler.errorCounter;

public class InstructionSetUp {
    // TODO: Refactor, abstract error handler
    public static int instructionCounter;


    public static void instructionInput() {
        instructionCounter = 1;
        errorCounter = 0;
        String input;

        Scanner scanner = new Scanner(System.in);

        while (inputCounter < totalInitialInputs) {
            try {
                System.out.print(INSTRUCTION_PROMPT_MESSAGE);

                if (EXAMPLE_MODE_ON) {
                    System.out.println(EXAMPLE_INPUT[inputCounter]);
                    instructionParser(EXAMPLE_INPUT[inputCounter]);

                    for (INSTRUCTION instruction : instructionsLog.getLast()) {
                        executeInstruction(instruction);
                    }

                    return;
                }

                input = scanner.nextLine();
                if (input.equalsIgnoreCase("END")) break;

                if (instructionParser(input)) {
                    for (INSTRUCTION instruction : instructionsLog.getLast()) {
                        executeInstruction(instruction);
                    }
                    errorCounter = 0;
                    System.out.print(VALID_INPUT_MESSAGE);
                }
            } catch (InvalidUserInputException e) {
                handleError("Instruction");
            } catch (Exception e){
                throw new InvalidUserInputException(e);
            }

            System.out.print(roverList.getLast());
        }
    }

    private static void executeInstruction(INSTRUCTION instruction) {
        Rover currentRover = roverList.getLast();
        String instructionCountFormatted = String.format("%02d", instructionCounter++);

        if (instruction instanceof MOVEMENT_INSTRUCTION) {
            if (currentRover.isInBounds(true)) {
                currentRover.move((MOVEMENT_INSTRUCTION) instruction);
                System.out.println(instructionCountFormatted + ": " + instruction + MOVED_MESSAGE + currentRover);
            } else {
                System.out.println(instructionCountFormatted + ": " + instruction + BONKED_MESSAGE + currentRover + " " + ROVER_HEADING_OOB_MESSAGE);
            }
        } else if (instruction instanceof ROTATE_INSTRUCTION) {
            currentRover.rotate((ROTATE_INSTRUCTION) instruction);
            System.out.println(instructionCountFormatted + ": " + instruction + TURNED_MESSAGE + currentRover);
        }
    }
}
