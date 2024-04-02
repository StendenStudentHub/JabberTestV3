package com.nhlstenden.factory;

import com.nhlstenden.strategy.SlideItem;
import com.nhlstenden.strategy.TextItem;

public class TextItemFactory extends SlideItemFactory
{
	@Override
	public SlideItem CreateSlideItem(int level, String content)
	{
		return new TextItem(level, content);
	}

}
