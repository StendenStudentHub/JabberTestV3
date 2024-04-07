package com.nhlstenden.command;

public class CmdToggleAllItems extends Command
{
    public CmdToggleAllItems(SlideViewer slideViewer)
    {
        super(slideViewer);
    }

    @Override
    public void execute()
    {
        //Get the slideViewer to show all the slides
        //Update the view after this method
        this.getSlideViewer().toggleShowAll();
        this.getSlideViewer().updateView();
    }
}
