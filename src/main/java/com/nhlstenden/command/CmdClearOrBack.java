package com.nhlstenden.command;

public class CmdClearOrBack extends Command
{
    public CmdClearOrBack(SlideViewer slideViewer)
    {
        super(slideViewer);
    }

    @Override
    public void execute()
    {
        //Get the slideViewer to show the last slide or clear all the slides
        //Update the view after this method
        this.getSlideViewer().clearItemsOrBack();
        this.getSlideViewer().updateView();
    }
}
