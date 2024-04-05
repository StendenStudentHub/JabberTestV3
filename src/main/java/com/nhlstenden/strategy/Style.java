package com.nhlstenden.strategy;

import java.awt.*;

public class Style
{
    private static final String FONT_NAME = "Helvetica";
    private int indent;
    private static int fontSize;
    private int leading;
    private int points;
    private Color color;
    private static Font font;

    public Style(int indent, Color color, int points,  int leading)
    {
        this.indent = indent;
        this.leading = leading;
        this.color = color;
        this.font = new Font(FONT_NAME, Font.BOLD, fontSize = points);
    }

    public Font getfont(float scale)
    {
        return font.deriveFont(fontSize * scale);
    }

    public static Font getFont(float scale)
    {
        return font.deriveFont(fontSize * scale);
    }

    public void setFontSize(int fontSize)
    {
        Style.fontSize = fontSize;
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