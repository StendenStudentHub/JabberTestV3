package com.nhlstenden.strategy;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ImageObserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SlideItemTest {

    private static class MockSlideItem extends SlideItem
    {
        public MockSlideItem(int level)
        {
            super(level);
        }

        @Override
        public String getText() {
            return null;
        }

        @Override
        public void draw(int x, int y, float scale, Graphics graphics, MyStyle style, ImageObserver imageObserver)
        {
            // Do nothing in this mock implementation
        }

        @Override
        public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, MyStyle style, float scale)
        {
            // Return a dummy bounding box for testing purposes
            return new Rectangle(0, 0, 100, 100);
        }
    }

    @Test
    void constructor_ShouldCreateSlideItemWithGivenLevel()
    {
        // Arrange
        int level = 2;

        // Act
        SlideItem slideItem = new MockSlideItem(level);

        // Assert
        assertEquals(level, slideItem.getLevel());
    }

    @Test
    void addSlideItem_ShouldAddSubItemToSlideItem()
    {
        // Arrange
        SlideItem slideItem = new MockSlideItem(1);
        SlideItem subItem = new MockSlideItem(2);

        // Act
        slideItem.addSlideItem(subItem);

        // Assert
        assertEquals(1, slideItem.getSubItems());
        assertNotNull(slideItem.getSubItemsList().get(0));
    }

    @Test
    void getStyle_ShouldReturnNonNullStyle()
    {
        // Arrange
        SlideItem slideItem = new MockSlideItem(1);

        // Act
        MyStyle style = (MyStyle) slideItem.getStyle();

        // Assert
        assertNotNull(style);
    }
}
