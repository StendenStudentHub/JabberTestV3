package Factories;

import model.Presentation;

/**
 * RegularPresentationFactory
 * <p>
 * concrete factory of the abstract presentation factory class. Which is used to
 * generate regular type of presentations.
 * </p>
 */

public class RegularPresentationFactory extends PresentationFactory {

	@Override
	public Presentation CreatePresentation() {
		return new Presentation();
	}

}
