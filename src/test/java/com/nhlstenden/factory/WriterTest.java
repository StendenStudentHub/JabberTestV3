package com.nhlstenden.factory;

import com.nhlstenden.strategy.Presentation;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.io.IOException;

public class WriterTest
{
    @Test
    void write_ShouldCallWriteMethod() throws IOException
    {
        // Arrange
        Presentation presentation = mock(Presentation.class);
        Writer writer = mock(Writer.class);

        // Act
        writer.Write(presentation, "test.xml");

        // Assert
        verify(writer).Write(presentation, "test.xml");
    }
}
