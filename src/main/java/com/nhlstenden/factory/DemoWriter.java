package Factories;

import java.io.IOException;

import model.Presentation;

/**
 * DemoWriter
 * <p>
 * This class is used to save a demo file, which is not possible.
 * </p>
 */

public class DemoWriter extends Writer {

	@Override
	public void Write(Presentation presentation, String filename) throws IOException {
		System.err.println("Unable to save the demo presentation");
	}

}
