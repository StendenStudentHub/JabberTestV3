package com.nhlstenden.strategy;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class BitmapItemTest {

    @Test
    void testConstructor() throws IOException
    {
        // Arrange
        int level = 1;
        String imageName = "testImage.png";

        // Act
        BitmapItem bitmapItem = new BitmapItem(level, imageName);

        // Assert
        assertEquals(level, bitmapItem.getLevel());
        assertEquals(imageName, bitmapItem.getImageName());
        assertNotNull(bitmapItem.getBufferedImage());
    }

    @Test
    void testGetImageName() throws IOException
    {
        // Arrange
        String imageName = "testImage.png";
        BitmapItem bitmapItem = new BitmapItem(1, imageName);

        // Act & Assert
        assertEquals(imageName, bitmapItem.getImageName());
    }

    @Test
    void testToString() throws IOException
    {
        // Arrange
        String imageName = "testImage.png";
        int level = 2;
        BitmapItem bitmapItem = new BitmapItem(level, imageName);

        // Act & Assert
        assertEquals("{" + imageName + ", " + level + "}", bitmapItem.toString());
    }

    @Test
    void testGetBufferedImage() throws IOException
    {
        // Arrange
        String imageName = "testImage.png";
        BitmapItem bitmapItem = new BitmapItem(1, imageName);

        // Act & Assert
        assertNotNull(bitmapItem.getBufferedImage());
    }

    @Test
    void testDraw() throws IOException
    {
        // Arrange
        String imageName = "testImage.png";
        BitmapItem bitmapItem = new BitmapItem(1, imageName);

        BufferedImage bufferedImage = ImageIO.read(new File(imageName));
        Graphics graphics = bufferedImage.getGraphics();
        int x = 0, y = 0;
        float scale = 1.0f;
        MyStyle style = new MyStyle(20, Color.blue, 40, 10);
        ImageObserver imageObserver = null;

        // Act & Assert
        assertDoesNotThrow(() -> bitmapItem.draw(x, y, scale, graphics, style, imageObserver));
    }

    @Test
    void testGetBoundingBox() throws IOException
    {
        // Arrange
        String imageName = "testImage.png";
        BitmapItem bitmapItem = new BitmapItem(1, imageName);

        BufferedImage bufferedImage = ImageIO.read(new File(imageName));
        Graphics graphics = bufferedImage.getGraphics();
        MyStyle style = new MyStyle(0, Color.red, 48, 20);
        float scale = 1.0f;
        ImageObserver observer = null;

        // Act & Assert
        assertNotNull(bitmapItem.getBoundingBox(graphics, observer, style, scale));
    }
}
