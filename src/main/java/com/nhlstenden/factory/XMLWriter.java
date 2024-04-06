package com.nhlstenden.factory;

import com.nhlstenden.strategy.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.Logger;

public class XMLWriter extends Writer
{

	private static final Logger logger = Logger.getLogger(XMLWriter.class.getName());

	@Override
	public void Write(Presentation presentation, String filename) throws IOException
	{
		PrintWriter out = new PrintWriter(new FileWriter(filename));
		out.println("<?xml version=\"1.0\"?>");
		out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
		out.println("<presentation>");
		out.print("<showtitle>");
		out.print(presentation.getTitle());
		out.println("</showtitle>");
		for (int slideNumber = 0; slideNumber < presentation.getSize(); slideNumber++)
		{
			Slide slide = presentation.getSlide(slideNumber);
			out.println("<slide>");
			out.println("<title>" + slide.getTitle() + "</title>");
			Vector<SlideItem> slideItems = slide.getSlideItems();
			for (int itemNumber = 0; itemNumber < slideItems.size(); itemNumber++)
			{
				SlideItem slideItem = slideItems.elementAt(itemNumber);
				out.print("<item kind=");
				if (slideItem instanceof TextItem)
				{
					out.print("\"text\" level=\"" + slideItem.getLevel() + "\">");
					out.print(((TextItem) slideItem).getText());
				}
				else
				{
					if (slideItem instanceof BitmapItem)
					{
						out.print("\"image\" level=\"" + slideItem.getLevel() + "\">");
						out.print(((BitmapItem) slideItem).getImageName());
					}
					else
					{
						logger.warning("Ignoring " + slideItem);
					}
				}
				out.println("</item>");
			}
			out.println("</slide>");
		}
		out.println("</presentation>");
		out.close();
	}
}
