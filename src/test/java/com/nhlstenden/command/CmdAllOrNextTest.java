package com.nhlstenden.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class CmdAllOrNextTest
{

    private SlideViewer mockSlideViewer;
    private CmdAllOrNext cmdAllOrNext;

    @BeforeEach
    public void setUp()
    {
        mockSlideViewer = mock(SlideViewer.class);
        cmdAllOrNext = new CmdAllOrNext(mockSlideViewer);
    }

    @Test
    public void execute_shouldShowAllOrNextAndThenUpdateView()
    {
        // Arrange: No specific arrangements needed, as we only expect the correct methods to be called

        // Act
        cmdAllOrNext.execute();
        // Assert
        verify(mockSlideViewer).showAllOrNext();
        verify(mockSlideViewer).updateView();
    }

    @Test
    public void execute_withNullSlideViewer_shouldNotThrowException() {
        // Arrange
        cmdAllOrNext = new CmdAllOrNext(null);
        // Act
        cmdAllOrNext.execute();
        // Assert: We expect no exception, so if the test passes without exception, it is passed
    }
}
