package com.nhlstenden.command;

import com.nhlstenden.factory.AccessorFactory;
import com.nhlstenden.factory.Reader;
import com.nhlstenden.factory.Writer;
import com.nhlstenden.strategy.Presentation;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mockStatic;

public class CmdSaveTest {

    @Test
    void execute_SaveSuccessful() throws IOException
    {
        // Arrange
        SlideViewer slideViewer = Mockito.mock(SlideViewer.class);
        Frame parent = new Frame();
        Presentation presentation = Mockito.mock(Presentation.class);
        Writer writerMock = Mockito.mock(Writer.class);

        try (MockedStatic<AccessorFactory> mockedStatic = mockStatic(AccessorFactory.class))
        {
            mockedStatic.when(() -> AccessorFactory.GetFactory(any())).thenReturn(new MockAccessorFactory(writerMock));

            // Act
            CmdSave cmdSave = new CmdSave(slideViewer, parent, presentation);
            cmdSave.execute();

            // Assert
            Mockito.verify(writerMock).Write(presentation, CmdSave.SAVE_FILE);
        }
    }

    @Test
    void execute_SaveIOException_ShowErrorMessage() throws IOException
    {
        // Arrange
        SlideViewer slideViewer = Mockito.mock(SlideViewer.class);
        Frame parent = new Frame();
        Presentation presentation = Mockito.mock(Presentation.class);
        IOException ioException = new IOException("IO Exception");
        Writer writerMock = Mockito.mock(Writer.class);
        doThrow(ioException).when(writerMock).Write(presentation, CmdSave.SAVE_FILE);

        try (MockedStatic<AccessorFactory> mockedStatic = mockStatic(AccessorFactory.class))
        {
            mockedStatic.when(() -> AccessorFactory.GetFactory(any())).thenReturn(new MockAccessorFactory(writerMock));

            // Act
            CmdSave cmdSave = new CmdSave(slideViewer, parent, presentation);
            cmdSave.execute();

            // Assert
            JOptionPane mockOptionPane = Mockito.mock(JOptionPane.class);
            Mockito.verify(mockOptionPane).showMessageDialog(parent, CmdSave.IO_EXCEPTION + ioException, CmdSave.SAVE_ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }

    private static class MockAccessorFactory extends AccessorFactory
    {
        private final Writer writer;

        public MockAccessorFactory(Writer writer) {
            this.writer = writer;
        }

        @Override
        public Reader CreateReader() {
            return null;
        }

        @Override
        public Writer CreateWriter() {
            return writer;
        }
    }
}
