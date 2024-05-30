package com.nhlstenden.command;

import com.nhlstenden.strategy.Slide;
import com.nhlstenden.strategy.Presentation;

import javax.swing.*;
import java.awt.*;

// Class responsible for managing the presentation viewing functionality
public class SlideViewer extends MenuBar
{
    //Variables
    private Presentation presentation;
    private SlideViewerComponent slideViewerComponent;

    // Constructor to initialize the SlideViewer with a presentation
    public SlideViewer(Presentation presentation)
    {
        this.presentation = presentation;
    }

    //Getters and setters
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

    //Set slideNumber to previous slide if there are more slides
    public void previousSlide()
    {
        if(presentation.getSlideNumber() > 0)
        {
            setSlideNumber(presentation.getSlideNumber() -1);
        }
    }

    //Set slideNumber to the next slide if there are more slides
    public void nextSlide()
    {
        if(presentation.getSlideNumber() > (presentation.getSize()) - 1)
        {
            setSlideNumber(presentation.getSlideNumber() + 1);
        }
    }

    //Set slideNumber to the given number
    public void goToSlideNumber()
    {
        String page = "Page number?";
        int pageNumber = getIntegerField(page);
        setSlideNumber(pageNumber - 1);
    }

    //Clear the presentation
    public void clear()
    {
        if(this.presentation != null)
        {
            presentation.clear();
            setSlideNumber(0);
        }
    }

    //Show all items to draw
    public void toggleShowAll()
    {
        presentation.getCurrentSlide().toggleDrawAllItems();
    }

    //Go to the next item if there are more items
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

    //Go to the previous item if there are more than zero items.
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

    //Look if the slideNumber is greater than zero
    public void isSlideNumberGreaterThanZero()
    {
        if(presentation.getSlideNumber() > 0)
        {
            previousSlide();
            showAll();
        }
        else
        {
            previousSlide();
        }
    }

    //Show all the slides or the next slide
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

    //Clear all the items or go to previous item
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

    //Look if the drawAllItems is true
    public void isDrawAllItemsTrue()
    {
        //If true go to previous slide methode
        if(this.presentation.getCurrentSlide().isDrawAllItems())
        {
            previousSlide();
        }
    }

    //Look if the current slide is higher than zero
    public void currentSlideHigherThanZero()
    {
        if(this.presentation.getSlideNumber() > 0)
        {
            previousSlide();
            showAll();
        }
        else
        {
            previousSlide();
        }
    }

    //Give exit status to the given parameter
    public void exit(int status)
    {
        System.exit(status);
    }

    //Set the slide number to the given parameter
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

    //Clear the current slide
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

    //Update the view if slideViewerComponent is not null
    public void updateView()
    {
        if(this.slideViewerComponent != null)
        {
            this.slideViewerComponent.update(this.presentation.getTitle(), this.presentation.getCurrentSlide());
        }
    }
}
