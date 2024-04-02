package com.nhlstenden.factory;

public class XMLAccessorFactory extends AccessorFactory
{

	@Override
	public Reader CreateReader()
	{
		return new XMLReader();
	}

	@Override
	public Writer CreateWriter()
	{
		return new XMLWriter();
	}

}
