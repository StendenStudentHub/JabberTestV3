package com.nhlstenden.command;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Supplier;

public class MenuController extends MenuBar
{
    //Constants
    protected static final String ABOUT = "About"; // Menu label for About
    protected static final String FILE = "File"; // Menu label for File
    protected static final String EXIT = "Exit"; // Menu label for Exit
    protected static final String GO_TO = "Go to"; // Menu label for Go to
    protected static final String HELP = "Help"; // Menu label for Help
    protected static final String NEW = "New"; // Menu label for New
    protected static final String NEXT = "Next slide"; // Menu label for Next
    protected static final String OPEN = "Open"; // Menu label for Open
    protected static final String PREVIOUS = "Previous slide"; // Menu label for Previous slide
    protected static final String SAVE = "Save"; // Menu label for Save
    protected static final String VIEW = "View"; // Menu label for View
    protected static final String NEXT_ITEM = "Next item"; // Menu label for Next item
    protected static final String PREVIOUS_ITEM = "Previous item"; // Menu label for Previous item
    protected static final String ALL_ITEM = "All items"; // Menu label for All items
    protected static final String CLEAR_ITEMS = "Clear items"; // Menu label for Clear items
    protected static final String TOGGLE = "Toggle item navigation"; // Menu label for Toggle item navigation

    //Variables
    private final CmdFactory cmdFactory; // Command factory for creating commands

    // Constructor to initialize the MenuController with a frame, SlideViewer, and CmdFactory
    public MenuController(Frame frame, SlideViewer slv, CmdFactory cmdFactory)
    {
        this.cmdFactory = cmdFactory;

        // FILE menu
        Menu fileMenu = createFileMenu();
        add(fileMenu);

        // VIEW menu
        Menu viewMenu = createViewMenu();
        add(viewMenu);

        // HELP menu
        Menu helpMenu = createHelpMenu();
        setHelpMenu(helpMenu);
    }

    // Creates the FILE menu
    private Menu createFileMenu()
    {
        Menu fileMenu = new Menu(FILE);
        fileMenu.add(createMenuItem(OPEN, cmdFactory::createOpenCMD));
        fileMenu.add(createMenuItem(NEW, cmdFactory::createNewCMD));
        fileMenu.add(createMenuItem(SAVE, cmdFactory::createSaveCMD));
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem(EXIT, cmdFactory::createExitCMD));

        return fileMenu;
    }

    // Creates the VIEW menu
    private Menu createViewMenu()
    {
        Menu viewMenu = new Menu(VIEW);
        viewMenu.add(createMenuItem(NEXT, cmdFactory::createNextSlideCMD));
        viewMenu.add(createMenuItem(PREVIOUS, cmdFactory::createPreviousSlideCMD));
        viewMenu.add(createMenuItem(GO_TO, cmdFactory::createSlideByNumber));
        viewMenu.addSeparator();
        viewMenu.add(createMenuItem(TOGGLE, cmdFactory::createToggleItemsCMD));

        return viewMenu;
    }

    // Creates the HELP menu
    private Menu createHelpMenu()
    {
        Menu helpMenu = new Menu(HELP);
        helpMenu.add(createMenuItem(ABOUT, cmdFactory::createShowAboutBoxCMD));
        helpMenu.addSeparator();
        return helpMenu;
    }

    // Creates a menu item with the given label
    private MenuItem createMenuItem(String label)
    {
        return new MenuItem(label);
    }

    // Creates a menu item with the given label and command supplier
    private MenuItem createMenuItem(String label, Supplier<Command> commandSupplier)
    {
        MenuItem menuItem = createMenuItem(label);
        menuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                CommandInvoker.executeCommand(commandSupplier.get());
            }
        });

        return menuItem;
    }
}
