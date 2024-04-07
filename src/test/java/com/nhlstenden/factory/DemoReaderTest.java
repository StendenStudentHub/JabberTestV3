package com.nhlstenden.factory;

import com.nhlstenden.factory.DemoReader;
import com.nhlstenden.strategy.Presentation;
import com.nhlstenden.strategy.Slide;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DemoReaderTest {

    @Test
    void read_ShouldReturnValidPresentation() throws IOException
    {
        // Arrange
        DemoReader reader = new DemoReader();
        String fileName = "demo.xml";

        // Act
        Presentation presentation = reader.Read(fileName);

        // Assert
        assertNotNull(presentation);
        assertEquals("Demo Presentation", presentation.getTitle());
        assertEquals(3, presentation.getSize());

        Slide firstSlide = presentation.getSlide(0);
        assertNotNull(firstSlide);
        assertEquals("JabberPoint", firstSlide.getTitle());
        assertEquals(14, firstSlide.getSlideItems().size());

        Slide secondSlide = presentation.getSlide(1);
        assertNotNull(secondSlide);
        assertEquals("Demonstratie van levels en stijlen", secondSlide.getTitle());
        assertEquals(7, secondSlide.getSlideItems().size());

        Slide thirdSlide = presentation.getSlide(2);
        assertNotNull(thirdSlide);
        assertEquals("De derde slide", thirdSlide.getTitle());
        assertEquals(6, thirdSlide.getSlideItems().size());
    }
}
