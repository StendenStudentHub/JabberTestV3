package com.nhlstenden.command;

import com.nhlstenden.factory.AccessorFactory;
import com.nhlstenden.factory.Reader;
import com.nhlstenden.factory.XMLReader;
import com.nhlstenden.strategy.Presentation;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.IOException;
import java.io.File;

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
        //Create the fileChooser and open the file dialog
        JFileChooser fileChooser = createJFileChooser();
        fileChooser.showOpenDialog(this.parent);

        try
        {
            //Set the reader to read the chosen file
            Reader reader = AccessorFactory.GetFactory(fileChooser.getSelectedFile().getPath()).CreateReader();
            getSlideViewer().setSlideNumber(0);
            // Reads the presentation from the file
            Presentation presentation = reader.Read(TEST_FILE);
        }
        catch (IOException exception)
        {
            // Displays an error message dialog if an IOException occurs during reading
            JOptionPane.showMessageDialog(parent, IO_EXCEPTION + exception, LOADER_ERROR, JOptionPane.ERROR_MESSAGE);
        }
        parent.repaint();
    }

    //Private method for creating the fileChooser
    //With the given accepted file extension
    private static JFileChooser createJFileChooser()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilter()
        {
            @Override
            public boolean accept(File file)
            {
                if (file.isDirectory() )
                {
                    return true;
                }
                else
                {
                    String fileName = file.getName().toLowerCase();
                    return fileName.endsWith(".xml");
                }
            }

            @Override
            public String getDescription()
            {
                return "XML files (*.xml)";
            }
        }
        );
        return fileChooser;
    }
}
