package com.nhlstenden.command;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SlideViewerFrame extends JFrame
{
    private static final long SERIAL_VERSION_UID = 3227L;
    private static final String JABBERPOINT_TITLE = "Jabberpoint 1.6 - OU";
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 800;
    private String title;
    private SlideViewer slideViewer;

    public SlideViewerFrame(String title, SlideViewer slideViewer)
    {
        this.title = title;
        this.slideViewer = slideViewer;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setWindow(SlideViewerComponent slideViewerComponent, SlideViewer slideViewer)
    {
        setTitle(JABBERPOINT_TITLE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //Nog verder uitwerken
    }
}
