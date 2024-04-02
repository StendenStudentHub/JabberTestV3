package Factories;

import model.Slide;

/**
 * ItemSlideFactory
 * <p>
 * This is the concrete factory of the abstract SlideFactory pattern. It is used
 * to load a slide based on different slide items.
 * </p>
 */

public class ItemSlideFactory extends SlideFactory {

	@Override
	public Slide CreateSLide() {
		return new Slide();
	}

}
