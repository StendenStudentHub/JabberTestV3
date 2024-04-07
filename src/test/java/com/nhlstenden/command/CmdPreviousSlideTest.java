package com.nhlstenden.command;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CmdPreviousSlideTest
{

    private SlideViewer slideViewer;
    private CmdPreviousSlide cmdPreviousSlide;

    @BeforeEach
    public void setUp()
    {
        slideViewer = mock(SlideViewer.class);
        cmdPreviousSlide = new CmdPreviousSlide(slideViewer);
    }

    @Test
    public void testExecute_ShowPreviousSlide_UpdateView()
    {
        // Arrange

        // Act
        cmdPreviousSlide.execute();

        // Assert
        verify(slideViewer, times(1)).prevSlide();
        verify(slideViewer, times(1)).updateView();
    }

    @Test
    public void testExecute_WithMultipleCalls_ShowPreviousSlideAndUpdateViewCorrectly()
    {
        // Arrange

        // Act
        cmdPreviousSlide.execute();
        cmdPreviousSlide.execute();
        cmdPreviousSlide.execute();

        // Assert
        verify(slideViewer, times(3)).prevSlide();
        verify(slideViewer, times(3)).updateView();
    }
}