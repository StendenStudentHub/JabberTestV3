package com.nhlstenden.strategy;

import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStyleTest
{

    @Test
    void getIndent_ShouldReturnIndent()
    {
        // Arrange
        int indent = 20;
        MyStyle style = new MyStyle(indent, Color.BLACK, 12, 10);

        // Act
        int result = style.getIndent();

        // Assert
        assertEquals(indent, result);
    }

    @Test
    void getColor_ShouldReturnColor()
    {
        // Arrange
        Color color = Color.BLUE;
        MyStyle style = new MyStyle(20, color, 12, 10);

        // Act
        Color result = style.getColor();

        // Assert
        assertEquals(color, result);
    }

    @Test
    void getLeading_ShouldReturnLeading()
    {
        // Arrange
        int leading = 10;
        MyStyle style = new MyStyle(20, Color.BLACK, 12, leading);

        // Act
        int result = style.getLeading();

        // Assert
        assertEquals(leading, result);
    }

    @Test
    void getFont_ShouldReturnScaledFont()
    {
        // Arrange
        float scale = 1.5f;
        int fontSize = 12;
        MyStyle style = new MyStyle(20, Color.BLACK, fontSize, 10);

        // Act
        Font font = style.getFont(scale);

        // Assert
        assertEquals(Font.BOLD, font.getStyle());
        assertEquals(fontSize * scale, font.getSize());
    }

    @Test
    void toString_ShouldReturnStringRepresentation()
    {
        // Arrange
        int indent = 20;
        Color color = Color.BLACK;
        int fontSize = 12;
        int leading = 10;
        MyStyle style = new MyStyle(indent, color, fontSize, leading);

        // Act
        String result = style.toString();

        // Assert
        assertEquals("{" + indent + "," + color + ", " + fontSize + " on " + leading + "}", result);
    }
}
