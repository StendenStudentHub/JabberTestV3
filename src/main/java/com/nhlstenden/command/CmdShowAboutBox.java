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
        //Get the slideViewer to show the aboutBox
        //Update the view after this method
        AboutBox.show(this.parent);
    }
}
