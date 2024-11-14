import org.example.Input.PlateauCreationParser;
import org.example.Input.*;
import org.example.PlateauSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.example.Input.PlateauCreationParser.*;
import static org.example.Settings.X_AXIS_MIN;
import static org.example.Settings.Y_AXIS_MIN;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @Test
    @DisplayName("Valid expected inputs return correct PlateauSize")
    void plateauCreationParserValidInputTest() {
        // Arrange
        String input1 = "1 1";
        String input2 = "0 0";
        String input3 = "99 99";
        String input4 = "1234 9876";

        // Act
        PlateauSize expected1 = plateauCreationParser(input1);
        PlateauSize expected2 = plateauCreationParser(input2);
        PlateauSize expected3 = plateauCreationParser(input3);
        PlateauSize expected4 = plateauCreationParser(input4);

        // Assert
        assertArrayEquals(new int[]{1, 1}, new int[]{expected1.getxAxis(), expected1.getyAxis()});
        assertArrayEquals(new int[]{0, 0}, new int[]{expected2.getxAxis(), expected2.getyAxis()});
        assertArrayEquals(new int[]{99, 99}, new int[]{expected3.getxAxis(), expected3.getyAxis()});
        assertArrayEquals(new int[]{1234, 9876}, new int[]{expected4.getxAxis(), expected4.getyAxis()});
    }

    @Test
    @DisplayName("Valid expected inputs return correct PlateauSize")
    void plateauCreationParserInvalidInputTest() {
        // Arrange
        String input1 = null;
        String input2 = "";
        String input3 = "1";
        String input4 = "1 2 3";
        String input5 = "12 34 56 78 90";
        String input6 = "0 5";
        String input7 = "5 0";
        String input8 = "x=5 y=5";
        String input9 = "-5 -5";
        String input10 = "5,5";

        String generalPlateauSizeInputExceptionMessage =
                "Error: Please enter exactly 2 values to create plateau." +
                "\nX axis min: " + X_AXIS_MIN +
                "\nY axis min: " + Y_AXIS_MIN;
        String InvalidXAxisSizeInputException =
        ("Error: Please enter Valid Size for X axis." +
                "\nX axis min: " + X_AXIS_MIN);
        String InvalidYAxisSizeInputException ="Error: Please enter Valid Size for Y axis." +
                                "\nX axis min: " + Y_AXIS_MIN;

        // Act
        InvalidUserInputException exception1 = assertThrows(
                InvalidUserInputException.class, () -> plateauCreationParser(input1));
        InvalidUserInputException exception2 = assertThrows(
                InvalidUserInputException.class, () -> plateauCreationParser(input2));
        InvalidUserInputException exception3 = assertThrows(
                InvalidUserInputException.class, () -> plateauCreationParser(input3));
        InvalidUserInputException exception4 = assertThrows(
                InvalidUserInputException.class, () -> plateauCreationParser(input4));
        InvalidUserInputException exception5 = assertThrows(
                InvalidUserInputException.class, () -> plateauCreationParser(input5));
        InvalidUserInputException exception6 = assertThrows(
                InvalidUserInputException.class, () -> plateauCreationParser(input6));
        InvalidUserInputException exception7 = assertThrows(
                InvalidUserInputException.class, () -> plateauCreationParser(input7));
        InvalidUserInputException exception8 = assertThrows(
                InvalidUserInputException.class, () -> plateauCreationParser(input8));
        InvalidUserInputException exception9 = assertThrows(
                InvalidUserInputException.class, () -> plateauCreationParser(input9));
        InvalidUserInputException exception10 = assertThrows(
                InvalidUserInputException.class, () -> plateauCreationParser(input10));

        // Assert
        assertEquals(generalPlateauSizeInputExceptionMessage, exception1.getMessage());
        assertEquals(generalPlateauSizeInputExceptionMessage, exception2.getMessage());
        assertEquals(generalPlateauSizeInputExceptionMessage, exception3.getMessage());
        assertEquals(generalPlateauSizeInputExceptionMessage, exception4.getMessage());
        assertEquals(generalPlateauSizeInputExceptionMessage, exception5.getMessage());
        assertEquals(InvalidXAxisSizeInputException, exception6.getMessage());
        assertEquals(InvalidYAxisSizeInputException, exception7.getMessage());
        assertEquals(generalPlateauSizeInputExceptionMessage, exception8.getMessage());
        assertEquals(generalPlateauSizeInputExceptionMessage, exception9.getMessage());
        assertEquals(generalPlateauSizeInputExceptionMessage, exception10.getMessage());

    }
}
