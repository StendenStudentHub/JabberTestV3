package com.nhlstenden.command;

import com.nhlstenden.strategy.Slide;
import com.nhlstenden.strategy.SlideItem;
import com.nhlstenden.strategy.MyStyle;
import com.nhlstenden.strategy.Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class SlideViewerComponent extends JPanel
{
    private static final Color BACKGROUND_COLOR = Color.white;
    private static final Color FONT_COLOR = Color.black;
    private static final String FONT_NAME = "Dialog";
    private static final int FONT_STYLE = Font.BOLD;
    private static final int FONT_HEIGHT = 10;
    private static final int X_POSITION = 1100;
    private static final int Y_POSITION = 20;
    private Font labelFont = null;
    private final Frame frame;
    private Presentation presentation;
    private Slide slide;

    public SlideViewerComponent(JFrame frame, Presentation presentation)
    {
        setBackground(BACKGROUND_COLOR);
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

    //Update the view with a repaint method
    public void update(String title, Slide data)
    {
        if (data == null)
        {
            frame.repaint();
        }
        else
        {
            this.slide = data;
            frame.repaint();
            this.frame.setTitle(title);
        }
    }

    //Paint the component
    public void paintComponent(Graphics graphics, MyStyle style)
    {
        graphics.setColor(BACKGROUND_COLOR);
        graphics.fillRect(0, 0,  this.slide.getDimension("width"), this.slide.getDimension("height"));

        if(this.presentation.getSlideNumber() > 0 || this.slide != null)
        {
            paintPartOfComponent(graphics);
            Rectangle area = new Rectangle(0, Y_POSITION, this.slide.getDimension("width"), (this.slide.getDimension("height") - Y_POSITION));
            draw(graphics, area, (ImageObserver) this, style);
        }
    }

    //Set the font and the color
    private void paintPartOfComponent(Graphics graphics)
    {
        graphics.setFont(this.labelFont);
        graphics.setColor(FONT_COLOR);
        graphics.drawString("Slide " + (1 + this.presentation.getSlideNumber()) + " of " + this.presentation.getSize(), X_POSITION, Y_POSITION);
    }

    //Draw the slide
    public void draw(Graphics graphics, Rectangle area, ImageObserver view, MyStyle myStyle)
    {
        float scale = getScale(area);
        drawTitle(graphics, area, myStyle, view, scale);
        drawSlideItems(graphics, myStyle, view, scale, area);
    }

    //Calculate the Y position to work with
    private int calculateYPosition(int currentY, SlideItem item, Graphics graphics, ImageObserver view, MyStyle style, float scale)
    {
        return currentY + item.getBoundingBox(graphics, view, style, scale).height;
    }

    //Draw the title
    private void drawTitle(Graphics graphics, Rectangle area, MyStyle myStyle, ImageObserver view, float scale)
    {
        SlideItem title = slide.getTitle();
        title.draw(area.x, area.y, scale, graphics, myStyle, view);
    }

    //Draw the slide items
    private void drawSlideItems(Graphics graphics, MyStyle myStyle, ImageObserver view, float scale, Rectangle area)
    {
        int yPosition = area.y;
        for (int number = 0; number < slide.getNumberOfItemsToDraw(); number++)
        {
            SlideItem item = slide.getSlideItems().elementAt(number);
            item.draw(0, yPosition, scale, graphics, myStyle, view);
            yPosition = calculateYPosition(yPosition, item, graphics, view, myStyle, scale);
        }
    }

    //Get the scale from the slide to draw
    private float getScale(Rectangle area)
    {
        return Math.min(((float) area.width) / ((float) Slide.WIDTH), ((float) area.height) / ((float) Slide.HEIGHT));
    }
}
