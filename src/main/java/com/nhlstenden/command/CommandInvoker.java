package com.nhlstenden.command;

import java.io.IOException;

public class CommandInvoker
{
    // Private constructor to hide the implicit public one
    private CommandInvoker()
    {
        // Private constructor to prevent instantiation
    }

    public static void executeCommand(Command command)
    {
        try
        {
            command.execute();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
