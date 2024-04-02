package com.nhlstenden.command;

public class CmdNull extends Command
{
    public CmdNull(SlideViewer slideViewer)
    {
        super(slideViewer);
    }

    @Override
    public void execute()
    {
        //No actions needed
    }
}
