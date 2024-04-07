package com.nhlstenden.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PresentationTest {

    @Test
    void constructor_ShouldCreateEmptyPresentation()
    {
        // Arrange + Act
        Presentation presentation = new Presentation();

        // Assert
        assertEquals("", presentation.getTitle());
        assertEquals(0, presentation.getSlideNumber());
        assertEquals(0, presentation.getSize());
    }

    @Test
    void setTitle_ShouldSetPresentationTitle()
    {
        // Arrange
        Presentation presentation = new Presentation();
        String title = "Test Presentation";

        // Act
        presentation.setTitle(title);

        // Assert
        assertEquals(title, presentation.getTitle());
    }

    @Test
    void append_ShouldAddSlideToPresentation()
    {
        // Arrange
        Presentation presentation = new Presentation();
        Slide slide = new Slide();

        // Act
        presentation.append(slide);

        // Assert
        assertEquals(1, presentation.getSize());
        assertEquals(slide, presentation.getSlide(0));
    }

    @Test
    void getSlide_ShouldReturnCorrectSlide()
    {
        // Arrange
        Presentation presentation = new Presentation();
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        presentation.append(slide1);
        presentation.append(slide2);

        // Act + Assert
        assertEquals(slide1, presentation.getSlide(0));
        assertEquals(slide2, presentation.getSlide(1));
    }

    @Test
    void getSlide_ShouldReturnNullForInvalidSlideNumber()
    {
        // Arrange
        Presentation presentation = new Presentation();
        Slide slide = new Slide();
        presentation.append(slide);

        // Act + Assert
        assertNull(presentation.getSlide(-1));
        assertNull(presentation.getSlide(1));
        assertNull(presentation.getSlide(100));
    }

    @Test
    void getCurrentSlide_ShouldReturnCorrectCurrentSlide()
    {
        // Arrange
        Presentation presentation = new Presentation();
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.setSlideNumber(1);

        // Act + Assert
        assertEquals(slide2, presentation.getCurrentSlide());
    }

    @Test
    void clear_ShouldRemoveAllSlidesAndResetCurrentSlideNumber()
    {
        // Arrange
        Presentation presentation = new Presentation();
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.setSlideNumber(1);

        // Act
        presentation.clear();

        // Assert
        assertEquals(0, presentation.getSize());
        assertEquals(0, presentation.getSlideNumber());
    }
}
