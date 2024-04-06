package com.nhlstenden.strategy;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.text.Style;

public class TextItem extends SlideItem
{
    private String text;
    private int level;
    private static final String EMPTY_TEXT = "NO TEXT GIVEN";

    public TextItem(int level, String title)
    {
        super(level);
        this.text = title;
    }

    public String getText()
    {
        return this.text;
    }

    //Get the attributed string of the item
    public AttributedString getAttributedString(float scale)
    {
        AttributedString attributedString = new AttributedString(getText());
        attributedString.addAttribute(TextAttribute.FONT, itemStyle.getAttribute(scale), 0, text.length());

        return attributedString;
    }

    //Get the layout, used in the draw and bounding box method
    public List<TextLayout> getLayouts(Graphics graphics, MyStyle style,float scale)
    {
        List<TextLayout> layouts = new ArrayList<TextLayout>();
        AttributedString attributedString = getAttributedString(scale);
        Graphics2D graphics2D = (Graphics2D) graphics;
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        LineBreakMeasurer measurer = new LineBreakMeasurer(attributedString.getIterator(), fontRenderContext);
        float wrappingWidth = (Slide.WIDTH - style.getIndent()) * scale;
        while (measurer.getPosition() < getText().length())
        {
            TextLayout layout = measurer.nextLayout(wrappingWidth);
            layouts.add(layout);
        }

        return layouts;
    }

    //Draw the textItem
    @Override
    public void draw(int x, int y, float scale, Graphics graphics, MyStyle style, ImageObserver imageObserver)
    {
        if (text == null || text.length() == 0)
        {
            return;
        }

        List<TextLayout> layouts = getLayouts(graphics, style, scale);
        Point pen = new Point(x + (int)(style.getIndent() * scale),
                y + (int) (style.getLeading() * scale));
        Graphics2D g2d = (Graphics2D)graphics;
        g2d.setColor(style.getColor());
        for (TextLayout layout : layouts)
        {
            pen.y += (int) layout.getAscent();
            layout.draw(g2d, pen.x, pen.y);
            pen.y += (int) layout.getDescent();
        }
    }

    //Get the bounding box of the item
    @Override
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, MyStyle style, float scale)
    {
        List<TextLayout> layouts = getLayouts(graphics, style, scale);
        int xsize = 0, ysize = (int) (style.getLeading() * scale);

        for (TextLayout layout : layouts)
        {
            Rectangle2D bounds = layout.getBounds();

            if (bounds.getWidth() > xsize)
            {
                xsize = (int) bounds.getWidth();
            }
            if (bounds.getHeight() > 0)
            {
                ysize += (int) bounds.getHeight();
            }
            ysize += (int) (layout.getLeading() + layout.getDescent());
        }

        return new Rectangle((int) (style.getIndent() * scale), 0, xsize, ysize);
    }
}
