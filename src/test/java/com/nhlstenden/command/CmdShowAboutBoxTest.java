package com.nhlstenden.command;

import com.nhlstenden.strategy.AboutBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.whenNew;

public class CmdShowAboutBoxTest {

    @Mock
    private SlideViewer mockSlideViewer;

    @Mock
    private Frame mockParentFrame;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_ShowAboutBox_Successfully() throws Exception {
        // Arrange
        CmdShowAboutBox command = new CmdShowAboutBox(mockSlideViewer, mockParentFrame);
        AboutBox mockAboutBox = mock(AboutBox.class);

        // Act
        whenNew(AboutBox.class).withNoArguments().thenReturn(mockAboutBox);
        command.execute();

        // Assert
        verify(mockAboutBox, times(1)).show(mockParentFrame);
    }
}
