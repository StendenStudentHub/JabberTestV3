package com.nhlstenden.facade;

import org.junit.jupiter.api.Test;
import org.powermock.api.mockito.PowerMockito;

import javax.swing.*;
import java.awt.*;

import static org.mockito.Mockito.*;

public class AboutBoxTest {

    @Test
    void show_ShouldDisplayAboutBox_WhenCalled()
    {
        // Arrange
        Frame parent = mock(Frame.class);

        // Act
        AboutBox.show(parent);

        // Assert
        // We can't make an assertion directly here because JOptionPane is a static method
        // and we don't want to open any real dialogs during test execution.
        // Instead we can check the static method JOptionPane.showMessageDialog
        // once called with the appropriate arguments.
        PowerMockito.verifyStatic(JOptionPane.class, times(1));
        JOptionPane.showMessageDialog(parent,
                "JabberPoint is a primitive slide-show program in Java(tm). It\n"
                        + "is freely copyable as long as you keep this notice and\n" + "the splash screen intact.\n"
                        + "Copyright (c) 1995-1997 by Ian F. Darwin, ian@darwinsys.com.\n"
                        + "Adapted by Gert Florijn (version 1.1) and " + "Sylvia Stuurman (version 1.2 and higher) for the Open"
                        + "University of the Netherlands, 2002 -- now."
                        + "Author's version available from http://www.darwinsys.com/",
                "About JabberPoint", JOptionPane.INFORMATION_MESSAGE);
    }
}
