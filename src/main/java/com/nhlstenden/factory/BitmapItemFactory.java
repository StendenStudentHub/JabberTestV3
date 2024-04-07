package com.nhlstenden.factory;

import com.nhlstenden.strategy.BitmapItem;
import com.nhlstenden.strategy.SlideItem;

import java.io.IOException;

public class BitmapItemFactory extends SlideItemFactory
{

	@Override
	public SlideItem CreateSlideItem(int level, String content)
	{
		try
		{
			return new BitmapItem(level, content);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

}