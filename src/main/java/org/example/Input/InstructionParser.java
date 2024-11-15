package org.example.Input;

import org.example.INSTRUCTION;
import org.example.MOVEMENT_INSTRUCTION;
import org.example.ROTATE_INSTRUCTION;

import java.util.ArrayList;
import java.util.Arrays;

import static org.example.Input.InvalidUserInputException.generalInstructionInputException;
import static org.example.InstructionsLog.instructionsLog;

public class InstructionParser {
    public static boolean instructionParser (String input) {

        if (input == null) throw generalInstructionInputException;
        ArrayList<INSTRUCTION> newInstruction = new ArrayList<>();

        String[] inputArray = input.toUpperCase().split("");
        Arrays.stream(inputArray).forEach(s -> {
            if (MOVEMENT_INSTRUCTION.isValid(s)){
                newInstruction.add(MOVEMENT_INSTRUCTION.valueOf(s));
            }
            else if (ROTATE_INSTRUCTION.isValid(s)){
                newInstruction.add(ROTATE_INSTRUCTION.valueOf(s));
            }
            else throw generalInstructionInputException;
        });

        instructionsLog.add(newInstruction);
        return true;
    }
}
