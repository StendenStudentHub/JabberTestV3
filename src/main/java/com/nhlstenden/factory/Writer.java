package Factories;

import java.io.IOException;

import model.Presentation;

/**
 * Writer
 * <p>
 * Abstract class used as base class for the different Writer Accessors.
 * </p>
 */

public abstract class Writer {
	public abstract void Write(Presentation presentation, String filename) throws IOException;
}
