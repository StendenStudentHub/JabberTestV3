package com.nhlstenden.facade;

import com.nhlstenden.strategy.Presentation;
import com.nhlstenden.strategy.Slide;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GeneratePresentationTest
{

    @Test
    void generatePresentation_ShouldCreatePresentationWithTitleAndSlides_WhenValidParametersProvided() {
        // Arrange
        String title = "My Presentation";
        ArrayList<Integer> levels = new ArrayList<Integer>();
        levels.add(4);
        levels.add(3);
        levels.add(9);
        ArrayList<String> slideTwoTitles = new ArrayList<String>();
        slideTwoTitles.add("slide 1");
        slideTwoTitles.add("slide 2");
        slideTwoTitles.add("slide 3");
        ArrayList<String> slideTwoTexts = new ArrayList<String>();
        slideTwoTexts.add("text 1");
        slideTwoTexts.add("text 2");
        slideTwoTexts.add("text 3");

        // Act
        Presentation presentation = GeneratePresentation.generatePresentation(title, levels, slideTwoTitles, slideTwoTexts);

        // Assert
        assertNotNull(presentation);
        assertEquals(title, presentation.getTitle());
        assertEquals(slideTwoTitles.size(), presentation.getSize());

        for (int i = 0; i < slideTwoTitles.size(); i++)
        {
            Slide slide = presentation.getSlide(i);
            assertNotNull(slide);
            assertEquals(slideTwoTitles.get(i), slide.getTitle());
            assertEquals(1, slide.getSize());
            assertEquals(levels.get(i), slide.getSlideItem(0).getLevel());
            assertEquals(slideTwoTexts.get(i), slide.getSlideItem(0).getText());
        }
    }

    @Test
    void generatePresentation_ShouldCreateEmptyPresentation_WhenEmptyArraysProvided()
    {
        // Arrange
        String title = "Empty Presentation";
        ArrayList<Integer> levels = new ArrayList<Integer>();
        ArrayList<String> slideTwoTitles = new ArrayList<String>();
        ArrayList<String> slideTwoTexts = new ArrayList<String>();

        // Act
        Presentation presentation = GeneratePresentation.generatePresentation(title, levels, slideTwoTitles, slideTwoTexts);

        // Assert
        assertNotNull(presentation);
        assertEquals(title, presentation.getTitle());
        assertEquals(0, presentation.getSize());
    }
}
