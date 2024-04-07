package com.nhlstenden.command;

import com.nhlstenden.strategy.MyStyle;
import com.nhlstenden.strategy.Presentation;
import com.nhlstenden.strategy.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SlideViewerComponentTest
{

    @Mock
    private JFrame frameMock;

    @Mock
    private Presentation presentationMock;

    @Mock
    private Slide slideMock;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void update_NullData_CallsRepaint()
    {
        // Arrange
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent(frameMock, presentationMock);

        // Act
        slideViewerComponent.update("Title", null);

        // Assert
        verify(frameMock).repaint();
        verifyNoInteractions(presentationMock);
    }

    @Test
    void update_ValidData_CallsRepaintAndSetTitle()
    {
        // Arrange
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent(frameMock, presentationMock);
        when(slideMock.getDimension("width")).thenReturn(800);
        when(slideMock.getDimension("height")).thenReturn(600);

        // Act
        slideViewerComponent.update("Title", slideMock);

        // Assert
        verify(frameMock).repaint();
        verify(frameMock).setTitle("Title");
    }

    @Test
    void paintComponent_CorrectlyDrawsComponent()
    {
        // Arrange
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent(frameMock, presentationMock);
        Graphics graphicsMock = mock(Graphics.class);
        MyStyle myStyleMock = mock(MyStyle.class);
        ImageObserver imageObserverMock = mock(ImageObserver.class);
        when(slideMock.getDimension("width")).thenReturn(800);
        when(slideMock.getDimension("height")).thenReturn(600);
        when(presentationMock.getSlideNumber()).thenReturn(1);
        slideViewerComponent.update("Title", slideMock);

        // Act
        slideViewerComponent.paintComponent(graphicsMock, myStyleMock);

        // Assert
        verify(graphicsMock).setColor(Color.white);
        verify(graphicsMock).fillRect(0, 0, 800, 600);
        verify(graphicsMock).setFont(any(Font.class));
        verify(graphicsMock).setColor(Color.black);
        verify(graphicsMock).drawString("Slide 2 of 1", 1100, 20);
        verify(slideMock).getTitle();
        verify(slideMock).getSlideItems();
    }

    @Test
    void getPreferredSize_ReturnsCorrectSize()
    {
        // Arrange
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent(frameMock, presentationMock);

        // Act
        Dimension preferredSize = slideViewerComponent.getPreferredSize();

        // Assert
        assertEquals(new Dimension(Slide.WIDTH, Slide.HEIGHT), preferredSize);
    }
}
