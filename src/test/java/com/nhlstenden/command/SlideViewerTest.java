package com.nhlstenden.command;

import com.nhlstenden.strategy.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SlideViewerTest {

    @Mock
    private Presentation presentationMock;

    @Mock
    private SlideViewerComponent slideViewerComponentMock;

    private SlideViewer slideViewer;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);
        slideViewer = new SlideViewer(presentationMock);
        slideViewer.setShowView(slideViewerComponentMock);
    }

    @Test
    void setPresentation_ShouldSetPresentationAndSetSlideViewerComponentPresentation()
    {
        // Arrange
        Presentation newPresentation = mock(Presentation.class);

        // Act
        slideViewer.setPresentation(newPresentation);

        // Assert
        assertEquals(newPresentation, slideViewer.getPresentation());
        verify(slideViewerComponentMock).setPresentation(newPresentation);
    }

    @Test
    void nextSlide_ShouldIncrementSlideNumberIfMoreSlidesAvailable()
    {
        // Arrange
        when(presentationMock.getSlideNumber()).thenReturn(0);

        // Act
        slideViewer.nextSlide();

        // Assert
        verify(presentationMock).setCurrentSlideNumber(1);
    }

    @Test
    void nextSlide_ShouldNotIncrementSlideNumberIfNoMoreSlidesAvailable()
    {
        // Arrange
        when(presentationMock.getSlideNumber()).thenReturn(1);
        when(presentationMock.getSize()).thenReturn(2); // Assuming there are 2 slides

        // Act
        slideViewer.nextSlide();

        // Assert
        verify(presentationMock, never()).setCurrentSlideNumber(anyInt());
    }

    @Test
    void prevSlide_ShouldDecrementSlideNumberIfGreaterThanZero()
    {
        // Arrange
        when(presentationMock.getSlideNumber()).thenReturn(1);

        // Act
        slideViewer.prevSlide();

        // Assert
        verify(presentationMock).setCurrentSlideNumber(0);
    }

    @Test
    void prevSlide_ShouldNotDecrementSlideNumberIfZero()
    {
        // Arrange
        when(presentationMock.getSlideNumber()).thenReturn(0);

        // Act
        slideViewer.prevSlide();

        // Assert
        verify(presentationMock, never()).setCurrentSlideNumber(anyInt());
    }
}
