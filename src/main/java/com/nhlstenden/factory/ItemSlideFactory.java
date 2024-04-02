package com.nhlstenden.factory;

import com.nhlstenden.strategy.Slide;


public class ItemSlideFactory extends SlideFactory
{
	@Override
	public Slide CreateSLide()
	{
		return new Slide();
	}

}
