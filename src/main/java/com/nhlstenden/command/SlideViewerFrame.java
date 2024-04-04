package com.nhlstenden.command;

import javax.swing.*;
import java.awt.*;
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
    private CmdFactory cmdFactory;
    private SlideViewerComponent slideViewerComponent;

    public SlideViewerFrame(String title, SlideViewer slideViewer)
    {
        super(title);
        this.title = title;
        this.slideViewer = slideViewer;
        this.cmdFactory = new CmdFactory(this, this.slideViewer);
        this.slideViewerComponent = new SlideViewerComponent(this, this.slideViewer.getPresentation());
        this.slideViewer.setShowView(this.slideViewerComponent);
        setWindow(this.slideViewerComponent, this.slideViewer);
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setWindow(SlideViewerComponent slideViewerComponent, SlideViewer slideViewer) {
        setTitle(JABBERPOINT_TITLE);
        addCloseWindowListener();
        addComponents(slideViewerComponent);
        addKeyListener();
        setMenuBar(slideViewer);
        setWindowSize();
        showWindow();
    }

    private void addCloseWindowListener() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void addComponents(SlideViewerComponent slideViewerComponent) {
        getContentPane().add(this);
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
