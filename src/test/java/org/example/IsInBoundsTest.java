package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsInBoundsTest {

    @Test
    @DisplayName("returns true when checked within bounds of plateau")
    void isInBoundsTest() {
        // Arrange
        Plateau plateau_10_10 = new Plateau(new PlateauSize(10,10));
        Position facingNorth = new Position(5, 5, DIRECTION.N);
        Position facingEast = new Position(5, 5, DIRECTION.E);
        Position facingSouth = new Position(5, 5, DIRECTION.S);
        Position facingWest = new Position(5, 5, DIRECTION.W);
        Rover rover_5_5_N = new Rover(facingNorth);
        Rover rover_5_5_E = new Rover(facingEast);
        Rover rover_5_5_S = new Rover(facingSouth);
        Rover rover_5_5_W = new Rover(facingWest);

        // Act
        boolean result1 = rover_5_5_N.isInBounds();
        boolean result2 = rover_5_5_E.isInBounds();
        boolean result3 = rover_5_5_S.isInBounds();
        boolean result4 = rover_5_5_W.isInBounds();

        // Assert
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertTrue(result4);
    }

    @Test
    @DisplayName("returns false when checked well out of bounds of plateau")
    void isOutOfBoundsTest() {
        // Arrange
        Plateau plateau_10_10 = new Plateau(new PlateauSize(10,10));
        Position facingNorth = new Position(20, 20, DIRECTION.N);
        Position facingEast = new Position(20, 20, DIRECTION.E);
        Position facingSouth = new Position(20, 20, DIRECTION.S);
        Position facingWest = new Position(20, 20, DIRECTION.W);
        Rover rover_20_20_N = new Rover(facingNorth);
        Rover rover_20_20_E = new Rover(facingEast);
        Rover rover_20_20_S = new Rover(facingSouth);
        Rover rover_20_20_W = new Rover(facingWest);

        // Act
        boolean result1 = rover_20_20_N.isInBounds();
        boolean result2 = rover_20_20_E.isInBounds();
        boolean result3 = rover_20_20_S.isInBounds();
        boolean result4 = rover_20_20_W.isInBounds();

        // Assert
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
    }

    @Test
    @DisplayName("returns false when checked 1 tick bounds of plateau")
    void isJustOutOfBoundsTest() {
        // Arrange
        Plateau plateau_10_10 = new Plateau(new PlateauSize(10,10));
        Position facingNorth = new Position(5, 11, DIRECTION.N);
        Position facingEast = new Position(11, 5, DIRECTION.E);
        Position facingSouth = new Position(5, 11, DIRECTION.S);
        Position facingWest = new Position(11, 5, DIRECTION.W);
        Rover rover_5_11_N = new Rover(facingNorth);
        Rover rover_11_5_E = new Rover(facingEast);
        Rover rover_5_11_S = new Rover(facingSouth);
        Rover rover_11_5_W = new Rover(facingWest);

        // Act
        boolean result1 = rover_5_11_N.isInBounds();
        boolean result2 = rover_11_5_E.isInBounds();
        boolean result3 = rover_5_11_S.isInBounds();
        boolean result4 = rover_11_5_W.isInBounds();

        // Assert
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
    }

    @Test
    @DisplayName("returns true when checked on the boundary line of plateau")
    void isInBoundsOnBoundaryTest() {
        // Arrange
        Plateau plateau_10_10 = new Plateau(new PlateauSize(10,10));
        Position facingNorth = new Position(10, 10, DIRECTION.N);
        Position facingEast = new Position(10, 10, DIRECTION.E);
        Position facingSouth = new Position(10, 10, DIRECTION.S);
        Position facingWest = new Position(10, 10, DIRECTION.W);
        Rover rover_10_10_N = new Rover(facingNorth);
        Rover rover_10_10_E = new Rover(facingEast);
        Rover rover_10_10_S = new Rover(facingSouth);
        Rover rover_10_10_W = new Rover(facingWest);

        // Act
        boolean result1 = rover_10_10_N.isInBounds();
        boolean result2 = rover_10_10_E.isInBounds();
        boolean result3 = rover_10_10_S.isInBounds();
        boolean result4 = rover_10_10_W.isInBounds();

        // Assert
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertTrue(result4);
    }


}
