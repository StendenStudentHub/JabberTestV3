package com.nhlstenden.factory;

import com.nhlstenden.strategy.Presentation;

import java.io.IOException;

public abstract class Writer
{
	public abstract void Write(Presentation presentation, String filename) throws IOException;
}
