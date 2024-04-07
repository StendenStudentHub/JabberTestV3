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
        SlideViewer slideViewer = getSlideViewer();

        if (slideViewer != null)
        {
            slideViewer.showAllOrNext();
            slideViewer.updateView();
        }
    }
}
