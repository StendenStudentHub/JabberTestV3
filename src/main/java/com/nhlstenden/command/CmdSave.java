package com.nhlstenden.command;

import com.nhlstenden.factory.AccessorFactory;
import com.nhlstenden.factory.Writer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CmdSave extends Command
{
    protected static final String SAVE_FILE = "dump.xml";
    protected static final String IO_EXCEPTION = "IO Exception";
    protected static final String SAVE_ERROR = "Save Error";
    private Frame parent;
    private Presentation presentation;
    public CmdSave(SlideViewer slideViewer, Frame parent, Presentation presentation)
    {
        super(slideViewer);
        this.parent = parent;
        this.presentation = presentation;
    }

    @Override
    public void execute()
    {
        Writer writer = AccessorFactory.GetFactory(SAVE_FILE).CreateWriter();

        try
        {
            writer.Write(this.presentation, SAVE_FILE);
        }
        catch (IOException exception)
        {
            JOptionPane.showMessageDialog(parent, IO_EXCEPTION + exception, SAVE_ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
