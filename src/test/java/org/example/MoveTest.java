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
        Rover rover1 = new Rover(facingNorth);
        Rover rover2 = new Rover(facingEast);
        Rover rover3 = new Rover(facingSouth);
        Rover rover4 = new Rover(facingWest);

        // Act
        rover1.move(MOVEMENT_INSTRUCTION.M);
        rover2.move(MOVEMENT_INSTRUCTION.M);
        rover3.move(MOVEMENT_INSTRUCTION.M);
        rover4.move(MOVEMENT_INSTRUCTION.M);

        // Assert
        assertEquals(new Rover(new Position(6, 5,DIRECTION.N)), rover1);
        assertEquals(new Rover(new Position(5, 6,DIRECTION.E)), rover2);
        assertEquals(new Rover(new Position(4, 5,DIRECTION.S)), rover3);
        assertEquals(new Rover(new Position(5, 4,DIRECTION.W)), rover4);

    }
}
