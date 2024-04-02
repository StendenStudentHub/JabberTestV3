package com.nhlstenden.factory;

import com.nhlstenden.strategy.Presentation;

public class RegularPresentationFactory extends PresentationFactory
{
	@Override
	public Presentation CreatePresentation()
	{
		return new Presentation();
	}

}
