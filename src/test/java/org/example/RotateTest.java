package org.example;

import org.example.core.Position;
import org.example.entities.Plateau;
import org.example.entities.PlateauSize;
import org.example.entities.Rover;
import org.example.enums.DIRECTION;
import org.example.enums.ROTATE_INSTRUCTION;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateTest {



    @Test
    @DisplayName("tests rover entity updates position correctly when rotated Left")
    void RotateRoverEntityLeftTest() {
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
        rover_5_5_N.rotate(ROTATE_INSTRUCTION.L);
        rover_5_5_E.rotate(ROTATE_INSTRUCTION.L);
        rover_5_5_S.rotate(ROTATE_INSTRUCTION.L);
        rover_5_5_W.rotate(ROTATE_INSTRUCTION.L);

        // Assert
        assertEquals(new Rover(new Position(5, 5,DIRECTION.W)), rover_5_5_N);
        assertEquals(new Rover(new Position(5, 5,DIRECTION.N)), rover_5_5_E);
        assertEquals(new Rover(new Position(5, 5,DIRECTION.E)), rover_5_5_S);
        assertEquals(new Rover(new Position(5, 5,DIRECTION.S)), rover_5_5_W);
    }

    @Test
    @DisplayName("tests rover entity updates position correctly when rotated right")
    void RotateRoverEntityRightTest() {
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
        rover_5_5_N.rotate(ROTATE_INSTRUCTION.R);
        rover_5_5_E.rotate(ROTATE_INSTRUCTION.R);
        rover_5_5_S.rotate(ROTATE_INSTRUCTION.R);
        rover_5_5_W.rotate(ROTATE_INSTRUCTION.R);

        // Assert
        assertEquals(new Rover(new Position(5, 5,DIRECTION.E)), rover_5_5_N);
        assertEquals(new Rover(new Position(5, 5,DIRECTION.S)), rover_5_5_E);
        assertEquals(new Rover(new Position(5, 5,DIRECTION.W)), rover_5_5_S);
        assertEquals(new Rover(new Position(5, 5,DIRECTION.N)), rover_5_5_W);
    }
}
