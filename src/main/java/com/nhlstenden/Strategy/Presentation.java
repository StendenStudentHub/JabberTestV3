package com.nhlstenden.strategy;

import java.util.ArrayList;

/**
 * <p>
 * Presentation
 * </p>
 * <p>
 * Presentation holds the data of the current presentation.
 * </p>
 * 
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation
{
	private String showTitle; // de titel van de presentatie
	private ArrayList<com.nhlstenden.strategy.Slide> showList = null; // een ArrayList met de Slides
	private int currentSlideNumber = 0; // het slidenummer van de huidige Slide

	public Presentation()
	{
		clear();
	}

	public int getSize()
	{
		return showList.size();
	}

	public String getTitle()
	{
		return showTitle;
	}

	public void setTitle(String nt)
	{
		showTitle = nt;
	}

	// geef het nummer van de huidige slide
	public int getSlideNumber()
	{
		return currentSlideNumber;
	}

	// verander het huidige-slide-nummer en laat het aan het window weten.
	public void setSlideNumber(int number) {
		currentSlideNumber = number;
	}

	// Verwijder de presentatie, om klaar te zijn voor de volgende
	public void clear()
	{
		showList = new ArrayList<com.nhlstenden.strategy.Slide>();
		setSlideNumber(0);
	}

	// Voeg een slide toe aan de presentatie
	public void append(com.nhlstenden.strategy.Slide slide)
	{
		showList.add(slide);
	}

	// Geef een slide met een bepaald slidenummer
	public com.nhlstenden.strategy.Slide getSlide(int number)
	{
		if (number < 0 || number >= getSize())
		{
			return null;
		}
		return showList.get(number);
	}

	// Geef de huidige Slide
	public Slide getCurrentSlide()
	{
		return getSlide(currentSlideNumber);
	}

}
