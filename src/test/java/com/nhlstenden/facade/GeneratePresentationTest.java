package com.nhlstenden.facade;

import com.nhlstenden.strategy.Presentation;
import com.nhlstenden.strategy.Slide;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GeneratePresentationTest
{

    @Test
    void generatePresentation_ShouldCreatePresentationWithTitleAndSlides_WhenValidParametersProvided() {
        // Arrange
        String title = "My Presentation";
        int[] levels = {1, 2, 1};
        String[] slideTwoTitles = {"Slide 1", "Slide 2", "Slide 3"};
        String[] slideTwoTexts = {"Text 1", "Text 2", "Text 3"};

        // Act
        Presentation presentation = GeneratePresentation.generatePresentation(title, levels, slideTwoTitles, slideTwoTexts);

        // Assert
        assertNotNull(presentation);
        assertEquals(title, presentation.getTitle());
        assertEquals(slideTwoTitles.length, presentation.getSize());

        for (int i = 0; i < slideTwoTitles.length; i++)
        {
            Slide slide = presentation.getSlide(i);
            assertNotNull(slide);
            assertEquals(slideTwoTitles[i], slide.getTitle());
            assertEquals(1, slide.getSize());
            assertEquals(levels[i], slide.getSlideItem(0).getLevel());
            assertEquals(slideTwoTexts[i], slide.getSlideItem(0).getText());
        }
    }

    @Test
    void generatePresentation_ShouldCreateEmptyPresentation_WhenEmptyArraysProvided()
    {
        // Arrange
        String title = "Empty Presentation";
        int[] levels = {};
        String[] slideTwoTitles = {};
        String[] slideTwoTexts = {};

        // Act
        Presentation presentation = GeneratePresentation.generatePresentation(title, levels, slideTwoTitles, slideTwoTexts);

        // Assert
        assertNotNull(presentation);
        assertEquals(title, presentation.getTitle());
        assertEquals(0, presentation.getSize());
    }
}
