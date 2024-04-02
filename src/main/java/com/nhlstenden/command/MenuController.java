package com.nhlstenden.command;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private Menu fileMenu = new Menu(FILE);

    public MenuController(Frame frame, SlideViewer slideViewer, CmdFactory cmdFactory)
    {
        this.frame = frame;
        this.slideViewer = slideViewer;
        this.cmdFactory = cmdFactory;
    }

    private void makeFileMenu()
    {
        fileMenu.add(menuItem = createMenuItem(OPEN));
        menuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                CommandInvoker.executeCommand(cmdFactory.createOpenCMD());
            }
        });
    }

    private void makeNewMenu()
    {

    }

    public MenuItem createMenuItem(String name)
    {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
