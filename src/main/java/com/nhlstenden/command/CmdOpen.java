package com.nhlstenden.command;

import com.nhlstenden.factory.AccessorFactory;
import com.nhlstenden.factory.Reader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CmdOpen extends Command
{
    protected static final String TEST_FILE = "test.xml";
    protected static final String  IO_EXCEPTION = "Io Exception";
    protected static final String LOADER_ERROR = "Load Error";
    private Frame parent;
    public CmdOpen(SlideViewer slideViewer, Frame parent) {
        super(slideViewer);
        this.parent = parent;
    }

    @Override
    public void execute() throws IOException {
        getSlideViewer().clear();
        Reader reader = AccessorFactory.GetFactory(TEST_FILE).CreateReader();
        try
        {
            getSlideViewer().setPresentation(reader.Read(TEST_FILE));
            getSlideViewer().setSlideNumber(0);
        }
        catch (IOException exception)
        {
            JOptionPane.showMessageDialog(parent, IO_EXCEPTION + exception, LOADER_ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
