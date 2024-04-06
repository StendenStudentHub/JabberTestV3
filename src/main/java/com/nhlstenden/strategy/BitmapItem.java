package com.nhlstenden.strategy;

import javax.imageio.ImageIO;
import javax.swing.text.Style;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.logging.Logger;

public class BitmapItem extends SlideItem
{
    private static final Logger logger = Logger.getLogger(BitmapItem.class.getName());

    private String imageName;
    private BufferedImage bufferedImage;
    protected static final String FILE = "Bestand";
    protected static final String ERROR_NOT_FOUND = "NOT FOUND";

    public BitmapItem(int level, String imageName) throws IOException
    {
        super(level);
        this.imageName = imageName;
        try
        {
            this.bufferedImage = ImageIO.read(new File(imageName));
        }
        catch (IOException exception)
        {
            logger.severe(FILE + imageName + ERROR_NOT_FOUND);
        }
    }

    public String getImageName()
    {
        return this.imageName;
    }

    public String toString()
    {
        return "{" + this.imageName + ", " + this.getLevel() + "}";
    }

    public BufferedImage getBufferedImage()
    {
        return this.bufferedImage;
    }

    @Override
    public void draw(int x, int y, float scale, Graphics graphics, MyStyle style, ImageObserver imageObserver)
    {
        int width = x + (int) (style.getIndent() * scale);
        int height = y + (int) (style.getLeading() * scale);
        graphics.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(imageObserver) * scale),
                (int) (bufferedImage.getHeight(imageObserver) * scale), imageObserver);
    }

    @Override
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale)
    {
        // Needs to be implemented
        return null;
    }
}
