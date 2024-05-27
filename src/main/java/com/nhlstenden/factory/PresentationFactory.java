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
        Objects.requireNonNull(presentationType);
        return new RegularPresentationFactory();
	}

	public abstract Presentation CreatePresentation();
}
