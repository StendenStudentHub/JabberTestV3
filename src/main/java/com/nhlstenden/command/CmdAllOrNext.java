package com.nhlstenden.command;

public class CmdAllOrNext extends Command
{
    public CmdAllOrNext(SlideViewer slideViewer)
    {
        super(slideViewer);
    }

    @Override
    public void execute()
    {
        //Get the slideViewer to show the next slide of all the slides
        //Update the view after this method
        this.getSlideViewer().showAllOrNext();
        this.getSlideViewer().updateView();
    }
}
