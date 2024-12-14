package org.example.config;

import org.example.enums.MOVEMENT_INSTRUCTION;
import org.example.enums.ROTATE_INSTRUCTION;

import java.util.Arrays;

import static org.example.config.AppConfig.*;

public class MessageProvider {
    // MESSAGES
    public static final String VALID_INPUT_MESSAGE = GREEN
            + "Input Valid! \n             MOVED: ";

    public static final String INVALID_INPUT_MESSAGE = RED
            + "Input Invalid! \n        NOT MOVED: ";

    public static final String INSTRUCTION_PROMPT_MESSAGE = "\n\n" + BLUE
            + "Please enter movement instructions: " + RESET + "\n";

    public static final String TRY_AGAIN_MESSAGE = "\n" + YELLOW
            + "Please Try Again: " + RESET;

    public static final String PLATEAU_CREATED_MESSAGE = "\n" + GREEN
            + "New Plateau created." + RESET;

    public static final String ROVER_CREATED_MESSAGE = "\n" + GREEN
            + "New Rover created." + RESET;

    public static final String PLATEAU_SET_UP_MESSAGE = "\n\n" + BLUE
            + "Please enter Plateau size X and Y:" + RESET;

    public static final String ROVER_SET_UP_MESSAGE = "\n\n" + BLUE +
            "Please enter Rover X, Y, and Facing Direction:" + RESET + "\n";

    public static final String MOVED_MESSAGE = " - " + GREEN +
            "MOVED  ✅" + RESET + " - ";

    public static final String TURNED_MESSAGE = " - " + GREEN +
            "TURNED ♻️" + RESET + " - ";

    public static final String BONKED_MESSAGE = " - " + YELLOW +
            "BONKED ‼️" + RESET + " - ";

    public static final String ROVER_PLACED_OOB_MESSAGE = "\n" + RED +
            "Rover placed out of bounds and exploded on impact 💥💥️" + RESET + "\n";

    public static final String ROVER_HEADING_OOB_MESSAGE = YELLOW +
            "(Rover hit a boundary wall and bounced back)" + RESET;

    public static final String DETAILED_PLATEAU_MESSAGE = "\n" + YELLOW + BOLD + UNDERLINE
            + "Please enter valid PLATEAU. \n" + "and/or any rotation instructions: "
            + Arrays.toString(ROTATE_INSTRUCTION.values()) + "\n" +
            "Enter String of movement instructions: "
            + Arrays.toString(MOVEMENT_INSTRUCTION.values()) + "\n" +
            "No spaces or other characters\n" +
            "E.G; \"M\", \"MMM\" or \"MMLLMRM\"\n"
            + RESET + "\n";

    public static final String DETAILED_ROVER_MESSAGE = "\n" + YELLOW + BOLD + UNDERLINE
            + "Please enter valid ROVER. \n" + "and/or any rotation instructions: "
            + Arrays.toString(ROTATE_INSTRUCTION.values()) + "\n" +
            "Enter String of movement instructions: "
            + Arrays.toString(MOVEMENT_INSTRUCTION.values()) + "\n" +
            "No spaces or other characters\n" +
            "E.G; \"M\", \"MMM\" or \"MMLLMRM\"\n"
            + RESET + "\n";

    public static final String DETAILED_INSTRUCTION_MESSAGE = "\n" + YELLOW + BOLD + UNDERLINE
            + "Please enter valid Instructions. \n" + "and/or any rotation instructions: "
            + Arrays.toString(ROTATE_INSTRUCTION.values()) + "\n" +
            "Enter String of movement instructions: "
            + Arrays.toString(MOVEMENT_INSTRUCTION.values()) + "\n" +
            "No spaces or other characters\n" +
            "E.G; \"M\", \"MMM\" or \"MMLLMRM\"\n"
            + RESET + "\n";

    public static final String FINAL_WARNING =
            "\n\n" + RED + BOLD + HIGHLIGHT +
                    "FINAL WARNING: " +
                    "PLEASE ENTER VALID INSTRUCTIONS ELSE THIS PROGRAM WILL TERMINATE"
                    + RESET;



}
