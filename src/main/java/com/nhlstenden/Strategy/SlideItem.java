package com.nhlstenden.Strategy;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public abstract class SlideItem
{
    private int level;
    protected ArrayList<SlideItem> subItems;
    protected Style itemStyle;
    protected StyleStrategy styleStrategy;
    public SlideItem(int level)
    {
        this.level = level;
        this.subItems = new ArrayList<SlideItem>();
    }

    public void addSlideItem(SlideItem subItem)
    {
        subItems.add(subItem);
    }

    public int getSubItems()
    {
        return this.subItems.size();
    }

    public void setItemStyle(Style style)
    {
        this.itemStyle = style;
    }

    public Style getStyle()
    {
        styleStrategy.setStyle(this);
        return itemStyle;
    }

    public int getLevel()
    {
        return this.level;
    }

    public abstract Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale);

    public void draw(int x, int y, float scale, Graphics graphics, ImageObserver observer)
    {
        //Moet nog worden geimplementeerd
    }
}
