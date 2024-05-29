package com.nhlstenden.facade;

import com.nhlstenden.strategy.Presentation;
import com.nhlstenden.strategy.Slide;

import java.util.ArrayList;

public class GeneratePresentation
{
    //This method will generate a presentation with the given parameters.
    //It's using an int and a String list for the different texts and titles for the slides.
    public static Presentation generatePresentation(String title, ArrayList<Integer> levels, ArrayList<String> slideTwoTitles, ArrayList<String> slideTwoTexts)
    {
        Presentation presentation = new Presentation();

        presentation.setTitle(title);

        for(int i = 0; i < slideTwoTitles.size(); i++)
        {
            Slide slide = new Slide();
            slide.setTitle(slideTwoTitles.get(i));
            slide.append(levels.get(i), slideTwoTexts.get(i));
            presentation.append(slide);
        }

        return presentation;
    }
}