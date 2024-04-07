package com.nhlstenden.command;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CommandInvokerTest
{
    @Test
    public void executeCommand_ShouldExecuteCommand() throws IOException
    {
        // Arrange
        Command mockCommand = mock(Command.class);

        // Act
        CommandInvoker.executeCommand(mockCommand);

        // Assert
        verify(mockCommand, times(1)).execute();
    }

    @Test
    public void executeCommand_ShouldThrowRuntimeException_WhenCommandThrowsIOException() throws IOException
    {
        // Arrange
        Command mockCommand = mock(Command.class);
        IOException mockIOException = mock(IOException.class);
        doThrow(mockIOException).when(mockCommand).execute();

        // Act & Assert
        try
        {
            CommandInvoker.executeCommand(mockCommand);
        }
        catch (RuntimeException e)
        {
            // Verify that the thrown exception is the IOException wrapped in a RuntimeException
            assertSame(mockIOException, e.getCause());
        }
    }
}
