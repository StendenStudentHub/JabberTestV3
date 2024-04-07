package com.nhlstenden.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CmdNextSlideTest
{

    @Mock
    private SlideViewer slideViewer;

    private CmdNextSlide cmdNextSlide;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
        cmdNextSlide = new CmdNextSlide(slideViewer);
    }

    @Test
    void testExecute_ShowNextSlide()
    {
        // Act
        cmdNextSlide.execute();

        // Assert
        verify(slideViewer, times(1)).nextSlide();
    }

    @Test
    void testExecute_UpdateView()
    {
        // Act
        cmdNextSlide.execute();

        // Assert
        verify(slideViewer, times(1)).updateView();
    }
}
