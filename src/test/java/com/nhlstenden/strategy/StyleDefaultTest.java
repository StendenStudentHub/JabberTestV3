package com.nhlstenden.strategy;

import org.junit.jupiter.api.Test;
import java.awt.*;
import java.awt.image.ImageObserver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StyleDefaultTest
{

    @Test
    void setStyle_ShouldSetCorrectStyleForSlideItem()
    {
        // Arrange
        StyleDefault styleDefault = new StyleDefault();
        SlideItem slideItem = new MockSlideItem(2); // Assuming level 2
        styleDefault.styleDefault(); // Initialize default styles

        // Act
        styleDefault.setStyle(slideItem);

        // Assert
        MyStyle expectedStyle = new MyStyle(50, Color.black, 36, 10); // Expected style for level 2
        assertEquals(expectedStyle.toString(), slideItem.getStyle().toString());
    }

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
}
