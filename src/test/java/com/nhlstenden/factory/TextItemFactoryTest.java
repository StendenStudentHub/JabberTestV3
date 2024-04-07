package com.nhlstenden.factory;

import com.nhlstenden.strategy.SlideItem;
import com.nhlstenden.strategy.TextItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextItemFactoryTest
{

    @Test
    void createSlideItem_ShouldReturnTextItem()
    {
        // Arrange
        TextItemFactory factory = new TextItemFactory();
        int level = 1;
        String content = "Sample text";

        // Act
        SlideItem item = factory.CreateSlideItem(level, content);

        // Assert
        assertTrue(item instanceof TextItem);
    }

    @Test
    void createSlideItem_ShouldSetLevelCorrectly()
    {
        // Arrange
        TextItemFactory factory = new TextItemFactory();
        int level = 2;
        String content = "Sample text";

        // Act
        SlideItem item = factory.CreateSlideItem(level, content);

        // Assert
        assertEquals(level, item.getLevel());
    }

    @Test
    void createSlideItem_ShouldSetContentCorrectly()
    {
        // Arrange
        TextItemFactory factory = new TextItemFactory();
        int level = 1;
        String content = "Sample text";

        // Act
        SlideItem item = factory.CreateSlideItem(level, content);

        // Assert
        assertEquals(content, ((TextItem) item).getText());
    }
}
