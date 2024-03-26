package com.nhlstenden.Strategy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class BitmapItem extends SlideItem
{
    private String imageName;
    private BufferedImage bufferedImage;
    protected static final String FILE = "Bestand";
    protected static final String ERROR_NO_FOUND = "NOT FOUND";
    public BitmapItem(int level, String imageName) throws IOException
    {
        super(level);
        this.imageName = imageName;
        try
        {
            this.bufferedImage = ImageIO.read(new File(imageName));
        }
        catch(IOException exception)
        {
            System.err.println(FILE + imageName + ERROR_NO_FOUND);
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
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale)
    {
        //Moet nog worden geimplementeerd
        return null;
    }
}