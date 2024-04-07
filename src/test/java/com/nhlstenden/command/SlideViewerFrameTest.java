package com.nhlstenden.command;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class SlideViewerFrameTest
{

    private SlideViewerFrame slideViewerFrame;
    private SlideViewer mockSlideViewer;

    @BeforeEach
    public void setUp()
    {
        mockSlideViewer = mock(SlideViewer.class);
        slideViewerFrame = new SlideViewerFrame("Test Frame", mockSlideViewer);
    }

    @Test
    public void setTitle_ShouldSetTitle()
    {
        // Arrange
        String expectedTitle = "New Title";

        // Act
        slideViewerFrame.setTitle(expectedTitle);

        // Assert
        assertEquals(expectedTitle, slideViewerFrame.getTitle());
    }

    @Test
    public void setWindow_ShouldSetUpWindow()
    {
        // Arrange
        SlideViewerComponent mockSlideViewerComponent = mock(SlideViewerComponent.class);

        // Act
        slideViewerFrame.setWindow(mockSlideViewerComponent, mockSlideViewer);

        // Assert
        assertTrue(slideViewerFrame.isVisible());
        assertEquals("Jabberpoint 1.6 - OU", slideViewerFrame.getTitle());

        // Verify window listener
        WindowListener[] windowListeners = slideViewerFrame.getWindowListeners();
        assertEquals(1, windowListeners.length);
        assertEquals(WindowAdapter.class, windowListeners[0].getClass());

        // Verify menu bar
        assertNotNull(slideViewerFrame.getMenuBar());

        // Verify size
        assertEquals(new Dimension(1200, 800), slideViewerFrame.getSize());
    }

    @Test
    public void addCloseWindowListener_ShouldExitOnWindowClosing()
    {
        // Arrange
        WindowEvent mockWindowEvent = mock(WindowEvent.class);
        WindowAdapter windowAdapter = new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        };

        // Act
        windowAdapter.windowClosing(mockWindowEvent);

        // Assert
    }

    @Test
    public void addKeyListener_ShouldAddKeyListener() {
        // Arrange
        KeyController mockKeyController = mock(KeyController.class);

        // Act
        slideViewerFrame.addKeyListener(mockKeyController);

        // Assert
        assertTrue(slideViewerFrame.getKeyListeners().length > 0);
    }

    @Test
    public void setMenuBar_ShouldSetMenuBar() {
        // Arrange
        MenuController mockMenuController = mock(MenuController.class);

        // Act
        slideViewerFrame.setMenuBar(mockSlideViewer);

        // Assert
        assertNotNull(slideViewerFrame.getMenuBar());
    }
}
