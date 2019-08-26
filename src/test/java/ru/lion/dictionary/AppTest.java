package ru.lion.dictionary;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class AppTest {
    @Test
    public void testAppNotNull() throws IOException {
        // Retrieve resource
        InputStream is =
          getClass().getResourceAsStream("/test.properties");
        is.close();
        App classUnderTest = new App();
        assertNotNull(classUnderTest);
    }
}
