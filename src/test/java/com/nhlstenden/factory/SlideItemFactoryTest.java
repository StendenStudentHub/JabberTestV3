package com.nhlstenden.factory;

import com.nhlstenden.strategy.BitmapItem;
import com.nhlstenden.strategy.SlideItem;
import com.nhlstenden.strategy.TextItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SlideItemFactoryTest {

    @Test
    void getSlideItemFactory_WithTextItemType_ShouldReturnTextItemFactory()
    {
        // Arrange
        String textItemType = "text";

        // Act
        SlideItemFactory factory = SlideItemFactory.GetSlideItemFactory(textItemType);

        // Assert
        assertNotNull(factory);
        assertTrue(factory instanceof TextItemFactory);
    }

    @Test
    void getSlideItemFactory_WithImageItemType_ShouldReturnBitmapItemFactory()
    {
        // Arrange
        String imageItemType = "image";

        // Act
        SlideItemFactory factory = SlideItemFactory.GetSlideItemFactory(imageItemType);

        // Assert
        assertNotNull(factory);
        assertTrue(factory instanceof BitmapItemFactory);
    }

    @Test
    void getSlideItemFactory_WithUnknownItemType_ShouldReturnNull()
    {
        // Arrange
        String unknownItemType = "unknown";

        // Act
        SlideItemFactory factory = SlideItemFactory.GetSlideItemFactory(unknownItemType);

        // Assert
        assertNull(factory);
    }

    @Test
    void createSlideItem_WithTextItemType_ShouldReturnTextItem()
    {
        // Arrange
        SlideItemFactory factory = new TextItemFactory();
        int level = 1;
        String content = "Sample text";

        // Act
        SlideItem item = factory.CreateSlideItem(level, content);

        // Assert
        assertNotNull(item);
        assertEquals(level, item.getLevel());
        assertEquals(content, ((TextItem) item).getText());
    }

    @Test
    void createSlideItem_WithImageItemType_ShouldReturnBitmapItem()
    {
        // Arrange
        SlideItemFactory factory = new BitmapItemFactory();
        int level = 1;
        String imageName = "sample.jpg";

        // Act
        SlideItem item = factory.CreateSlideItem(level, imageName);

        // Assert
        assertNotNull(item);
        assertEquals(level, item.getLevel());
        assertEquals(imageName, ((BitmapItem) item).getImageName());
    }
}
