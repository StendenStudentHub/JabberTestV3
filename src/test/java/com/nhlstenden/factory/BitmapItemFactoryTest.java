package com.nhlstenden.factory;

import com.nhlstenden.strategy.BitmapItem;
import com.nhlstenden.strategy.SlideItem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

public class BitmapItemFactoryTest {

    private BitmapItemFactory bitmapItemFactory;

    @BeforeEach
    void setUp()
    {
        bitmapItemFactory = new BitmapItemFactory();
    }

    @Test
    void createSlideItem_WhenValidLevelAndContentProvided_ShouldReturnBitmapItem()
    {
        // Arrange
        int level = 1;
        String content = "image.png";

        // Act
        SlideItem slideItem = bitmapItemFactory.CreateSlideItem(level, content);

        // Assert
        assertNotNull(slideItem);
        assertTrue(slideItem instanceof BitmapItem);
        assertEquals(level, slideItem.getLevel());
        assertEquals(content, ((BitmapItem) slideItem).getImagePath());
    }

    @Test
    void createSlideItem_WhenIOExceptionThrown_ShouldThrowRuntimeException() throws IOException
    {
        // Arrange
        int level = 1;
        String content = "invalid_image.png";
        BitmapItemFactory mockedFactory = mock(BitmapItemFactory.class);
        when(mockedFactory.CreateSlideItem(level, content)).thenThrow(IOException.class);

        // Act & Assert
        assertThrows(RuntimeException.class, () ->
        {
            mockedFactory.CreateSlideItem(level, content);
        });
    }
}
