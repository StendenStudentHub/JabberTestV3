package com.nhlstenden.factory;

import com.nhlstenden.factory.PresentationFactory.SupportedPresentationTypes;
import com.nhlstenden.factory.SlideFactory.SupportedSlideTypes;
import com.nhlstenden.strategy.Presentation;
import com.nhlstenden.strategy.Slide;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;


public class XMLReader extends Reader {

	private static final Logger logger = Logger.getLogger(XMLReader.class.getName());


	protected static final String SHOWTITLE = "showtitle";
	protected static final String SLIDETITLE = "title";
	protected static final String SLIDE = "slide";
	protected static final String ITEM = "item";
	protected static final String LEVEL = "level";
	protected static final String KIND = "kind";

	protected static final String PCE = "Parser Configuration Exception";
	protected static final String NFE = "Number Format Exception";

	@Override
	public Presentation Read(String fileName) throws IOException
	{
		int slideNumber, itemNumber, max = 0, maxItems = 0;
		com.nhlstenden.strategy.Presentation presentation = PresentationFactory.GetFactory(SupportedPresentationTypes.REGULARPRESENTATION).CreatePresentation();
		try
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
			factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(fileName));
			Element doc = document.getDocumentElement();
			presentation.setTitle(getTitle(doc, SHOWTITLE));

			NodeList slides = doc.getElementsByTagName(SLIDE);
			max = slides.getLength();
			for (slideNumber = 0; slideNumber < max; slideNumber++)
			{
				Element xmlSlide = (Element) slides.item(slideNumber);
				Slide slide = SlideFactory.GetFactory(SupportedSlideTypes.ITEMSLIDE).CreateSLide();
				slide.setTitle(getTitle(xmlSlide, SLIDETITLE));
				presentation.append(slide);

				NodeList slideItems = xmlSlide.getElementsByTagName(ITEM);
				maxItems = slideItems.getLength();
				for (itemNumber = 0; itemNumber < maxItems; itemNumber++)
				{
					Element item = (Element) slideItems.item(itemNumber);
					loadSlideItem(slide, item);
				}
			}
		}
		catch (IOException iox)
		{
			logger.severe(iox.toString());
		}
		catch (SAXException sax)
		{
			logger.severe(sax.getMessage());
		}
		catch (ParserConfigurationException pcx)
		{
			logger.severe(PCE);
		}

		return presentation;
	}


	protected void loadSlideItem(Slide slide, Element item)
	{
		int level = 1; // default
		NamedNodeMap attributes = item.getAttributes();
		String leveltext = attributes.getNamedItem(LEVEL).getTextContent();
		if (leveltext != null)
		{
			try
			{
				level = Integer.parseInt(leveltext);
			}
			catch (NumberFormatException x)
			{
				logger.severe(NFE);
			}
		}
		String type = attributes.getNamedItem(KIND).getTextContent();
		slide.append(Objects.requireNonNull(SlideItemFactory.GetSlideItemFactory(type)).CreateSlideItem(level, item.getTextContent()));
	}

	private String getTitle(Element element, String tagName)
	{
		NodeList titles = element.getElementsByTagName(tagName);
		return titles.item(0).getTextContent();
	}
}
