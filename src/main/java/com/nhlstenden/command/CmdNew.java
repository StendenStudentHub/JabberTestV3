package com.nhlstenden.command;

public class CmdNew extends Command
{
    public CmdNew(SlideViewer slideViewer)
    {
        super(slideViewer);
    }

    @Override
    public void execute()
    {
        //Get the slideViewer to clear all the slides
        //Update the view after this method
        this.getSlideViewer().clear();
        this.getSlideViewer().updateView();
    }
}
