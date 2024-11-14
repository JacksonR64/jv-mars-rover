package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.Move.move;
import static org.example.Rotate.rotate;
import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    @DisplayName("returns correct updated position when moved")
    void moveTest() {
        // Arrange
        Position facingNorth = new Position(5, 5, DIRECTION.N);
        Position facingEast = new Position(5, 5, DIRECTION.E);
        Position facingSouth = new Position(5, 5, DIRECTION.S);
        Position facingWest = new Position(5, 5, DIRECTION.W);

        // Act
        Position result1 = move(facingNorth, MOVEMENT_INSTRUCTION.M);
        Position result2 = move(facingEast, MOVEMENT_INSTRUCTION.M);
        Position result3 = move(facingSouth, MOVEMENT_INSTRUCTION.M);
        Position result4 = move(facingWest, MOVEMENT_INSTRUCTION.M);


        // Assert
        assertAll(
                () -> assertEquals(6, result1.getX()),
                () -> assertEquals(5, result1.getY())
        );
        assertAll(
                () -> assertEquals(5, result2.getX()),
                () -> assertEquals(6, result2.getY())
        );
        assertAll(
                () -> assertEquals(4, result3.getX()),
                () -> assertEquals(5, result3.getY())
        );
        assertAll(
                () -> assertEquals(5, result4.getX()),
                () -> assertEquals(4, result4.getY())
        );
        assertEquals(6, result1.getX());
        assertEquals(6, result2.getY());
        assertEquals(4, result3.getX());
        assertEquals(4, result4.getY());


    }
}
