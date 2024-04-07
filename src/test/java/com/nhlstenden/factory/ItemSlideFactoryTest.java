package com.nhlstenden.factory;

import com.nhlstenden.strategy.Slide;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemSlideFactoryTest {

    @Test
    void createSlide_ShouldReturnNonNullSlide()
    {
        // Arrange
        ItemSlideFactory factory = new ItemSlideFactory();

        // Act
        Slide slide = factory.CreateSLide();

        // Assert
        assertNotNull(slide);
    }
}
