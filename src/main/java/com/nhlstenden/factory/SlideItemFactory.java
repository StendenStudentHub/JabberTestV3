package Factories;

import model.SlideItem;

/**
 * SlideItemFactory
 * <p>
 * Abstract factory used to create different slide items based on their specific
 * itemType.
 * </p>
 */

public abstract class SlideItemFactory {

	public static SlideItemFactory GetSlideItemFactory(String itemType) {
		switch (itemType) {
		case "text":
			return new TextItemFactory();
		case "image":
			return new BitmapItemFactory();
		default:
			System.err.println(
					itemType + "is not an exisitng item type, please check your xml for any non supported types");
			return null;
		}
	}

	public abstract SlideItem CreateSlideItem(int level, String content);

}
