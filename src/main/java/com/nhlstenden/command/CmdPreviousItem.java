package com.nhlstenden.command;

public class CmdPreviousItem extends Command
{
    public CmdPreviousItem(SlideViewer slideViewer)
    {
        super(slideViewer);
    }

    @Override
    public void execute()
    {
        //Get the slideViewer to show the previous item
        //Update the view after this method
        this.getSlideViewer().previousItem();
        this.getSlideViewer().updateView();
    }
}
