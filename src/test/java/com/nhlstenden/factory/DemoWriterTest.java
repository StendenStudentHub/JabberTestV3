package com.nhlstenden.factory;

import com.nhlstenden.strategy.Presentation;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DemoWriterTest
{

    @Test
    void write_ShouldThrowIOException()
    {
        // Arrange
        DemoWriter writer = new DemoWriter();
        Presentation presentation = mock(Presentation.class);
        String filename = "demo.xml";

        // Act & Assert
        assertThrows(IOException.class, () -> writer.Write(presentation, filename));
    }

    @Test
    void write_ShouldLogError() throws IOException
    {
        // Arrange
        DemoWriter writer = new DemoWriter();
        Presentation presentation = mock(Presentation.class);
        String filename = "demo.xml";
        Logger logger = mock(Logger.class);

        // Act
        try
        {
            writer.Write(presentation, filename);
        }
        catch (IOException e)
        {
            // Assert
            verify(logger).severe("Unable to save the demo presentation");
        }
    }
}
