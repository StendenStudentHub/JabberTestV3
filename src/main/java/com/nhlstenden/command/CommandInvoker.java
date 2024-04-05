package com.nhlstenden.command;

import java.io.IOException;

public class CommandInvoker
{
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
