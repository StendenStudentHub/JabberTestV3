package com.nhlstenden.factory;

import com.nhlstenden.strategy.Presentation;

import java.io.IOException;

public class DemoAccesorFactory extends AccessorFactory
{

	@Override
	public Reader CreateReader()
	{
		return new DemoReader();
	}

	@Override
	public Writer CreateWriter()
	{
		return new DemoWriter();
	}

}
