package com.nhlstenden.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class CmdNullTest
{

    @Mock
    private SlideViewer slideViewer;

    private CmdNull cmdNull;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
        cmdNull = new CmdNull(slideViewer);
    }

    @Test
    void testExecute_NoActionNeeded() {

        // Act
        cmdNull.execute();

        // Assert
        // Verify that no methods of SlideViewer are called
        verifyNoInteractions(slideViewer);
    }
}
