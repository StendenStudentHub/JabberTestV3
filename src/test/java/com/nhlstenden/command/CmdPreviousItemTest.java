package com.nhlstenden.command;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CmdPreviousItemTest
{

    private SlideViewer slideViewer;
    private CmdPreviousItem cmdPreviousItem;

    @BeforeEach
    public void setUp()
    {
        slideViewer = mock(SlideViewer.class);
        cmdPreviousItem = new CmdPreviousItem(slideViewer);
    }

    @Test
    public void testExecute_ShowPreviousItem_UpdateView()
    {
        // Arrange

        // Act
        cmdPreviousItem.execute();

        // Assert
        verify(slideViewer, times(1)).previousItem();
        verify(slideViewer, times(1)).updateView();
    }

    @Test
    public void testExecute_WithMultipleCalls_ShowPreviousItemAndUpdateViewCorrectly()
    {
        // Arrange

        // Act
        cmdPreviousItem.execute();
        cmdPreviousItem.execute();
        cmdPreviousItem.execute();

        // Assert
        verify(slideViewer, times(3)).previousItem();
        verify(slideViewer, times(3)).updateView();
    }
}