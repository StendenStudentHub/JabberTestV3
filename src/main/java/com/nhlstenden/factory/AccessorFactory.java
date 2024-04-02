package Factories;

/**
 * AccesorFactory
 * <p>
 * The abstract factory that is used to create specific accessory factories
 * based on the file name.
 * </p>
 */
public abstract class AccessorFactory {
	public static AccessorFactory GetFactory(String fileName) {
		// check if we provided a file extension if not we just assume its the demo
		// presentation could also add error logic here say unsupported type...
		String fileExtension = fileName.contains(".") ? fileName.split("\\.")[1] : "";

		switch (fileExtension) {
		case "xml":
			return new XMLAccessorFactory();
		default:
			return new DemoAccesorFactory();
		}
	}

	public abstract Reader CreateReader();

	public abstract Writer CreateWriter();

}
