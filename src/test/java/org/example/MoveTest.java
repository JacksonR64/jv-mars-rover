package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    @DisplayName("returns correct updated position when moved")
    void moveTest() {
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
        rover_5_5_N.move(MOVEMENT_INSTRUCTION.M);
        rover_5_5_E.move(MOVEMENT_INSTRUCTION.M);
        rover_5_5_S.move(MOVEMENT_INSTRUCTION.M);
        rover_5_5_W.move(MOVEMENT_INSTRUCTION.M);

        // Assert
        assertEquals(new Position(5, 6,DIRECTION.N), rover_5_5_N.getPosition());
        assertEquals(new Position(6, 5,DIRECTION.E), rover_5_5_E.getPosition());
        assertEquals(new Position(5, 4,DIRECTION.S), rover_5_5_S.getPosition());
        assertEquals(new Position(4, 5,DIRECTION.W), rover_5_5_W.getPosition());
    }
}
