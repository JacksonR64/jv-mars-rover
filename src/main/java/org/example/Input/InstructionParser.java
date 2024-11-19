package org.example.Input;

import org.example.INSTRUCTION;
import org.example.MOVEMENT_INSTRUCTION;
import org.example.ROTATE_INSTRUCTION;

import java.util.ArrayList;
import java.util.Arrays;

import static org.example.Input.InvalidUserInputException.*;
import static org.example.Input.SetUpInput.*;
import static org.example.InstructionsLog.instructionsLog;
import static org.example.Rover.roverList;
import static org.example.Settings.*;

public class InstructionParser {
    private static int instructionCount;
    public static boolean instructionParser (String input) {
        instructionCount = 0;

        if (input == null) throw generalInstructionInputException;
        ArrayList<INSTRUCTION> newInstruction = new ArrayList<>();

        if (EXAMPLE_MODE_ON) input = EXAMPLE_INPUT[inputCounter];
        String[] inputArray = input.toUpperCase().split("");
        Arrays.stream(inputArray).forEach(s -> {
            if (MOVEMENT_INSTRUCTION.isValid(s)){
                newInstruction.add(MOVEMENT_INSTRUCTION.valueOf(s));
                instructionCount++;
                roverList.getLast().move(MOVEMENT_INSTRUCTION.valueOf(s));
                System.out.println(instructionCount + ": MOVES  : " + s + " - " + roverList.getLast().toString());

            }
            else if (ROTATE_INSTRUCTION.isValid(s)){
                newInstruction.add(ROTATE_INSTRUCTION.valueOf(s));
                instructionCount++;
                roverList.getLast().rotate(ROTATE_INSTRUCTION.valueOf(s));
                System.out.println(instructionCount + ": ROTATES: " + s + " - " + roverList.getLast().toString());


            }
            else throw generalInstructionInputException;
        });

        System.out.println("Instruction Count: " + instructionCount);

        instructionsLog.add(newInstruction);
        return true;
    }
}
