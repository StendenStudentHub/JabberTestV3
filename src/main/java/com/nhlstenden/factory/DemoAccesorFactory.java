package Factories;

/**
 * DemoAccesorFacotry
 * <p>
 * Concrete factory of the AccesorFactory abstract factory pattern. It makes it
 * possible to read demo data.
 * </p>
 */

public class DemoAccesorFactory extends AccessorFactory {

	@Override
	public Reader CreateReader() {
		return new DemoReader();
	}

	@Override
	public Writer CreateWriter() {
		return new DemoWriter();
	}

}
