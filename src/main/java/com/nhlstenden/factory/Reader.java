package com.nhlstenden.factory;

import com.nhlstenden.command.Presentation;

import java.io.IOException;


public abstract class Reader
{
	public abstract Presentation Read(String fileName) throws IOException;
}
