package com.nhlstenden.factory;

import com.nhlstenden.strategy.Slide;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SlideFactoryTest
{

    @Test
    void getFactory_WithItemSlideType_ShouldReturnItemSlideFactory()
    {
        // Arrange
        SlideFactory.SupportedSlideTypes slideType = SlideFactory.SupportedSlideTypes.ITEMSLIDE;

        // Act
        SlideFactory factory = SlideFactory.GetFactory(slideType);

        // Assert
        assertNotNull(factory);
        assertTrue(factory instanceof ItemSlideFactory);
    }

    @Test
    void createSlide_WithItemSlideFactory_ShouldReturnItemSlide()
    {
        // Arrange
        SlideFactory factory = new ItemSlideFactory();

        // Act
        Slide slide = factory.CreateSLide();

        // Assert
        assertNotNull(slide);
        assertEquals("Item Slide", slide.getTitle());
    }
}
