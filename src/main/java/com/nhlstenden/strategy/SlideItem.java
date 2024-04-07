package com.nhlstenden.strategy;

import javax.swing.text.Style;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.List;
import java.util.ArrayList;

public abstract class SlideItem
{
    private int level;
    protected List<SlideItem> subItems;
    protected Style itemStyle;
    protected StyleStrategy styleStrategy;

    public SlideItem(int level)
    {
        this.level = level;
        this.subItems = new ArrayList<>(); // Initialize as ArrayList to keep it compatible with existing code
    }

    public void addSlideItem(SlideItem subItem)
    {
        subItems.add(subItem);
    }

    public int getSubItems()
    {
        return this.subItems.size();
    }

    public List<SlideItem> getSubItemsList()
    {
        return this.subItems;
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

    //Abstract method for drawing
    public abstract void draw(int x, int y, float scale, Graphics graphics, MyStyle style, ImageObserver imageObserver);

    //Abstract method for getting the bounding box for the image
    public abstract Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, MyStyle style, float scale);
}
