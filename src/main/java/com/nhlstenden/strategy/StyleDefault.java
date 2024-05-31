package com.nhlstenden.strategy;

import java.awt.*;

public class StyleDefault extends StyleStrategy
{
    //Variables
    private MyStyle[] myStyles;

    private javax.swing.text.Style getStyle(int level)
    {
        if (level >= myStyles.length)
        {
            level = myStyles.length - 1;
        }

        return (javax.swing.text.Style) myStyles[level];
    }

    //Constructor
    public void styleDefault()
    {
        //Set the default style
        myStyles = new MyStyle[5];

        myStyles[0] = new MyStyle(0, Color.red, 48, 20);
        myStyles[1] = new MyStyle(20, Color.blue, 40, 10);
        myStyles[2] = new MyStyle(50, Color.black, 36, 10);
        myStyles[3] = new MyStyle(70, Color.black, 30, 10);
        myStyles[4] = new MyStyle(90, Color.black, 24, 10);
    }

    @Override
    public void setStyle(SlideItem item)
    {
        item.setItemStyle(getStyle(item.getLevel()));
    }
}
