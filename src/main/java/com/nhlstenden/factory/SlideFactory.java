package com.nhlstenden.factory;

import com.nhlstenden.strategy.Slide;

import java.util.Objects;

public abstract class SlideFactory
{

	public enum SupportedSlideTypes
	{
		ITEMSLIDE
	}

	public static SlideFactory GetFactory(SupportedSlideTypes slideType)
	{
		if (Objects.requireNonNull(slideType) == SupportedSlideTypes.ITEMSLIDE)
		{
			return new ItemSlideFactory();
		}
		return new ItemSlideFactory();
	}

	public abstract Slide CreateSLide();
}
