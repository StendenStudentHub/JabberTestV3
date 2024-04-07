package com.nhlstenden.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class CmdExitTest
{

    @Mock
    private SlideViewer slideViewer;

    private CmdExit command;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
        command = new CmdExit(slideViewer);
    }

    @Test
    void testExecute_ExitProgram()
    {
        // Arrange

        // Act
        command.execute();

        // Assert
        verify(slideViewer, times(1)).exit(0);
    }
}
