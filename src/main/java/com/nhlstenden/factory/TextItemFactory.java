package Factories;

import model.SlideItem;
import model.TextItem;

/**
 * StyelDefault
 * <p>
 * Text item Factory is the conrecte factory of the Abstract SlideItemFactory
 * and is used to create new slide items based on their level and their content.
 * </p>
 */

public class TextItemFactory extends SlideItemFactory {

	@Override
	public SlideItem CreateSlideItem(int level, String content) {
		return new TextItem(level, content);
	}

}
