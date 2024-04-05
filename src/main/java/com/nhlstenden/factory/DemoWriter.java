package com.nhlstenden.factory;

import com.nhlstenden.strategy.Presentation;

import java.io.IOException;


public abstract class DemoWriter extends Writer
{

	@Override
	public void Write(Presentation presentation, String filename) throws IOException
	{
		System.err.println("Unable to save the demo presentation");
	}

}
