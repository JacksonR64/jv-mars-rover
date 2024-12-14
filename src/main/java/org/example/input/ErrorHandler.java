package org.example.input;

import java.util.HashMap;

import static org.example.config.AppConfig.*;
import static org.example.config.MessageProvider.*;
import static org.example.config.MessageProvider.DETAILED_INSTRUCTION_MESSAGE;
import static org.example.exceptions.InvalidUserInputException.generalInstructionInputException;


public class ErrorHandler {
    public static int errorCounter;

    public static final HashMap<String, String> invalidMap = new HashMap<>();

    public static void invalidMapper () {
        invalidMap.put("Plateau", INVALID_INPUT_MESSAGE + DETAILED_PLATEAU_MESSAGE);
        invalidMap.put("Rover", INVALID_INPUT_MESSAGE + DETAILED_ROVER_MESSAGE);
        invalidMap.put("Instruction", INVALID_INPUT_MESSAGE + DETAILED_INSTRUCTION_MESSAGE);

    }

    public static void handleError(String className) {
        invalidMapper ();
        errorCounter++;
        if (errorCounter < INSTRUCTION_ATTEMPT_WARMING_LIMIT) {
            System.out.print(INVALID_INPUT_MESSAGE);
        } else if (errorCounter < INSTRUCTION_ATTEMPT_END_LIMIT) {
            System.out.print(invalidMap.get(className));
        } else if (errorCounter == INSTRUCTION_ATTEMPT_END_LIMIT) {
            System.out.print(INVALID_INPUT_MESSAGE + invalidMap.get(className) + FINAL_WARNING);
        } else {
            throw generalInstructionInputException;
        }
    }
}
