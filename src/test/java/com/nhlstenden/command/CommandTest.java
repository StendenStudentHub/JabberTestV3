package com.nhlstenden.command;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CommandTest
{

    @Test
    public void getSlideViewer_ShouldReturnSlideViewer_WhenInitializedWithSlideViewer()
    {
        // Arrange
        SlideViewer slideViewer = mock(SlideViewer.class);
        Command command = new TestCommand(slideViewer);

        // Act
        SlideViewer result = command.getSlideViewer();

        // Assert
        assertEquals(slideViewer, result);
    }

    @Test
    public void setSlideViewer_ShouldSetSlideViewer()
    {
        // Arrange
        SlideViewer slideViewer = mock(SlideViewer.class);
        Command command = new TestCommand(null);

        // Act
        command.setSlideViewer(slideViewer);

        // Assert
        assertEquals(slideViewer, command.getSlideViewer());
    }

    @Test
    public void execute_ShouldThrowIOException_WhenNotOverridden()
    {
        // Arrange
        Command command = new TestCommand(null);

        // Act & Assert
        Executable executable = () -> command.execute();
        IOException exception = assertThrows(IOException.class, executable);
        assertEquals("Not implemented", exception.getMessage());
    }

    @Test
    public void execute_ShouldCallDoSomethingMethod_WhenOverridden() throws IOException
    {
        // Arrange
        SlideViewer slideViewer = mock(SlideViewer.class);
        Command command = new TestCommand(slideViewer);

        // Act
        command.execute();

        // Assert
        verify(slideViewer).nextSlide();
    }

    // TestCommand is a concrete subclass of Command used for testing purposes
    private static class TestCommand extends Command
    {

        public TestCommand(SlideViewer slideViewer)
        {
            super(slideViewer);
        }

        @Override
        public void execute() throws IOException
        {
            getSlideViewer().nextSlide();
        }
    }
}
