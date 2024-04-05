package com.nhlstenden.command;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Supplier;

public class MenuController extends MenuBar
{
    private static final long SERIAL_VERSION_UID = 227L;
    protected static final String ABOUT = "About";
    protected static final String FILE = "File";
    protected static final String EXIT = "Exit";
    protected static final String GO_TO = "Go to";
    protected static final String HELP = "Help";
    protected static final String NEW = "New";
    protected static final String NEXT = "Next";
    protected static final String OPEN = "Open";
    protected static final String PAGE_NUMBER = "Page number";
    protected static final String PREVIOUS = "Previous slide";
    protected static final String SAVE = "Save";
    protected static final String VIEW = "View";
    protected static final String NEXT_ITEM = "Next item";
    protected static final String PREVIOUS_ITEM = "Previous item";
    protected static final String ALL_ITEM = "All items";
    protected static final String CLEAR_ITEMS = "Clear items";
    protected static final String TOGGLE = "Toggle item navigation";
    protected static final String NUMBER_OF_ITEMS = "Display items";

    private Frame frame;
    private SlideViewer slideViewer;
    private CmdFactory cmdFactory;
    private MenuItem menuItem;

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

    private Menu createViewMenu()
    {
        Menu viewMenu = new Menu(VIEW);
        viewMenu.add(createMenuItem(NEXT, cmdFactory::createNextSlideCMD));
        viewMenu.add(createMenuItem(PREVIOUS, cmdFactory::createPreviousSlideCMD));
        viewMenu.add(createMenuItem(GO_TO, cmdFactory::createSlideByNumber));
        viewMenu.add(createMenuItem(NEXT_ITEM, cmdFactory::createNextItemCMD));
        viewMenu.add(createMenuItem(PREVIOUS_ITEM, cmdFactory::createPreviousItemCMD));
        viewMenu.add(createMenuItem(ALL_ITEM, cmdFactory::createShowAllOrNextCMD));
        viewMenu.add(createMenuItem(CLEAR_ITEMS, cmdFactory::createClearItemsOrBackCMD));
        viewMenu.add(createMenuItem(TOGGLE, cmdFactory::createToggleItemsCMD));

        return viewMenu;
    }

    private Menu createHelpMenu()
    {
        Menu helpMenu = new Menu(HELP);
        helpMenu.add(createMenuItem(ABOUT, cmdFactory::createShowAboutBoxCMD));

        return helpMenu;
    }

    private MenuItem createMenuItem(String label)
    {
        return new MenuItem(label);
    }

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
