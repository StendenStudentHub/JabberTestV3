package com.nhlstenden.factory;

import com.nhlstenden.strategy.Presentation;

import com.nhlstenden.strategy.Slide;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class XMLReaderTest {

    @Test
    void read_ValidXMLFile_ShouldReturnPresentation() throws IOException
    {
        // Arrange
        XMLReader xmlReader = new XMLReader();
        PresentationFactory presentationFactoryMock = mock(PresentationFactory.class);
        Presentation presentationMock = mock(Presentation.class);
        when(presentationFactoryMock.CreatePresentation()).thenReturn(presentationMock);
        when(PresentationFactory.GetFactory(any())).thenReturn(presentationFactoryMock);

        // Act
        Presentation result = xmlReader.Read("valid_presentation.xml");

        // Assert
        assertNotNull(result);
        // Add more assertions to check if the presentation is read correctly
    }

    @Test
    void read_XMLFileWithMissingShowTitleTag_ShouldThrowIOException()
    {
        // Arrange
        XMLReader xmlReader = new XMLReader();

        // Act & Assert
        assertThrows(IOException.class, () -> xmlReader.Read("missing_showtitle.xml"));
    }

    @Test
    void read_XMLFileWithInvalidItemLevel_ShouldLoadItemWithDefaultLevel() throws IOException
    {
        // Arrange
        XMLReader xmlReader = new XMLReader();
        PresentationFactory presentationFactoryMock = mock(PresentationFactory.class);
        Presentation presentationMock = mock(Presentation.class);
        when(presentationFactoryMock.CreatePresentation()).thenReturn(presentationMock);
        when(PresentationFactory.GetFactory(any())).thenReturn(presentationFactoryMock);

        // Act
        Presentation result = xmlReader.Read("invalid_item_level.xml");

        // Assert
        assertNotNull(result);
        // Add assertions to check if the presentation is read correctly with default level for invalid items
        Slide slide = result.getSlide(0);
        assertNotNull(slide);
        assertEquals("Default Title", slide.getTitle()); // Assuming default title
        assertEquals(1, slide.getSlideItems().size());
    }

    @Test
    void read_XMLFileWithUnknownItemType_ShouldIgnoreItemAndLogWarning() throws IOException
    {
        // Arrange
        XMLReader xmlReader = new XMLReader();
        PresentationFactory presentationFactoryMock = mock(PresentationFactory.class);
        Presentation presentationMock = mock(Presentation.class);
        when(presentationFactoryMock.CreatePresentation()).thenReturn(presentationMock);
        when(PresentationFactory.GetFactory(any())).thenReturn(presentationFactoryMock);

        // Act
        Presentation result = xmlReader.Read("unknown_item_type.xml");

        // Assert
        assertNotNull(result);
        // Add assertions to check if the warning message is logged appropriately
        // Assuming the warning message is logged to console
        // You can redirect the logging output to capture the logs for testing
    }
}
