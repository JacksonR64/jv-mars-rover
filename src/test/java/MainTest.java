import org.example.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testTest() {
        // Arrange
        int input1 = 1;

        // Act
        int expected1 = Main.test(input1);

        // Assert
        assertEquals(expected1,1);
    }
}
