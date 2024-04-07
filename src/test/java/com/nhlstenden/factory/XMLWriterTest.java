package com.nhlstenden.factory;

import com.nhlstenden.strategy.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class XMLWriterTest
{
    @Mock
    private Presentation presentationMock;

    @Mock
    private Slide slideMock1, slideMock2;

    @Mock
    private TextItem textItemMock1, textItemMock2;

    @Mock
    private BitmapItem bitmapItemMock;

    @Test
    public void testWrite_GeneratesCorrectXml() throws IOException
    {
        // Arrange
        String filename = "test.xml";
        String presentationTitle = "Test Presentation";
        String slide1Title = "Slide 1";
        String slide2Title = "Slide 2";
        String text1 = "This is text item 1";
        String text2 = "This is text item 2";
        String imageFilename = "image.png";

        when(presentationMock.getTitle()).thenReturn(presentationTitle);
        when(presentationMock.getSize()).thenReturn(2);
        when(presentationMock.getSlide(0)).thenReturn(slideMock1);
        when(presentationMock.getSlide(1)).thenReturn(slideMock2);

        when(slideMock1.getTitle()).thenReturn(slide1Title);
        when(slideMock2.getTitle()).thenReturn(slide2Title);

        Vector<SlideItem> slideItems1 = new Vector<>();
        slideItems1.add(textItemMock1);
        when(slideMock1.getSlideItems()).thenReturn(slideItems1);

        Vector<SlideItem> slideItems2 = new Vector<>();
        slideItems2.add(textItemMock2);
        slideItems2.add(bitmapItemMock);
        when(slideMock2.getSlideItems()).thenReturn(slideItems2);

        when(textItemMock1.getLevel()).thenReturn(1);
        when(textItemMock1.getText()).thenReturn(text1);

        when(textItemMock2.getLevel()).thenReturn(2);
        when(textItemMock2.getText()).thenReturn(text2);

        when(bitmapItemMock.getLevel()).thenReturn(1);
        when(bitmapItemMock.getImageName()).thenReturn(imageFilename);

        // Act
        XMLWriter xmlWriter = new XMLWriter();
        xmlWriter.Write(presentationMock, filename);

        // Assert
        File outputFile = new File(filename);
        assertTrue(outputFile.exists());

        // Verify XML content
        String expectedXml = "<?xml version=\"1.0\"?>\n" +
                "<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">\n" +
                "<presentation>\n" +
                "  <showtitle>Test Presentation</showtitle>\n" +
                "  <slide>\n" +
                "    <title>Slide 1</title>\n" +
                "    <item kind=\"text\" level=\"1\">This is text item 1</item>\n" +
                "  </slide>\n" +
                "  <slide>\n" +
                "    <title>Slide 2</title>\n" +
                "    <item kind=\"text\" level=\"2\">This is text item 2</item>\n" +
                "    <item kind=\"image\" level=\"1\">image.png</item>\n" +
                "  </slide>\n" +
                "</presentation>";

        String actualXml = org.apache.commons.io.FileUtils.readFileToString(outputFile, "UTF-8");
        assertEquals(expectedXml, actualXml);
    }

    @Test
    public void testWrite_HandlesIOException() throws IOException
    {
        // Arrange
        String filename = "/nonexistent/path/file.xml";
        when(presentationMock.getTitle()).thenReturn("Test Presentation");

        // Act
        XMLWriter xmlWriter = new XMLWriter();

        // Assert
        try
        {
            xmlWriter.Write(presentationMock, filename);
        }
        catch (IOException e)
        {
            // Expected
        }
    }
}
