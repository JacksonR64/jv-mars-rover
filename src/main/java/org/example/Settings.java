package org.example;

import java.util.Arrays;

public class Settings {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[3m";


    public static final int DEFAULT_TICK = 1;
    public static final int X_AXIS_MIN = 1;
    public static final int Y_AXIS_MIN = 1;
    public static final int INSTRUCTION_ATTEMPT_WARMING_LIMIT = 3;
    public static final int INSTRUCTION_ATTEMPT_END_LIMIT = 5;
    public static final String VALID_INPUT_MESSAGE = "✅\n";
    public static final String INVALID_INPUT_MESSAGE = "❌\n";
    public static final String DETAILED_INSTRUCTION_MESSAGE =
            "\n" + YELLOW + BOLD + UNDERLINE +
                    "Please enter valid Instructions. \n" +
                    RESET +
                    "Enter String of movement instructions: " + Arrays.toString(MOVEMENT_INSTRUCTION.values()) + "\n" +
                    "and/or any rotation instructions: " + Arrays.toString(ROTATE_INSTRUCTION.values()) + "\n" +
                    "No spaces or other characters\n" +
                    "E.G; \"M\", \"MMM\" or \"MMLLMRM\"\n"
                    + RESET;
    public static final String FINAL_WARNING =
            "\n" + RED + BOLD +
                    "FINAL WARNING: " +
                    "PLEASE ENTER VALID INSTRUCTIONS ELSE THIS PROGRAM WILL TERMINATE\n"
                    + RESET;


}
