package com.nhlstenden.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CmdNewTest
{

    @Mock
    private SlideViewer slideViewer;

    private CmdNew cmdNew;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
        cmdNew = new CmdNew(slideViewer);
    }

    @Test
    void testExecute_ClearSlides()
    {
        // Arrange

        // Act
        cmdNew.execute();

        // Assert
        verify(slideViewer, times(1)).clear();
    }

    @Test
    void testExecute_UpdateView()
    {
        // Arrange

        // Act
        cmdNew.execute();

        // Assert
        verify(slideViewer, times(1)).updateView();
    }
}
