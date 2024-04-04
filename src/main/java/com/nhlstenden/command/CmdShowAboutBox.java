package com.nhlstenden.command;

import com.nhlstenden.facade.AboutBox;

import java.awt.*;

public class CmdShowAboutBox extends Command
{
    private Frame parent;
    public CmdShowAboutBox(SlideViewer slideViewer, Frame parent)
    {
        super(slideViewer);
        this.parent = parent;
    }

    @Override
    public void execute()
    {
        AboutBox.show(this.parent);
    }
}
