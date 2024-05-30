package com.nhlstenden.factory;

import com.nhlstenden.strategy.SlideItem;
import java.util.logging.Logger;

public abstract class SlideItemFactory
{
	//Constants
	private static final Logger logger = Logger.getLogger(SlideItemFactory.class.getName());

	public static SlideItemFactory GetSlideItemFactory(String itemType)
	{
		switch (itemType)
		{
			case "text" ->
			{
				return new TextItemFactory();
			}
			case "image" ->
			{
				return new BitmapItemFactory();
			}
			default ->
			{
				logger.warning(itemType + " is not an existing item type, please check your xml for any non supported types");
				return null;
			}
		}
	}

	public abstract SlideItem CreateSlideItem(int level, String content);
}
