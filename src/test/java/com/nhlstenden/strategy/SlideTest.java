package com.nhlstenden.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SlideTest {

    @Test
    void constructor_ShouldCreateEmptySlide() {
        // Arrange + Act
        Slide slide = new Slide();

        // Assert
        assertFalse(slide.isDrawAllItems());
        assertEquals(0, slide.getNumberOfItemsToDraw());
        assertEquals(0, slide.getSize());
    }

    @Test
    void append_ShouldAddSlideItemToSlide() {
        // Arrange
        Slide slide = new Slide();
        SlideItem slideItem = new TextItem(1, "Test Item");

        // Act
        slide.append(slideItem);

        // Assert
        assertEquals(1, slide.getSize());
        assertEquals(slideItem, slide.getSlideItem(0));
    }

    @Test
    void getTitle_ShouldReturnTitleTextItem() {
        // Arrange
        Slide slide = new Slide();
        String titleText = "Test Title";
        slide.setTitle(titleText);

        // Act + Assert
        assertEquals(titleText, slide.getTitle().getText());
    }

    @Test
    void appendWithTitle_ShouldAddTitleToSlide() {
        // Arrange
        Slide slide = new Slide();
        String titleText = "Test Title";

        // Act
        slide.setTitle(titleText);

        // Assert
        assertNotNull(slide.getTitle());
        assertEquals(titleText, slide.getTitle().getText());
    }

    @Test
    void getSize_ShouldReturnNumberOfSlideItems() {
        // Arrange
        Slide slide = new Slide();
        SlideItem slideItem1 = new TextItem(1, "Item 1");
        SlideItem slideItem2 = new TextItem(2, "Item 2");
        slide.append(slideItem1);
        slide.append(slideItem2);

        // Act + Assert
        assertEquals(2, slide.getSize());
    }

    @Test
    void getSlideItems_ShouldReturnAllSlideItems() {
        // Arrange
        Slide slide = new Slide();
        SlideItem slideItem1 = new TextItem(1, "Item 1");
        SlideItem slideItem2 = new TextItem(2, "Item 2");
        slide.append(slideItem1);
        slide.append(slideItem2);

        // Act
        var slideItems = slide.getSlideItems();

        // Assert
        assertEquals(2, slideItems.size());
        assertTrue(slideItems.contains(slideItem1));
        assertTrue(slideItems.contains(slideItem2));
    }
}
