import org.example.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testTest() {
        // Arrange
        String input1 = "test";

        // Act
        int expected1 = Main.test(input1);

        // Assert
        assertEquals(expected1,0);
    }

}
