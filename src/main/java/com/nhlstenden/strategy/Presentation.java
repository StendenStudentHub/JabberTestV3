package com.nhlstenden.strategy;

import java.util.ArrayList;

/**
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
	private String showTitle;
	private ArrayList<Slide> showList = null;
	private int currentSlideNumber = 0;

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

	public int getSlideNumber()
	{
		return currentSlideNumber;
	}

	public void setSlideNumber(int number) {
		currentSlideNumber = number;
	}

	public void clear()
	{
		showList = new ArrayList<Slide>();
		setSlideNumber(0);
	}
	public void append(com.nhlstenden.strategy.Slide slide)
	{
		showList.add(slide);
	}

	public Slide getSlide(int number)
	{
		if (number < 0 || number >= getSize())
		{
			return null;
		}
		return showList.get(number);
	}

	public Slide getCurrentSlide()
	{
		return getSlide(currentSlideNumber);
	}

}
