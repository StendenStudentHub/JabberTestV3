package com.nhlstenden.factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DemoAccesorFactoryTest
{

    @Test
    void createReader_ShouldReturnDemoReader()
    {
        // Arrange
        DemoAccesorFactory factory = new DemoAccesorFactory();

        // Act
        Reader reader = factory.CreateReader();

        // Assert
        assertNotNull(reader);
        assertTrue(reader instanceof DemoReader);
    }

    @Test
    void createWriter_ShouldReturnDemoWriter()
    {
        // Arrange
        DemoAccesorFactory factory = new DemoAccesorFactory();

        // Act
        Writer writer = factory.CreateWriter();

        // Assert
        assertNotNull(writer);
        assertTrue(writer instanceof DemoWriter);
    }
}
