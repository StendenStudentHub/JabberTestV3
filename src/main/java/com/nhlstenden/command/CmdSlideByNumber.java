package com.nhlstenden.command;

public class CmdSlideByNumber extends Command
{
    private SlideViewer slideViewer;
    public CmdSlideByNumber(SlideViewer slideViewer)
    {
        super(slideViewer);
        this.slideViewer = slideViewer;
    }

    @Override
    public void execute()
    {
        //Get the slideViewer to got to a slide number
        //Update the view after this method
        slideViewer.goToSlideNumber();
    }
}
