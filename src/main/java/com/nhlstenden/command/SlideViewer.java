package com.nhlstenden.command;

import com.nhlstenden.Strategy.Slide;

public class SlideViewer
{
    private Presentation presentation;
    private SlideViewerComponent slideViewerComponent;
    public SlideViewer(Presentation presentation)
    {
        this.presentation = presentation;
    }

    public Presentation getPresentation()
    {
        return this.presentation;
    }

    public void setPresentation(Presentation presentation)
    {
        this.presentation = presentation;
        slideViewerComponent.setPresentation(this.presentation);
    }

    public void setShowView(SlideViewerComponent slideViewerComponent)
    {
        this.slideViewerComponent = slideViewerComponent;
        updateView();
    }

    public void prevSlide()
    {
        if(presentation.getCurrentSlideNumber() > 0)
        {
            setSlideNumber(presentation.getCurrentSlideNumber() -1);
        }
    }

    public void nextSlide()
    {
        if(presentation.getCurrentSlideNumber() > (presentation.getSize()) - 1)
        {
            setSlideNumber(presentation.getCurrentSlideNumber() + 1);
        }
    }

    public void goToSlideNumber(int number)
    {
        setSlideNumber(number);
    }

    public void clear()
    {
        if(this.presentation != null)
        {
            presentation.clear();
            setSlideNumber(0);
        }
    }

    public void toggleShowAll()
    {
        presentation.getCurrentSlide().toggleDrawAllItems();
    }

    public void nextItem()
    {
        Slide currentSlide = presentation.getCurrentSlide();
        if(currentSlide.getNumberOfItemsToDraw() < currentSlide.getSize())
        {
            currentSlide.incrementItemsToDraw();
        }
        else
        {
            nextSlide();
        }
    }

    public void previousItem()
    {
        Slide currentSlide = presentation.getCurrentSlide();
        if(currentSlide.getNumberOfItemsToDraw() > 0 && !currentSlide.isDrawAllItems())
        {
            currentSlide.decrementItemsToDraw();
        }
        else
        {
           isSlideNumberGreaterThanZero();
        }
    }

    public void isSlideNumberGreaterThanZero()
    {
        if(presentation.getCurrentSlideNumber() > 0)
        {
            prevSlide();
            showAll();
        }
        else
        {
            prevSlide();
        }
    }

    public void showAllOrNext()
    {

    }

    public void clearItemsOrBack()
    {

    }

    public void exit(int status)
    {
        System.exit(status);
    }

    public void setSlideNumber(int slideNumber)
    {

    }

    public void clearSlide(int number)
    {

    }

    public void showAll()
    {

    }

    public int getIntegerField(String argument)
    {
        //This needs to change
        return 0;
    }

    public void updateView()
    {

    }
}
