package Factories;

import model.Slide;

/**
 * SlideFactory
 * <p>
 * Slide factory is an abstract factory used to create different type of Slide's
 * based on a SlideType.
 * </p>
 */

public abstract class SlideFactory {

	public enum SupportedSlideTypes {
		ITEMSLIDE
	}

	public static SlideFactory GetFactory(SupportedSlideTypes slideType) {
		switch (slideType) {
		case ITEMSLIDE:
			return new ItemSlideFactory();
		default:
			return new ItemSlideFactory();
		}
	}

	public abstract Slide CreateSLide();
}
