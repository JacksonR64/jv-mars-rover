import org.example.DIRECTION;
import org.example.Position;
import org.example.ROTATE_INSTRUCTION;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.Rotate.rotate;
import static org.junit.jupiter.api.Assertions.*;

class RotateTest {

    @Test
    @DisplayName("returns correct updated position when rotated left")
    void RotateLeftTest() {
        // Arrange
        Position facingNorth = new Position(0, 0, DIRECTION.N);
        Position facingEast = new Position(0, 0, DIRECTION.E);
        Position facingSouth = new Position(0, 0, DIRECTION.S);
        Position facingWest = new Position(0, 0, DIRECTION.W);

        // Act
        Position result1 = rotate(facingNorth, ROTATE_INSTRUCTION.L);
        Position result2 = rotate(facingEast, ROTATE_INSTRUCTION.L);
        Position result3 = rotate(facingSouth, ROTATE_INSTRUCTION.L);
        Position result4 = rotate(facingWest, ROTATE_INSTRUCTION.L);


        // Assert
        assertEquals(DIRECTION.W, result1.getFacing());
        assertEquals(DIRECTION.N, result2.getFacing());
        assertEquals(DIRECTION.E, result3.getFacing());
        assertEquals(DIRECTION.S, result4.getFacing());


    }

    @Test
    @DisplayName("returns correct updated position when rotated right")
    void RotateRightTest() {
        // Arrange
        Position facingNorth = new Position(0, 0, DIRECTION.N);
        Position facingEast = new Position(0, 0, DIRECTION.E);
        Position facingSouth = new Position(0, 0, DIRECTION.S);
        Position facingWest = new Position(0, 0, DIRECTION.W);

        // Act
        Position result1 = rotate(facingNorth, ROTATE_INSTRUCTION.R);
        Position result2 = rotate(facingEast, ROTATE_INSTRUCTION.R);
        Position result3 = rotate(facingSouth, ROTATE_INSTRUCTION.R);
        Position result4 = rotate(facingWest, ROTATE_INSTRUCTION.R);


        // Assert
        assertEquals(DIRECTION.E, result1.getFacing());
        assertEquals(DIRECTION.S, result2.getFacing());
        assertEquals(DIRECTION.W, result3.getFacing());
        assertEquals(DIRECTION.N, result4.getFacing());


    }

}
