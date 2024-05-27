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
        Objects.requireNonNull(slideType);
        return new ItemSlideFactory();
	}

	public abstract Slide CreateSLide();
}
