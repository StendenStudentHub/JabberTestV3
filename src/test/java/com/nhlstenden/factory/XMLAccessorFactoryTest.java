package com.nhlstenden.factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class XMLAccessorFactoryTest {

    @Test
    void createReader_ShouldReturnXMLReaderInstance()
    {
        // Arrange
        XMLAccessorFactory factory = new XMLAccessorFactory();

        // Act
        Reader reader = factory.CreateReader();

        // Assert
        assertNotNull(reader);
        assertTrue(reader instanceof XMLReader);
    }

    @Test
    void createWriter_ShouldReturnXMLWriterInstance()
    {
        // Arrange
        XMLAccessorFactory factory = new XMLAccessorFactory();

        // Act
        Writer writer = factory.CreateWriter();

        // Assert
        assertNotNull(writer);
        assertTrue(writer instanceof XMLWriter);
    }
}
