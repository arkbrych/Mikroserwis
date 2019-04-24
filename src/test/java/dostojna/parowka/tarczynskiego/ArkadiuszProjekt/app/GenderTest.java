package dostojna.parowka.tarczynskiego.ArkadiuszProjekt.app;

import static dostojna.parowka.tarczynskiego.ArkadiuszProjekt.app.Gender.checkGender;
import static org.junit.jupiter.api.Assertions.*;

class GenderTest {

    @org.junit.jupiter.api.Test
    void ShouldReturnFWhenFemale() {
        // Arrange
        String name = "Anna";

        // Act
        String result = checkGender(name);

        // Assert
        assertEquals("F",result);
    }

    @org.junit.jupiter.api.Test
    void ShouldReturnMWhenMale() {
        // Arrange
        String name = "Arkadiusz";

        // Act
        String result = checkGender(name);

        // Assert
        assertEquals("M",result);
    }
}