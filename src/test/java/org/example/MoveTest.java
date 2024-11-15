package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.Position.*;
import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    @DisplayName("returns correct updated position when moved")
    void moveTest() {
        // Arrange
        Rover test1 = new Rover(facingNorth);
        Rover test2 = new Rover(facingEast);
        Rover test3 = new Rover(facingSouth);
        Rover test4 = new Rover(facingWest);

        // Act
        test1.move(MOVEMENT_INSTRUCTION.M);
        test2.move(MOVEMENT_INSTRUCTION.M);
        test3.move(MOVEMENT_INSTRUCTION.M);
        test4.move(MOVEMENT_INSTRUCTION.M);

        // Assert
        assertEquals(new Rover(new Position(6, 5,DIRECTION.N)), test1);
        assertEquals(new Rover(new Position(5, 6,DIRECTION.E)), test2);
        assertEquals(new Rover(new Position(4, 5,DIRECTION.S)), test3);
        assertEquals(new Rover(new Position(5, 4,DIRECTION.W)), test4);

    }
}
