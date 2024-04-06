package com.nhlstenden.factory;

import com.nhlstenden.strategy.Presentation;

import java.io.IOException;
import java.util.logging.Logger;

public class DemoWriter extends Writer
{

	private static final Logger logger = Logger.getLogger(DemoWriter.class.getName());

	@Override
	public void Write(Presentation presentation, String filename) throws IOException
	{
		logger.severe("Unable to save the demo presentation");
	}
}
