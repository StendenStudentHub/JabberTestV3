package com.nhlstenden.strategy;

import com.nhlstenden.factory.SlideItemFactory;

import java.util.Objects;
import java.util.Vector;

public class Slide
{
    //Constants
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;

    //Variables
    protected TextItem title;
    protected Vector<SlideItem> items;
    private int numberOfItemsToDraw;
    private boolean drawAllItems;

    //Constructor
    public Slide()
    {
        this.numberOfItemsToDraw = 0;
        this.drawAllItems = true;
        this.items = new Vector<>();
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

    public int getDimension(String dimension)
    {
        int finalNumber = 0;

        if(dimension.equalsIgnoreCase("width"))
        {
            finalNumber = WIDTH;
        }
        else if(dimension.equalsIgnoreCase("height"))
        {
            finalNumber = HEIGHT;
        }

        return finalNumber;
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

    //Add the slides, the level is the type of color > see styleDefault
    //Add the message.
    public void append(int level, String message)
    {
        append(Objects.requireNonNull(SlideItemFactory.GetSlideItemFactory("text")).CreateSlideItem(level, message));
    }

    public SlideItem getSlideItem(int number)
    {
        return (SlideItem) items.elementAt(number);
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
