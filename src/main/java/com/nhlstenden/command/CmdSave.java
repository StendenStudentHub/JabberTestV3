package com.nhlstenden.command;

import com.nhlstenden.factory.AccessorFactory;
import com.nhlstenden.factory.Writer;
import com.nhlstenden.strategy.Presentation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

// Command to save the presentation to a file
public class CmdSave extends Command
{
    protected static final String SAVE_FILE = "dump.xml"; // File to save the presentation
    protected static final String IO_EXCEPTION = "IO Exception"; // Exception message for IO errors
    protected static final String SAVE_ERROR = "Save Error"; // Error message for saving errors

    private Frame parent; // Parent frame for displaying error messages
    private Presentation presentation; // Presentation to be saved

    // Constructor to initialize the command with a SlideViewer, parent frame, and presentation
    public CmdSave(SlideViewer slideViewer, Frame parent, Presentation presentation)
    {
        super(slideViewer);
        this.parent = parent;
        this.presentation = presentation;
    }

    // Executes the command to save the presentation
    @Override
    public void execute()
    {
        // Creates a writer using the AccessorFactory for writing to a file
        Writer writer = AccessorFactory.GetFactory(SAVE_FILE).CreateWriter();

        try
        {
            // Writes the presentation to the file
            writer.Write(this.presentation, SAVE_FILE);
        }
        catch (IOException exception)
        {
            // Displays an error message dialog if an IOException occurs during writing
            JOptionPane.showMessageDialog(parent, IO_EXCEPTION + exception, SAVE_ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
