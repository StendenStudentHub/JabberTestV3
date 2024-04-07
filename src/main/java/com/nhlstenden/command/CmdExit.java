package com.nhlstenden.command;

public class CmdExit extends Command
{
    public CmdExit(SlideViewer slideViewer)
    {
        super(slideViewer);
    }

    @Override
    public void execute()
    {
        //Exit the program with a status code
        this.getSlideViewer().exit(0);
    }
}
