package com.nhlstenden.command;

import com.nhlstenden.strategy.Slide;
import com.nhlstenden.strategy.SlideItem;
import com.nhlstenden.strategy.Style;

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

    public void draw(Graphics graphics, Rectangle area, ImageObserver view, Style style)
    {
        float scale = getScale(area);
        drawTitle(graphics, area, view, scale, );
        drawSlideItems(graphics, style, view, scale, area);
    }

    private int calculateYPosition(int currentY, SlideItem item, Graphics graphics, ImageObserver view, float scale)
    {
        return currentY + item.getBoundingBox(graphics, view, scale).height;
    }

    private void drawTitle(Graphics graphics, Rectangle area, Style style, ImageObserver view, float scale)
    {
        SlideItem title = slide.getTitle();
        title.draw(area.x, area.y, scale, graphics, (javax.swing.text.Style) style, view);
    }

    private void drawSlideItems(Graphics graphics, Style style, ImageObserver view, float scale, Rectangle area)
    {
        int yPosition = area.y;
        for (int number = 0; number < slide.getNumberOfItemsToDraw(); number++)
        {
            SlideItem item = slide.getSlideItems().elementAt(number);
            item.draw(0, yPosition, scale, graphics, slide.getTitle().getStyle(), view);
            yPosition = calculateYPosition(yPosition, item, graphics, view, scale);
        }
    }

    private float getScale(Rectangle area)
    {
        return Math.min(((float) area.width) / ((float) Slide.WIDTH), ((float) area.height) / ((float) Slide.HEIGHT));
    }
}
