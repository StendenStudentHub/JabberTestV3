package com.nhlstenden.command;

import java.io.IOException;

// Abstract class representing a command
public abstract class Command
{
    private SlideViewer slideViewer; // Reference to the SlideViewer

    // Constructor to initialize the command with a SlideViewer
    protected Command(SlideViewer slideViewer)
    {
        this.slideViewer = slideViewer;
    }

    // Getter method for retrieving the SlideViewer
    public SlideViewer getSlideViewer()
    {
        return this.slideViewer;
    }

    // Setter method for setting the SlideViewer
    public void setSlideViewer(SlideViewer slideViewer)
    {
        this.slideViewer = slideViewer;
    }

    // Abstract method to execute the command
    public abstract void execute() throws IOException;
}