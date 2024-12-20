package org.example.exceptions;

import static org.example.config.AppConfig.*;

public class InvalidUserInputException extends RuntimeException {
    public static InvalidUserInputException generalPlateauSizeInputException =
            new InvalidUserInputException
                    ("Error: Please enter exactly 2 values to create plateau.\n" +
                                                "(X: min:" + X_AXIS_MIN + " - max:" + X_AXIS_MAX + ")\n" +
                                                "(Y min:" + Y_AXIS_MIN + " - max: " + Y_AXIS_MAX);
    public static InvalidUserInputException InvalidXAxisSizeInputException =
            new InvalidUserInputException
                    ("Error: Please enter Valid Size for X axis." +
                            "\nX axis min: " + X_AXIS_MIN);

    public static InvalidUserInputException InvalidYAxisSizeInputException =
            new InvalidUserInputException
                    ("Error: Please enter Valid Size for Y axis." +
                            "\nX axis min: " + Y_AXIS_MIN);

    public static InvalidUserInputException InvalidDirectionException =
            new InvalidUserInputException
                    ("Error: invalid position direction");

    public static InvalidUserInputException generalRoverInputException =
            new InvalidUserInputException
                    ("Error: Please enter exactly 3 values (X, Y, Direction) to create rover.");

    public static InvalidUserInputException generalInstructionInputException =
            new InvalidUserInputException
                    ("Error: Please enter only valid Instructions. E.G. 'LMLMLMLMM'");

    public InvalidUserInputException() {
    }

    public InvalidUserInputException(Throwable cause) {
        super(cause);
    }

    public InvalidUserInputException(String message) {
        super(message);
    }

    public InvalidUserInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
