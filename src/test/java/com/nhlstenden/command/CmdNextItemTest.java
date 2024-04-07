package com.nhlstenden.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CmdNextItemTest
{

    @Mock
    private SlideViewer slideViewer;

    private CmdNextItem cmdNextItem;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
        cmdNextItem = new CmdNextItem(slideViewer);
    }

    @Test
    void testExecute_ShowNextItem()
    {
        // Arrange

        // Act
        cmdNextItem.execute();

        // Assert
        verify(slideViewer, times(1)).nextItem();
    }

    @Test
    void testExecute_UpdateView()
    {
        // Arrange

        // Act
        cmdNextItem.execute();

        // Assert
        verify(slideViewer, times(1)).updateView();
    }
}
