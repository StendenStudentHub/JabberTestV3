package com.nhlstenden.command;

public class CmdNextItem extends Command
{
    public CmdNextItem(SlideViewer slideViewer)
    {
        super(slideViewer);
    }

    @Override
    public void execute()
    {
        //Get the slideViewer to show the next item
        //Update the view after this method
        this.getSlideViewer().nextItem();
        this.getSlideViewer().updateView();
    }
}
