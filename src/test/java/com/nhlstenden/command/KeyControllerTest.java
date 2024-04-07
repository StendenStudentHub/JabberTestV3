package com.nhlstenden.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;


import java.awt.*;
import java.awt.event.KeyEvent;

import static org.mockito.Mockito.verify;

class KeyControllerTest
{

    @Mock
    private CmdFactory cmdFactory;

    private KeyController keyController;

    KeyEvent keyEvent = mock(KeyEvent.class);

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
        keyController = new KeyController(cmdFactory);
    }

    @Test
    void keyPressed_ShouldCreateNextItemCommand_WhenDownArrowKeyIsPressed()
    {
        // Arrange
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_DOWN);
        when(keyEvent.getKeyChar()).thenReturn(' ');

        // Act
        keyController.keyPressed(keyEvent);

        // Assert
        verify(cmdFactory).createNextItemCMD();
    }

    @Test
    void keyPressed_ShouldCreatePreviousSlideCommand_WhenPageUpKeyIsPressed()
    {
        // Arrange
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_PAGE_UP);

        // Act
        keyController.keyPressed(keyEvent);

        // Assert
        verify(cmdFactory).createPreviousSlideCMD();
    }

    @Test
    void keyPressed_ShouldCreatePreviousItemCommand_WhenMinusKeyIsPressed()
    {
        // Arrange
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_MINUS);
        when(keyEvent.getKeyChar()).thenReturn('-');

        // Act
        keyController.keyPressed(keyEvent);

        // Assert
        verify(cmdFactory).createPreviousItemCMD();
    }

    @Test
    void keyPressed_ShouldCreateToggleItemsCommand_WhenTKeyIsPressed()
    {
        // Arrange
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_T);
        when(keyEvent.getKeyChar()).thenReturn('T');

        // Act
        keyController.keyPressed(keyEvent);

        // Assert
        verify(cmdFactory).createToggleItemsCMD();
    }

    @Test
    void keyPressed_ShouldCreateNullCommand_WhenNonExistingKeyIsPressed()
    {
        // Arrange
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_F1);

        // Act
        keyController.keyPressed(keyEvent);

        // Assert
        verify(cmdFactory).createNullCMD();
    }

}
