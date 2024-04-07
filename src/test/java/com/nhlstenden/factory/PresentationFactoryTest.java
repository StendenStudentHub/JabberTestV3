package com.nhlstenden.factory;

import com.nhlstenden.strategy.Presentation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PresentationFactoryTest
{

    @Test
    void createPresentation_ShouldReturnNonNullPresentation()
    {
        // Arrange
        PresentationFactory factory = PresentationFactory.GetFactory(PresentationFactory.SupportedPresentationTypes.REGULARPRESENTATION);

        // Act
        Presentation presentation = factory.CreatePresentation();

        // Assert
        assertNotNull(presentation);
    }
}
