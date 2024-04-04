package com.nhlstenden.command;

import com.nhlstenden.strategy.Slide;

public class SlideViewer
{
    private Presentation presentation;
    private SlideViewerComponent slideViewerComponent;
    public SlideViewer(Presentation presentation)
    {
        this.presentation = presentation;
    }

    public SlideViewer(com.nhlstenden.strategy.Presentation presentation)
    {
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
        Slide currentSlide = this.presentation.getCurrentSlide();

        if(currentSlide.getNumberOfItemsToDraw() < currentSlide.getSize() - 1)
        {
            showAll();
        }
        else
        {
            nextSlide();
        }
    }

    public void clearItemsOrBack()
    {
        if(this.presentation.getCurrentSlide().getNumberOfItemsToDraw() > 0)
        {
            clearSlide();
            isDrawAllItemsTrue();
        }
        else
        {
            currentSlideHigherThanZero();
        }
    }

    public void isDrawAllItemsTrue()
    {
        if(this.presentation.getCurrentSlide().isDrawAllItems())
        {
            prevSlide();
        }
    }

    public void currentSlideHigherThanZero()
    {
        if(this.presentation.getCurrentSlideNumber() > 0)
        {
            prevSlide();
            showAll();
        }
        else
        {
            prevSlide();
        }
    }

    public void exit(int status)
    {
        System.exit(status);
    }

    public void setSlideNumber(int slideNumber)
    {
        this.presentation.setCurrentSlideNumber(slideNumber);
        Slide currentSlide = this.presentation.getCurrentSlide();

        if(currentSlide.isDrawAllItems())
        {
            showAll();
        }
        else
        {
            clearSlide();
        }
    }

    private void clearSlide()
    {
        this.presentation.getCurrentSlide().setNumberOfItemsToDraw(0);
    }

    private void showAll()
    {
        int itemCount = this.presentation.getCurrentSlide().getSize();
        this.presentation.getCurrentSlide().setNumberOfItemsToDraw(itemCount);
    }

    private int getIntegerField(String argument)
    {
        //Voor nu nog even leeg laten, tot het nodig is.
        return 0;
    }

    public void updateView()
    {
        if(this.slideViewerComponent != null)
        {
            this.slideViewerComponent.update(this.presentation.getShowTitle(), this.presentation.getCurrentSlide());
        }
    }
}
