package com.nhlstenden.Strategy;

import java.util.Vector;

public class Slide
{
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;
    protected TextItem title;
    protected Vector<SlideItem> items;
    private int numberOfItemsToDraw;
    private boolean drawAllItems;

    public Slide()
    {
        this.numberOfItemsToDraw = 0;
        this.drawAllItems = false;
        this.items = new Vector<SlideItem>();
    }

    public boolean isDrawAllItems()
    {
        return this.drawAllItems;
    }

    public int getNumberOfItemsToDraw()
    {
        return this.numberOfItemsToDraw;
    }

    public void incrementItemsToDraw()
    {
        this.numberOfItemsToDraw++;
    }

    public void decrementItemsToDraw()
    {
        this.numberOfItemsToDraw--;
    }

    public void setNumberOfItemsToDraw(int numberOfItems)
    {
        this.numberOfItemsToDraw = numberOfItems;
    }

    public void toggleDrawAllItems()
    {
        this.drawAllItems = !this.drawAllItems;
    }

    public void append(SlideItem slideItem)
    {
        this.items.add(slideItem);
    }

    public TextItem getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = new TextItem(0, title);
    }

    public void append(int level, String message)
    {
           //moet nog worden geimplementeerd
    }

    public SlideItem getSlideItem(int number)
    {
        return getSlideItem(number);
    }

    public Vector<SlideItem> getSlideItems()
    {
        return this.items;
    }

    public int getSize()
    {
        return items.size();
    }

}
