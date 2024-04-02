package Factories;

import java.io.IOException;

import model.Presentation;

/**
 * Reader
 * <p>
 * Abstract class used as base class for the different Reader Accessors.
 * </p>
 */

public abstract class Reader {
	public abstract Presentation Read(String fileName) throws IOException;
}
