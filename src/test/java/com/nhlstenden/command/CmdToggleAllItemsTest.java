package com.nhlstenden.command;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CmdToggleAllItemsTest
{

    private SlideViewer mockSlideViewer;
    private CmdToggleAllItems cmdToggleAllItems;

    @BeforeEach
    public void setUp()
    {
        mockSlideViewer = mock(SlideViewer.class);
        cmdToggleAllItems = new CmdToggleAllItems(mockSlideViewer);
    }

    @Test
    public void execute_ShouldToggleShowAllAndCallUpdateView()
    {
        // Arrange

        // Act
        cmdToggleAllItems.execute();

        // Assert
        verify(mockSlideViewer, times(1)).toggleShowAll();
        verify(mockSlideViewer, times(1)).updateView();
    }
}
