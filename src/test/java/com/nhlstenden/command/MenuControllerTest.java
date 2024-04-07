package com.nhlstenden.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.reflect.Whitebox;

import java.awt.*;

import static com.nhlstenden.command.MenuController.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MenuControllerTest {

    @Mock
    private Frame frameMock;

    @Mock
    private SlideViewer slideViewerMock;

    @Mock
    private CmdFactory cmdFactoryMock;

    @BeforeEach
    void setUp()
    {
        // Initialize the mock frame
        frameMock = mock(Frame.class);
        // Initialize the mock objects
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createFileMenu_ShouldCreateFileMenuWithExpectedItems() throws Exception
    {
        // Arrange
        MenuController menuController = new MenuController(frameMock, slideViewerMock, cmdFactoryMock);

        // Act
        Menu fileMenu = Whitebox.invokeMethod(menuController, "createFileMenu");

        // Assert
        assertNotNull(fileMenu);
        assertEquals(5, fileMenu.getItemCount());
        assertEquals(FILE, fileMenu.getLabel());

        MenuItem[] expectedItems = {
                new MenuItem(OPEN),
                new MenuItem(NEW),
                new MenuItem(SAVE),
                new MenuItem(EXIT)
        };

        for (int i = 0; i < expectedItems.length; i++) {
            MenuItem actualItem = fileMenu.getItem(i);
            assertNotNull(actualItem);
            assertEquals(expectedItems[i].getLabel(), actualItem.getLabel());
        }
    }

    @Test
    void createViewMenu_ShouldCreateViewMenuWithExpectedItems() throws Exception
    {
        // Arrange
        MenuController menuController = new MenuController(frameMock, slideViewerMock, cmdFactoryMock);

        // Act
        Menu viewMenu = Whitebox.invokeMethod(menuController, "createViewMenu");

        // Assert
        assertNotNull(viewMenu);
        assertEquals(8, viewMenu.getItemCount());
        assertEquals(VIEW, viewMenu.getLabel());

        MenuItem[] expectedItems = {
                new MenuItem(NEXT),
                new MenuItem(PREVIOUS),
                new MenuItem(GO_TO),
                new MenuItem(NEXT_ITEM),
                new MenuItem(PREVIOUS_ITEM),
                new MenuItem(ALL_ITEM),
                new MenuItem(CLEAR_ITEMS),
                new MenuItem(TOGGLE)
        };

        for (int i = 0; i < expectedItems.length; i++)
        {
            MenuItem actualItem = viewMenu.getItem(i);
            assertNotNull(actualItem);
            assertEquals(expectedItems[i].getLabel(), actualItem.getLabel());
        }
    }

    @Test
    void createHelpMenu_ShouldCreateHelpMenuWithExpectedItems() throws Exception
    {
        // Arrange
        MenuController menuController = new MenuController(frameMock, slideViewerMock, cmdFactoryMock);

        // Act
        Menu helpMenu = Whitebox.invokeMethod(menuController, "createHelpMenu");

        // Assert
        assertNotNull(helpMenu);
        assertEquals(1, helpMenu.getItemCount());
        assertEquals(HELP, helpMenu.getLabel());

        MenuItem expectedItem = new MenuItem(ABOUT);

        MenuItem actualItem = helpMenu.getItem(0);
        assertNotNull(actualItem);
        assertEquals(expectedItem.getLabel(), actualItem.getLabel());
    }
}