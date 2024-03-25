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
        this.getSlideViewer().clearItemsOrBack();
        this.getSlideViewer().updateView();
    }
}
