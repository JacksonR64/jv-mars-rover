package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateTest {

    @Test
    @DisplayName("tests rover entity updates position correctly when rotated Left")
    void RotateRoverEntityLeftTest() {
        // Arrange
        Rover test1 = new Rover(new Position(0, 0, DIRECTION.N));
        Rover test2 = new Rover(new Position(0, 0, DIRECTION.E));
        Rover test3 = new Rover(new Position(0, 0, DIRECTION.S));
        Rover test4 = new Rover(new Position(0, 0, DIRECTION.W));

        // Act
        test1.rotate(ROTATE_INSTRUCTION.L);
        test2.rotate(ROTATE_INSTRUCTION.L);
        test3.rotate(ROTATE_INSTRUCTION.L);
        test4.rotate(ROTATE_INSTRUCTION.L);

        // Assert
        assertEquals(new Rover(new Position(0, 0,DIRECTION.W)), test1);
        assertEquals(new Rover(new Position(0, 0,DIRECTION.N)), test2);
        assertEquals(new Rover(new Position(0, 0,DIRECTION.E)), test3);
        assertEquals(new Rover(new Position(0, 0,DIRECTION.S)), test4);
    }

    @Test
    @DisplayName("tests rover entity updates position correctly when rotated right")
    void RotateRoverEntityRightTest() {
        // Arrange
        Rover test1 = new Rover(new Position(0, 0, DIRECTION.N));
        Rover test2 = new Rover(new Position(0, 0, DIRECTION.E));
        Rover test3 = new Rover(new Position(0, 0, DIRECTION.S));
        Rover test4 = new Rover(new Position(0, 0, DIRECTION.W));

        // Act
        test1.rotate(ROTATE_INSTRUCTION.R);
        test2.rotate(ROTATE_INSTRUCTION.R);
        test3.rotate(ROTATE_INSTRUCTION.R);
        test4.rotate(ROTATE_INSTRUCTION.R);

        // Assert
        assertEquals(new Rover(new Position(0, 0,DIRECTION.E)), test1);
        assertEquals(new Rover(new Position(0, 0,DIRECTION.S)), test2);
        assertEquals(new Rover(new Position(0, 0,DIRECTION.W)), test3);
        assertEquals(new Rover(new Position(0, 0,DIRECTION.N)), test4);
    }
}
