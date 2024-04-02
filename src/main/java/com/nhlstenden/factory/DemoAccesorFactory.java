package com.nhlstenden.factory;

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
