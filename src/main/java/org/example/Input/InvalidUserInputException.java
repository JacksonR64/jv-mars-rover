package org.example.Input;

import static org.example.Settings.*;

public class InvalidUserInputException extends RuntimeException {
    public static InvalidUserInputException generalPlateauSizeInputException =
            new InvalidUserInputException
                    ("Error: Please enter exactly 2 values to create plateau." +
                                                "\nX axis min: " + X_AXIS_MIN +
                                                "\nY axis min: " + Y_AXIS_MIN);
    public static InvalidUserInputException InvalidXAxisSizeInputException =
            new InvalidUserInputException
                    ("Error: Please enter Valid Size for X axis." +
                            "\nX axis min: " + X_AXIS_MIN);

    public static InvalidUserInputException InvalidYAxisSizeInputException =
            new InvalidUserInputException
                    ("Error: Please enter Valid Size for Y axis." +
                            "\nX axis min: " + Y_AXIS_MIN);

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
