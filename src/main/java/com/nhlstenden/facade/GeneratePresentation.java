package com.nhlstenden.facade;

import com.nhlstenden.strategy.Presentation;
import com.nhlstenden.strategy.Slide;

public class GeneratePresentation
{
    public static Presentation generatePresentation(String title, int[] levels, String[] slideTwoTitles, String[] slideTwoTexts)
    {
        Presentation presentation = new Presentation();

        presentation.setTitle(title);

        for(int i = 0; i < slideTwoTitles.length; i++)
        {
            Slide slide = new Slide();
            slide.setTitle(slideTwoTitles[i]);
            slide.append(levels[i], slideTwoTexts[i]);
            presentation.append(slide);
        }

        return presentation;
    }
}
