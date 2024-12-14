
package org.example;


import org.example.entities.Plateau;
import org.example.entities.PlateauSize;
import org.example.exceptions.InvalidUserInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.example.exceptions.InvalidUserInputException.generalPlateauSizeInputException;
import static org.example.input.parsers.PlateauCreationParser.plateauCreationParser;
import static org.junit.jupiter.api.Assertions.*;


class PlateauCreationParserTest {
    @Test
    @DisplayName("valid expected inputs return correct PlateauSize")
    void plateauCreationParserValidInputTest() {
        // Arrange
        String input1 = "1 1";
        String input2 = "5 5";
        String input3 = "99 99";
        String input4 = "1234 9876";

        // Act
        boolean result1 = plateauCreationParser(input1);
        boolean result2 = plateauCreationParser(input2);
        boolean result3 = plateauCreationParser(input3);
        boolean result4 = plateauCreationParser(input4);

        // Assert
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertTrue(result4);

    }
    @Test
    @DisplayName("invalid inputs throw correct exception")
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

        // Act & Assert
        assertThrows(InvalidUserInputException.class, () -> plateauCreationParser(input1));
        assertThrows(InvalidUserInputException.class, () -> plateauCreationParser(input2));
        assertThrows(InvalidUserInputException.class, () -> plateauCreationParser(input3));
        assertThrows(InvalidUserInputException.class, () -> plateauCreationParser(input4));
        assertThrows(InvalidUserInputException.class, () -> plateauCreationParser(input5));
        assertThrows(InvalidUserInputException.class, () -> plateauCreationParser(input6));
        assertThrows(InvalidUserInputException.class, () -> plateauCreationParser(input7));
        assertThrows(InvalidUserInputException.class, () -> plateauCreationParser(input8));
        assertThrows(InvalidUserInputException.class, () -> plateauCreationParser(input9));
        assertThrows(InvalidUserInputException.class, () -> plateauCreationParser(input10));

    }
}
