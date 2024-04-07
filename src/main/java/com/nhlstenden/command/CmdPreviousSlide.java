package com.nhlstenden.command;

public class CmdPreviousSlide extends Command
{
    public CmdPreviousSlide(SlideViewer slideViewer)
    {
        super(slideViewer);
    }

    @Override
    public void execute()
    {
        //Get the slideViewer to show previous slide
        //Update the view after this method
        this.getSlideViewer().prevSlide();
        this.getSlideViewer().updateView();
    }
}
