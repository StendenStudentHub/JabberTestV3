package com.nhlstenden.command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SlideViewerFrame extends JFrame
{
    private static final String JABBERPOINT_TITLE = "Jabberpoint 1.6 - OU";
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 800;
    private String title;
    private final CmdFactory cmdFactory;

    public SlideViewerFrame(String title, SlideViewer slideViewer)
    {
        super(title);
        this.title = title;
        this.cmdFactory = new CmdFactory(this, slideViewer);
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent(this, slideViewer.getPresentation());
        slideViewer.setShowView(slideViewerComponent);
        setWindow(slideViewerComponent, slideViewer);
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    //Set up the window
    public void setWindow(SlideViewerComponent slideViewerComponent, SlideViewer slideViewer) {
        setTitle(JABBERPOINT_TITLE);
        addCloseWindowListener();
        addComponents(slideViewerComponent);
        addKeyListener();
        setMenuBar(slideViewer);
        setWindowSize();
        showWindow();
    }

    //All the different methods for the setWindow.
    private void addCloseWindowListener() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void addComponents(SlideViewerComponent slideViewerComponent) {
        getContentPane().add((JPanel) slideViewerComponent);
    }

    private void addKeyListener() {
        addKeyListener(new KeyController(this.cmdFactory));
    }

    private void setMenuBar(SlideViewer slideViewer) {
        setMenuBar(new MenuController(this, slideViewer, cmdFactory));
    }

    private void setWindowSize() {
        setSize(new Dimension(WIDTH, HEIGHT));
    }

    private void showWindow() {
        setVisible(true);
    }
}
