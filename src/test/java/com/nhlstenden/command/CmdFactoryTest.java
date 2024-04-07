package com.nhlstenden.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CmdFactoryTest
{

    @Mock
    private Frame parent;

    @Mock
    private SlideViewer slideViewer;

    private CmdFactory cmdFactory;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
        cmdFactory = new CmdFactory(parent, slideViewer);
    }

    @Test
    void testCreateNextSlideCMD()
    {
        // Act
        Command command = cmdFactory.createNextSlideCMD();

        // Assert
        assertNotNull(command);
        assertTrue(command instanceof CmdNextSlide);
    }

    @Test
    void testCreatePreviousSlideCMD()
    {
        // Act
        Command command = cmdFactory.createPreviousSlideCMD();

        // Assert
        assertNotNull(command);
        assertTrue(command instanceof CmdPreviousSlide);
    }

    @Test
    void testCreateNextItemCMD()
    {
        // Act
        Command command = cmdFactory.createNextItemCMD();

        // Assert
        assertNotNull(command);
        assertTrue(command instanceof CmdNextItem);
    }

    @Test
    void testCreatePreviousItemCMD()
    {
        // Act
        Command command = cmdFactory.createPreviousItemCMD();

        // Assert
        assertNotNull(command);
        assertTrue(command instanceof CmdPreviousItem);
    }

    @Test
    void testCreateShowAllOrNextCMD()
    {
        // Act
        Command command = cmdFactory.createShowAllOrNextCMD();

        // Assert
        assertNotNull(command);
        assertTrue(command instanceof CmdAllOrNext);
    }

    @Test
    void testCreateClearItemsOrBackCMD()
    {
        // Act
        Command command = cmdFactory.createClearItemsOrBackCMD();

        // Assert
        assertNotNull(command);
        assertTrue(command instanceof CmdClearOrBack);
    }

    @Test
    void testCreateExitCMD()
    {
        // Act
        Command command = cmdFactory.createExitCMD();

        // Assert
        assertNotNull(command);
        assertTrue(command instanceof CmdExit);
    }

    @Test
    void testCreateSlideByNumber()
    {
        // Act
        Command command = cmdFactory.createSlideByNumber();

        // Assert
        assertNotNull(command);
        assertTrue(command instanceof CmdSlideByNumber);
    }

    @Test
    void testCreateOpenCMD()
    {
        // Act
        Command command = cmdFactory.createOpenCMD();

        // Assert
        assertNotNull(command);
        assertTrue(command instanceof CmdOpen);
    }

    @Test
    void testCreateSaveCMD()
    {
        // Act
        Command command = cmdFactory.createSaveCMD();

        // Assert
        assertNotNull(command);
        assertTrue(command instanceof CmdSave);
    }

    @Test
    void testCreateNewCMD()
    {
        // Act
        Command command = cmdFactory.createNewCMD();

        // Assert
        assertNotNull(command);
        assertTrue(command instanceof CmdNew);
    }

    @Test
    void testCreateShowAboutBoxCMD()
    {
        // Act
        Command command = cmdFactory.createShowAboutBoxCMD();

        // Assert
        assertNotNull(command);
        assertTrue(command instanceof CmdShowAboutBox);
    }

    @Test
    void testCreateToggleItemsCMD()
    {
        // Act
        Command command = cmdFactory.createToggleItemsCMD();

        // Assert
        assertNotNull(command);
        assertTrue(command instanceof CmdToggleAllItems);
    }

    @Test
    void testCreateNullCMD()
    {
        // Act
        Command command = cmdFactory.createNullCMD();

        // Assert
        assertNotNull(command);
        assertTrue(command instanceof CmdNull);
    }
}
