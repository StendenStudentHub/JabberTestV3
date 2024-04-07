package com.nhlstenden.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccessorFactoryTest {

    private AccessorFactory factory;

    @BeforeEach
    void setUp() {
        factory = new DemoAccesorFactory();
    }

    @Test
    void testGetFactoryForXMLFile() {
        // Arrange
        String fileName = "data.xml";

        // Act
        AccessorFactory factory = AccessorFactory.GetFactory(fileName);

        // Assert
        assertTrue(factory instanceof XMLAccessorFactory);
    }

    @Test
    void testGetFactoryForNonXMLFile() {
        // Arrange
        String fileName = "data.txt";

        // Act
        AccessorFactory factory = AccessorFactory.GetFactory(fileName);

        // Assert
        assertTrue(factory instanceof DemoAccesorFactory);
    }

    @Test
    void testCreateReaderForDemoFactory() {
        // Act
        Reader reader = factory.CreateReader();

        // Assert
        assertTrue(reader instanceof DemoReader);
    }

    @Test
    void testCreateWriterForDemoFactory() {
        // Act
        Writer writer = factory.CreateWriter();

        // Assert
        assertTrue(writer instanceof DemoWriter);
    }
}
