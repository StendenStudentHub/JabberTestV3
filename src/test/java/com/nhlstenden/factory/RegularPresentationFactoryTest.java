package com.nhlstenden.factory;

import com.nhlstenden.strategy.Presentation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RegularPresentationFactoryTest {

    @Test
    void createPresentation_ShouldReturnNonNullPresentation()
    {
        // Arrange
        PresentationFactory factory = new RegularPresentationFactory();

        // Act
        Presentation presentation = factory.CreatePresentation();

        // Assert
        assertNotNull(presentation);
    }
}
