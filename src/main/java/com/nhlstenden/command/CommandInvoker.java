package com.nhlstenden.command;

public class CommandInvoker
{
    public static void executeCommand(Command command)
    {
        command.execute();
    }
}
