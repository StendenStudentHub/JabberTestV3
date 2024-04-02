package Factories;

/**
 * XMLAccessorFactory
 * <p>
 * Concrete factory of the AccesorFactory abstract factory pattern. It makes it
 * possible to read XML data.
 * </p>
 */

public class XMLAccessorFactory extends AccessorFactory {

	@Override
	public Reader CreateReader() {
		return new XMLReader();
	}

	@Override
	public Writer CreateWriter() {
		return new XMLWriter();
	}

}
