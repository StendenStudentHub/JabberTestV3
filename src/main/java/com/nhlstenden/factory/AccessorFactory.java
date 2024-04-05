package com.nhlstenden.factory;

public abstract class AccessorFactory
{
	public static AccessorFactory GetFactory(String fileName)
	{
		// check if we provided a file extension if not we just assume its the demo
		String fileExtension = fileName.contains(".") ? fileName.split("\\.")[1] : "";

		if (fileExtension.equals("xml"))
		{
			return new XMLAccessorFactory();
		}
		return new DemoAccesorFactory();
	}

	public abstract Reader CreateReader();

	public abstract Writer CreateWriter();

}
