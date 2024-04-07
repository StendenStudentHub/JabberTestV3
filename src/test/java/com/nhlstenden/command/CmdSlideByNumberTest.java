package com.nhlstenden.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class CmdSlideByNumberTest
{

    private SlideViewer slideViewerMock;
    private CmdSlideByNumber cmdSlideByNumber;

    @BeforeEach
    void setUp()
    {
        slideViewerMock = mock(SlideViewer.class);
        cmdSlideByNumber = new CmdSlideByNumber(slideViewerMock);
    }

    @Test
    void execute_ShouldGoToSpecifiedSlideNumber()
    {
        // Arrange

        // Act
        cmdSlideByNumber.execute();

        // Assert
        verify(slideViewerMock).goToSlideNumber();
    }
}
