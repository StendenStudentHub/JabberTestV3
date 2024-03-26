package com.nhlstenden.command;

import com.nhlstenden.Strategy.Slide;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class SlideViewerComponent
{
    private static final long serialVersionUID = 277L;
    private static final Color BACKGROUND_COLOR = Color.white;
    private static final Color FONT_COLOR = Color.black;
    private static final String FONT_NAME = "Dialog";
    private static final int FONT_STYLE = Font.BOLD;
    private static final int FONT_HEIGHT = 10;
    private static final int X_POSITION = 1100;
    private static final int Y_POSITION = 20;
    private Font labelFont = null;
    private Frame frame;
    private Presentation presentation;
    private Slide slide;

    public SlideViewerComponent(JFrame frame, Presentation presentation)
    {
        this.frame = frame;
        this.presentation = presentation;
        this.slide = null;
        this.labelFont = new Font(FONT_NAME, FONT_STYLE, FONT_HEIGHT);
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
            this.frame.setTitle(title);
        }
    }

    public void paintComponent(Graphics graphics)
    {
        graphics.setColor(BACKGROUND_COLOR);
        graphics.fillRect(0, 0,  this.slide.getDimension("width"), this.slide.getDimension("height"));

        if(this.presentation.getCurrentSlideNumber() > 0 || this.slide != null)
        {
            paintPartOfComponent(graphics);
            Rectangle area = new Rectangle(0, Y_POSITION, this.slide.getDimension("width"), (this.slide.getDimension("height") - Y_POSITION));
            draw(graphics, area, (ImageObserver) this);
        }
    }

    private void paintPartOfComponent(Graphics graphics)
    {
        graphics.setFont(this.labelFont);
        graphics.setColor(FONT_COLOR);
        graphics.drawString("Slide " + (1 + this.presentation.getCurrentSlideNumber()) + " of " + this.presentation.getSize(), X_POSITION, Y_POSITION);
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
