package com.nhlstenden.strategy;


import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.text.AttributedString;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TextItemTest
{

    @Test
    void getAttributedString_ShouldReturnAttributedString()
    {
        // Arrange
        TextItem textItem = new TextItem(1, "Test text");
        float scale = 1.0f;

        // Act
        AttributedString attributedString = textItem.getAttributedString(scale);

        // Assert
        assertNotNull(attributedString);
        assertEquals("Test text", attributedString.getIterator().toString());
    }

    @Test
    void getLayouts_ShouldReturnLayouts()
    {
        // Arrange
        TextItem textItem = new TextItem(1, "Test text");
        float scale = 1.0f;
        Graphics graphics = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();
        MyStyle style = new MyStyle(50, Color.black, 36, 10);

        // Act
        List<TextLayout> layouts = textItem.getLayouts(graphics, style, scale);

        // Assert
        assertNotNull(layouts);
        assertEquals(1, layouts.size());
    }

    @Test
    void draw_ShouldDrawTextItem()
    {
        // Arrange
        TextItem textItem = new TextItem(1, "Test text");
        float scale = 1.0f;
        Graphics graphics = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();
        MyStyle style = new MyStyle(50, Color.black, 36, 10);

        // Act & Assert
        assertDoesNotThrow(() -> textItem.draw(0, 0, scale, graphics, style, null));
    }

    @Test
    void getBoundingBox_ShouldReturnBoundingBox()
    {
        // Arrange
        TextItem textItem = new TextItem(1, "Test text");
        float scale = 1.0f;
        Graphics graphics = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();
        MyStyle style = new MyStyle(90, Color.black, 24, 10);

        // Act
        Rectangle boundingBox = textItem.getBoundingBox(graphics, null, style, scale);

        // Assert
        assertNotNull(boundingBox);
    }
}