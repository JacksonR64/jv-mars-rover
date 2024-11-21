package org.example.input;

import org.example.enums.INSTRUCTION;
import org.example.enums.MOVEMENT_INSTRUCTION;
import org.example.enums.ROTATE_INSTRUCTION;

import java.util.ArrayList;
import java.util.Arrays;

import static org.example.config.ExampleConfig.*;
import static org.example.exceptions.InvalidUserInputException.*;
import static org.example.input.SetUpInput.*;
import static org.example.instructions.InstructionsLog.instructionsLog;
import static org.example.config.AppConfig.*;

public class InstructionParser {

    public static boolean instructionParser(String input) {

        if (input == null) throw generalInstructionInputException;
        ArrayList<INSTRUCTION> newInstruction = new ArrayList<>();
        System.out.println();

        if (EXAMPLE_MODE_ON) input = EXAMPLE_INPUT[inputCounter];
        String[] inputArray = input.toUpperCase().split("");

        Arrays.stream(inputArray).forEach(s -> {

            if (MOVEMENT_INSTRUCTION.isValid(s))
                newInstruction.add(MOVEMENT_INSTRUCTION.valueOf(s));

            else if (ROTATE_INSTRUCTION.isValid(s))
                newInstruction.add(ROTATE_INSTRUCTION.valueOf(s));

            else throw generalInstructionInputException;
        });

        instructionsLog.add(newInstruction);
        return true;
    }


}
