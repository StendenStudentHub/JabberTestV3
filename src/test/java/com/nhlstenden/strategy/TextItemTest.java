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

    @Test
    void getAttributedString_WithEmptyText_ShouldReturnAttributedString() {
        // Arrange
        TextItem textItem = new TextItem(1, "");
        float scale = 1.0f;

        // Act
        AttributedString attributedString = textItem.getAttributedString(scale);

        // Assert
        assertNotNull(attributedString);
        assertEquals("", attributedString.getIterator().toString());
    }

    @Test
    void getLayouts_WithEmptyText_ShouldReturnEmptyLayouts() {
        // Arrange
        TextItem textItem = new TextItem(1, "");
        float scale = 1.0f;
        Graphics graphics = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();
        MyStyle style = new MyStyle(50, Color.black, 36, 10);

        // Act
        List<TextLayout> layouts = textItem.getLayouts(graphics, style, scale);

        // Assert
        assertNotNull(layouts);
        assertEquals(0, layouts.size());
    }

    @Test
    void draw_WithEmptyText_ShouldNotThrow() {
        // Arrange
        TextItem textItem = new TextItem(1, "");
        float scale = 1.0f;
        Graphics graphics = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();
        MyStyle style = new MyStyle(50, Color.black, 36, 10);

        // Act & Assert
        assertDoesNotThrow(() -> textItem.draw(0, 0, scale, graphics, style, null));
    }

    @Test
    void getBoundingBox_WithEmptyText_ShouldReturnEmptyBoundingBox() {
        // Arrange
        TextItem textItem = new TextItem(1, "");
        float scale = 1.0f;
        Graphics graphics = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();
        MyStyle style = new MyStyle(90, Color.black, 24, 10);

        // Act
        Rectangle boundingBox = textItem.getBoundingBox(graphics, null, style, scale);

        // Assert
        assertNotNull(boundingBox);
        assertEquals(new Rectangle((int) (style.getIndent() * scale), 0, 0, (int) (style.getLeading() * scale)), boundingBox);
    }

    @Test
    void getLayouts_WithMultipleLines_ShouldReturnMultipleLayouts() {
        // Arrange
        TextItem textItem = new TextItem(1, "Test text that will wrap into multiple lines for sure");
        float scale = 1.0f;
        Graphics graphics = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();
        MyStyle style = new MyStyle(50, Color.black, 36, 10);

        // Act
        List<TextLayout> layouts = textItem.getLayouts(graphics, style, scale);

        // Assert
        assertNotNull(layouts);
        assertTrue(layouts.size() > 1);
    }

    @Test
    void getBoundingBox_WithMultipleLines_ShouldReturnLargerBoundingBox() {
        // Arrange
        TextItem textItem = new TextItem(1, "Test text that will wrap into multiple lines for sure");
        float scale = 1.0f;
        Graphics graphics = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();
        MyStyle style = new MyStyle(90, Color.black, 24, 10);

        // Act
        Rectangle boundingBox = textItem.getBoundingBox(graphics, null, style, scale);

        // Assert
        assertNotNull(boundingBox);
        assertTrue(boundingBox.height > style.getLeading());
    }

    @Test
    void draw_WithMultipleLines_ShouldNotThrow() {
        // Arrange
        TextItem textItem = new TextItem(1, "Test text that will wrap into multiple lines for sure");
        float scale = 1.0f;
        Graphics graphics = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();
        MyStyle style = new MyStyle(50, Color.black, 36, 10);

        // Act & Assert
        assertDoesNotThrow(() -> textItem.draw(0, 0, scale, graphics, style, null));
    }

    @Test
    void draw_WithDifferentScales_ShouldNotThrow() {
        // Arrange
        TextItem textItem = new TextItem(1, "Test text");
        Graphics graphics = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();
        MyStyle style = new MyStyle(50, Color.black, 36, 10);

        // Act & Assert for different scales
        assertDoesNotThrow(() -> textItem.draw(0, 0, 0.5f, graphics, style, null));
        assertDoesNotThrow(() -> textItem.draw(0, 0, 2.0f, graphics, style, null));
    }

    @Test
    void getBoundingBox_WithDifferentScales_ShouldReturnScaledBoundingBox() {
        // Arrange
        TextItem textItem = new TextItem(1, "Test text");
        Graphics graphics = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();
        MyStyle style = new MyStyle(90, Color.black, 24, 10);

        // Act & Assert for different scales
        Rectangle boundingBox1 = textItem.getBoundingBox(graphics, null, style, 0.5f);
        Rectangle boundingBox2 = textItem.getBoundingBox(graphics, null, style, 2.0f);

        // Assert
        assertNotNull(boundingBox1);
        assertNotNull(boundingBox2);
        assertTrue(boundingBox2.width > boundingBox1.width);
        assertTrue(boundingBox2.height > boundingBox1.height);
    }
}