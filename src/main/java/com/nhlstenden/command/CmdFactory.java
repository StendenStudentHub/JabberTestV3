package com.nhlstenden.command;

import java.awt.*;

public class CmdFactory
{
    private Frame parent;
    private SlideViewer slideviewer;
    public CmdFactory(Frame parent, SlideViewer slideviewer)
    {
        this.parent = parent;
        this.slideviewer = slideviewer;
    }

    public Command createNextSlideCMD()
    {
        return new CmdNextSlide(slideviewer);
    }

    public Command createPreviousSlideCMD()
    {
        return new CmdPreviousSlide(slideviewer);
    }

    public Command createNextItemCMD()
    {
        return new CmdNextItem(slideviewer);
    }

    public Command createPreviousItemCMD()
    {
        return new CmdPreviousItem(slideviewer);

    }

    public Command createShowAllOrNextCMD()
    {
        return new CmdAllOrNext(slideviewer);
    }

    public Command createClearItemsOrBackCMD()
    {
        return new CmdClearOrBack(slideviewer);
    }

    public Command createExitCMD()
    {
        return new CmdExit(slideviewer);
    }

    public Command createSlideByNumber()
    {
        return new CmdSlideByNumber(slideviewer);
    }

    public Command createOpenCMD()
    {
        return new CmdOpen(slideviewer, parent);
    }

    public Command createSaveCMD()
    {
        return new CmdSave(slideviewer, parent, slideviewer.getPresentation());
    }

    public Command createNewCMD()
    {
        return new CmdNew(slideviewer);
    }

    public Command createShowAboutBoxCMD()
    {
        return new CmdShowAboutBox(slideviewer, parent);
    }

    public Command createToggleItemsCMD()
    {
        return new CmdToggleAllItems(slideviewer);
    }

    public Command createNullCMD()
    {
        return new CmdNull(slideviewer);
    }
}
