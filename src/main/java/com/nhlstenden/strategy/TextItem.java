package com.nhlstenden.strategy;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.ImageObserver;
import java.text.AttributedString;

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

    public String getTitle()
    {
        return this.text;
    }

    public AttributedString getAttributedString(float scale)
    {
        AttributedString attributedString = new AttributedString(getTitle());
        attributedString.addAttribute(TextAttribute.FONT, itemStyle.getFont(scale), 0, text.length());
        return attributedString;
    }

    @Override
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale) {
        return null;
        //Moet nog worden geimplementeerd
    }
}
