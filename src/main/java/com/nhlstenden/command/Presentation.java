package com.nhlstenden.command;

import com.nhlstenden.Strategy.Slide;

import java.util.ArrayList;

public class Presentation
{
    private String showTitle;
    private int currentSlideNumber;
    private ArrayList<Slide> slideList;

    public Presentation()
    {
        this.showTitle = "";
        this.currentSlideNumber = 0;
        this.slideList = new ArrayList<Slide>();
    }

    public ArrayList<Slide> getSlideList()
    {
        return this.slideList;
    }

    public int getSize()
    {
        return this.slideList.size();
    }

    public String getShowTitle()
    {
        return this.showTitle;
    }

    public void setShowTitle(String title)
    {
        this.showTitle = title;
    }

    public int getCurrentSlideNumber()
    {
        return this.currentSlideNumber;
    }

    public void setCurrentSlideNumber(int slideNumber)
    {
        this.currentSlideNumber = slideNumber;
    }

    public void clear()
    {
        slideList = new ArrayList<Slide>();
        setCurrentSlideNumber(0);
    }

    public void appendSlide(Slide slide)
    {
        this.slideList.add(slide);
    }

    public Slide getSlideByNumber(int numberSlide)
    {
        if(numberSlide < 0 || numberSlide >= this.getSize())
        {
            return null;
        }
        else
        {
            return this.slideList.get(numberSlide);
        }
    }

    public Slide getCurrentSlide()
    {
        return getSlideByNumber(this.currentSlideNumber);
    }
}
