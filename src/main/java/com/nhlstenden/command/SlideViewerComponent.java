package com.nhlstenden.command;

import com.nhlstenden.Strategy.Slide;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class SlideViewerComponent
{
    private static final long serialVersionUID = 277L;
    private static final String FONT_NAME = "Dialog";
    private static final int FONT_STYLE = Font.BOLD;
    private static final int FONT_HEIGHT = 10;
    private static final int X_POSITION = 1100;
    private static final int Y_POSITION = 20;
    private Frame frame;
    private Presentation presentation;
    private Slide slide;

    public SlideViewerComponent(JFrame frame, Presentation presentation)
    {
        this.frame = frame;
        this.presentation = presentation;
        this.slide = null;
    }

    public void setPresentation(Presentation presentation)
    {
        this.presentation = presentation;
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(Slide.WIDTH, Slide.HEIGHT);
    }

    public void update(String title, Slide data)
    {
        if (data == null)
        {
            //repaint();
            return;
        }
        else
        {
            this.slide = data;
            //repaint();
            frame.setTitle(title);
        }
    }

    public void paintComponent(Graphics graphics)
    {
        //Moet nog worden geimplementeerd
    }

    public void draw(Graphics graphics, Rectangle area, ImageObserver view)
    {
        //Moet nog worden geimplementeerd
    }

    private float getScale(Rectangle area)
    {
        return Math.min(((float) area.width) / ((float) Slide.WIDTH), ((float) area.height) / ((float) Slide.HEIGHT));
    }
}
