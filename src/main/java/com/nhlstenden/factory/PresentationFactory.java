package Factories;

import model.Presentation;

/**
 * PresentationFactory
 * <p>
 * Abstract factory to create different types of presentation factory based on a
 * specific type.
 * </p>
 */

public abstract class PresentationFactory {

	public enum SupportedPresentationTypes {
		REGULARPRESENTATION
	}

	public static PresentationFactory GetFactory(SupportedPresentationTypes presentationType) {
		switch (presentationType) {
		case REGULARPRESENTATION:
			return new RegularPresentationFactory();
		default:
			return new RegularPresentationFactory();
		}
	}

	public abstract Presentation CreatePresentation();
}
