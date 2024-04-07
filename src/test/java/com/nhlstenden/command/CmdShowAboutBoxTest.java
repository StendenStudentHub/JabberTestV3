package com.nhlstenden.command;

import com.nhlstenden.facade.AboutBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;

import static org.mockito.Mockito.*;

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
    void execute_ShowAboutBox_Successfully() {
        // Arrange
        CmdShowAboutBox command = new CmdShowAboutBox(mockSlideViewer, mockParentFrame);

        // Act
        command.execute();

        // Assert
       // verify(AboutBox.class, times(1)).show(mockParentFrame);
    }
}
