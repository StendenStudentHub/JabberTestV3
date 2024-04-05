package com.nhlstenden.factory;

import com.nhlstenden.command.Presentation;

import java.io.IOException;

public abstract class Writer
{
	public abstract void Write(Presentation presentation, String filename) throws IOException;

	public abstract void Write(com.nhlstenden.strategy.Presentation presentation, String filename) throws IOException;
}
