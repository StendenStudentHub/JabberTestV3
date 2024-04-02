package com.nhlstenden.factory;

import com.nhlstenden.strategy.Presentation;

import java.util.Objects;

public abstract class PresentationFactory
{

	public enum SupportedPresentationTypes
	{
		REGULARPRESENTATION
	}

	public static PresentationFactory GetFactory(SupportedPresentationTypes presentationType)
	{
		if (Objects.requireNonNull(presentationType) == SupportedPresentationTypes.REGULARPRESENTATION)
		{
			return new RegularPresentationFactory();
		}
		return new RegularPresentationFactory();
	}

	public abstract Presentation CreatePresentation();
}
