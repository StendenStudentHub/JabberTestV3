package com.nhlstenden.command;

import com.nhlstenden.strategy.Slide;
import com.nhlstenden.strategy.Presentation;

import javax.swing.*;
import java.awt.*;

// Class responsible for managing the presentation viewing functionality
public class SlideViewer extends MenuBar {
    private Presentation presentation;
    private SlideViewerComponent slideViewerComponent;

    // Constructor to initialize the SlideViewer with a presentation
    public SlideViewer(com.nhlstenden.strategy.Presentation presentation)
    {
        this.presentation = presentation;
    }

    // Getter method for retrieving the current presentation
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
        //Set slideNumber to previous slide if there are more slides
        if(presentation.getSlideNumber() > 0)
        {
            setSlideNumber(presentation.getSlideNumber() -1);
        }
    }

    public void nextSlide()
    {
        //Set slideNumber to the next slide if there are more slides
        if(presentation.getSlideNumber() > (presentation.getSize()) - 1)
        {
            setSlideNumber(presentation.getSlideNumber() + 1);
        }
    }

    public void goToSlideNumber()
    {
        //Set slideNumber to the given number
        String page = "Page number?";
        int pageNumber = getIntegerField(page);
        setSlideNumber(pageNumber - 1);
    }

    public void clear()
    {
        //Clear the presentation
        if(this.presentation != null)
        {
            presentation.clear();
            setSlideNumber(0);
        }
    }

    public void toggleShowAll()
    {
        //Show all items to draw
        presentation.getCurrentSlide().toggleDrawAllItems();
    }

    public void nextItem()
    {
        //Go to the next item if there are more items
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
        //Go to the previous item if there are more than zero items.
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
        //Look if the slideNumber is greater than zero
        if(presentation.getSlideNumber() > 0)
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
        //Show all the slides or the next slide
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
        //Clear all the items or go to previous item
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
        //Look if the method is true
        if(this.presentation.getCurrentSlide().isDrawAllItems())
        {
            prevSlide();
        }
    }

    public void currentSlideHigherThanZero()
    {
        if(this.presentation.getSlideNumber() > 0)
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

    // helper function, clears a slide
    private void showAll()
    {
        int itemCount = this.presentation.getCurrentSlide().getSize();
        this.presentation.getCurrentSlide().setNumberOfItemsToDraw(itemCount);
    }

    // helper function to request int input
    private int getIntegerField(String argument)
    {
        try
        {
            String questionStr = JOptionPane.showInputDialog((Object) argument);
            return Integer.parseInt(questionStr);
        }
        catch (NumberFormatException exc)
        {
            System.out.println("only numeric input");
            return -1;
        }
    }

    public void updateView()
    {
        //Update the view if slideViewerComponent is not null
        if(this.slideViewerComponent != null)
        {
            this.slideViewerComponent.update(this.presentation.getTitle(), this.presentation.getCurrentSlide());
        }
    }
}
