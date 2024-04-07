package com.nhlstenden.factory;

import com.nhlstenden.strategy.Presentation;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReaderTest {

    static class MockReader extends Reader
    {
        @Override
        public Presentation Read(String fileName) throws IOException
        {
            // Mock implementation, returns a dummy presentation
            return new Presentation();
        }
    }

    @Test
    void read_ShouldReturnNonNullPresentation() throws IOException
    {
        // Arrange
        Reader reader = new MockReader();

        // Act
        Presentation presentation = reader.Read("dummyFileName");

        // Assert
        assertNotNull(presentation);
    }
}
