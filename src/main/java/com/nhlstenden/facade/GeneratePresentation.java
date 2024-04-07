package com.nhlstenden.facade;

import com.nhlstenden.strategy.Presentation;
import com.nhlstenden.strategy.Slide;

public class GeneratePresentation
{
    //This method will generate a presentation with the given parameters.
    //It's using an int and a String list for the different texts and titles for the slides.
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