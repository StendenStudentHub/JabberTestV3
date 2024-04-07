package com.nhlstenden.strategy;


import org.junit.jupiter.api.Test;

import javax.swing.text.Style;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StyleStrategyTest {

    @Test
    void setStyle_ShouldSetStyle() {
        // Arrange
        SlideItem item = mock(SlideItem.class);
        StyleStrategy styleStrategy = new MyStyleStrategy();

        // Act
        styleStrategy.setStyle(item);

        // Assert
        verify(item, times(1)).setItemStyle((Style) any(MyStyle.class));
    }

    // Mock implementation of StyleStrategy for testing purposes
    static class MyStyleStrategy extends StyleStrategy {
        @Override
        public void setStyle(SlideItem item) {
            MyStyle style = new MyStyle(0, Color.red, 48, 20);
            item.setItemStyle((Style) style);
        }
    }
}
