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
        slideViewer.goToSlideNumber();
    }
}
