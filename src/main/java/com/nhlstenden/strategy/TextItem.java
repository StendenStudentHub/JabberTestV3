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
import java.util.List;


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

    public AttributedString getAttributedString(float scale)
    {
        AttributedString attributedString = new AttributedString(getText());
        attributedString.addAttribute(TextAttribute.FONT, itemStyle.getAttribute(scale), 0, text.length());

        return attributedString;
    }

    public List<TextLayout> getLayouts(Graphics graphics, MyStyle style,float scale)
    {
        List<TextLayout> layouts = new ArrayList<>();
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

    @Override
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, MyStyle style, float scale)
    {
        List<TextLayout> layouts = getLayouts(graphics, style, scale);
        int xSize = 0,
        ySize = (int) (style.getLeading() * scale);

        for (TextLayout layout : layouts)
        {
            Rectangle2D bounds = layout.getBounds();

            if (bounds.getWidth() > xSize)
            {
                xSize = (int) bounds.getWidth();
            }
            if (bounds.getHeight() > 0)
            {
                ySize += (int) bounds.getHeight();
            }
            ySize += (int) (layout.getLeading() + layout.getDescent());
        }

        return new Rectangle((int) (style.getIndent() * scale), 0, xSize, ySize);
    }
}
