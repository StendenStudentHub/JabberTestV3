package com.nhlstenden.strategy;

import java.awt.*;

public class MyStyle
{
    private static final String FONT_NAME = "Helvetica";
    private final int indent;
    private static int fontSize;
    private final int leading;
    private final Color color;
    private static Font font;

    public MyStyle(int indent, Color color, int points, int leading)
    {
        this.indent = indent;
        this.leading = leading;
        this.color = color;
        this.font = new Font(FONT_NAME, Font.BOLD, fontSize = points);
    }

    public static Font getFont(float scale)
    {
        return font.deriveFont(fontSize * scale);
    }

    public int getIndent()
    {
        return this.indent;
    }


    public Color getColor()
    {
        return this.color;
    }

    public int getLeading()
    {
        return this.leading;
    }

    public String toString()
    {
        return "{" + this.indent + "," + this.color + ", " + fontSize + " on " + this.leading + "}";
    }
}
