package com.nhlstenden.command;

import java.io.IOException;

public abstract class Command
{
    private SlideViewer slideViewer;

    protected Command(SlideViewer slideViewer)
    {
        this.slideViewer = slideViewer;
    }

    public SlideViewer getSlideViewer()
    {
        return this.slideViewer;
    }

    public void setSlideViewer(SlideViewer slideviewer)
    {
        this.slideViewer = slideviewer;
    }

    public abstract void execute() throws IOException;

}