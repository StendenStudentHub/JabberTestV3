package Factories;

import model.BitmapItem;
import model.SlideItem;

/**
 * BitmapitemFactory
 * <p>
 * Concrete factory of the SlideItem Abstract factory. Used to create bitmap items.
 * </p>
 */

public class BitmapItemFactory extends SlideItemFactory {

	@Override
	public SlideItem CreateSlideItem(int level, String content) {
		return new BitmapItem(level, content);
	}

}
