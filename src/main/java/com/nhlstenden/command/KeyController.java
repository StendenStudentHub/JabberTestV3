package com.nhlstenden.command;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter
{
    private final CmdFactory cmdFactory;
    public KeyController(CmdFactory cmdFactory)
    {
        this.cmdFactory = cmdFactory;
    }

    public void keyPressed(KeyEvent keyEvent)
    {
        Command selectedCommand = switch (keyEvent.getKeyCode())
        {
            case KeyEvent.VK_PAGE_DOWN, KeyEvent.VK_ENTER ->
                // unconditional next slide
                    this.cmdFactory.createNextSlideCMD();
            case KeyEvent.VK_DOWN, '+' ->
                // next item / next slide (if all items shown)
                    this.cmdFactory.createNextItemCMD();
            case KeyEvent.VK_PAGE_UP, KeyEvent.VK_BACK_SPACE ->
                // unconditional previous slide
                    this.cmdFactory.createPreviousSlideCMD();
            case KeyEvent.VK_UP, '-' ->
                // previous item / previous slide (if no items shown)
                    this.cmdFactory.createPreviousItemCMD();
            case 'q', 'Q', KeyEvent.VK_ESCAPE ->
                // exit the application
                    this.cmdFactory.createExitCMD();
            case KeyEvent.VK_RIGHT ->
                // next slide, all items
                    this.cmdFactory.createShowAllOrNextCMD();
            case KeyEvent.VK_LEFT ->
                // previous slide, all items
                    this.cmdFactory.createClearItemsOrBackCMD();
            case 't', 'T' ->
                // show all
                    this.cmdFactory.createToggleItemsCMD();
            default ->
                // If non-existing key is pressed, do nothing
                    this.cmdFactory.createNullCMD();
        };

        CommandInvoker.executeCommand(selectedCommand);
    }
}
