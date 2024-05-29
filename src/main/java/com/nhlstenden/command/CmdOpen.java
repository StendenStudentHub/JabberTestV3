package com.nhlstenden.command;

import com.nhlstenden.factory.AccessorFactory;
import com.nhlstenden.factory.Reader;
import com.nhlstenden.strategy.Presentation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

// Command to open and load a presentation from a file
public class CmdOpen extends Command
{
    //Constants
    protected static final String TEST_FILE = "src/main/java/com/nhlstenden/resources/test.xml"; // File to be opened
    protected static final String IO_EXCEPTION = "Io Exception"; // Exception message for IO errors
    protected static final String LOADER_ERROR = "Load Error"; // Error message for loading errors

    //Variables
    // Parent frame for displaying error messages
    private final Frame parent;

    // Constructor to initialize the command with a SlideViewer and parent frame
    public CmdOpen(SlideViewer slideViewer, Frame parent)
    {
        super(slideViewer);
        this.parent = parent;
    }

    // Executes the command to open and load a presentation
    @Override
    public void execute()
    {
        // Clears the current presentation in the SlideViewer
        getSlideViewer().clear();

        // Creates a reader using the AccessorFactory for reading the file
        Reader reader = AccessorFactory.GetFactory(TEST_FILE).CreateReader();

        try
        {
            // Reads the presentation from the file
            Presentation presentation = reader.Read(TEST_FILE);

            // Sets the presentation in the SlideViewer
            getSlideViewer().setPresentation(presentation);

            // Sets the initial slide number to display
            getSlideViewer().setSlideNumber(0);
        }
        catch (IOException exception)
        {
            // Displays an error message dialog if an IOException occurs during reading
            JOptionPane.showMessageDialog(parent, IO_EXCEPTION + exception, LOADER_ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
