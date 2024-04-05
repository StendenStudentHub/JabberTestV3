package com.nhlstenden.strategy;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextItem extends com.nhlstenden.strategy.SlideItem
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

    public AttributedString getAttributedString(float scale)
    {
        AttributedString attributedString = new AttributedString(getText());
        attributedString.addAttribute(TextAttribute.FONT, itemStyle.getAttribute(scale), 0, text.length());

        return attributedString;
    }

    @Override
    public void draw(int x, int y, float scale, Graphics graphics, Style myStyle, ImageObserver imageObserver)
    {
        if (text == null || text.length() == 0)
        {
            return;
        }
        List<TextLayout> layouts = getLayouts(graphics, scale, myStyle);
        Point pen = new Point(x + (int)(myStyle.getIndent() * scale),
                y + (int) (myStyle.getLeading() * scale));
        Graphics2D g2d = (Graphics2D)graphics;
        g2d.setColor(myStyle.getColor());
        Iterator<TextLayout> it = layouts.iterator();
        while (it.hasNext())
        {
            TextLayout layout = it.next();
            pen.y += layout.getAscent();
            layout.draw(g2d, pen.x, pen.y);
            pen.y += layout.getDescent();
        }
    }
    }

    public List<TextLayout> getLayouts(Graphics graphics, float scale, Style mystyle)
    {
        List<TextLayout> layouts = new ArrayList<TextLayout>();
        AttributedString attributedString = getAttributedString(scale);
        Graphics2D graphics2D = (Graphics2D) graphics;
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        LineBreakMeasurer measurer = new LineBreakMeasurer(attributedString.getIterator(), fontRenderContext);
        float wrappingWidth = (Slide.WIDTH - mystyle.getIndent()) * scale;
        while (measurer.getPosition() < getText().length())
        {
            TextLayout layout = measurer.nextLayout(wrappingWidth);
            layouts.add(layout);
        }

        return layouts;
    }

    @Override
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale)
    {
        return null;
    }
}