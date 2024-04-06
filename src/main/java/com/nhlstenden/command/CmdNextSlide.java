package com.nhlstenden.command;

public class CmdNextSlide extends Command
{
    public CmdNextSlide(SlideViewer slideViewer)
    {
        super(slideViewer);
    }

    @Override
    public void execute()
    {
        //Get the slideViewer to show the next slide
        //Update the view after this method
        this.getSlideViewer().nextSlide();
        this.getSlideViewer().updateView();
    }
}
