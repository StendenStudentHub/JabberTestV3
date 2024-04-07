package com.nhlstenden.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class CmdClearOrBackTest {

    @Mock
    private SlideViewer slideViewer;

    private CmdClearOrBack command;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
        command = new CmdClearOrBack(slideViewer);
    }

    @Test
    void testExecute_ClearItems()
    {
        // Arrange
        doNothing().when(slideViewer).clearItemsOrBack();

        // Act
        command.execute();

        // Assert
        verify(slideViewer, times(1)).clearItemsOrBack();
        verify(slideViewer, times(1)).updateView();
    }

    @Test
    void testExecute_BackToLastSlide()
    {
        // Arrange
        doNothing().when(slideViewer).clearItemsOrBack();

        // Act
        command.execute();

        // Assert
        verify(slideViewer, times(1)).clearItemsOrBack();
        verify(slideViewer, times(1)).updateView();
    }
}
