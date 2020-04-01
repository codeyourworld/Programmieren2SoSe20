package ufoStephi;

import view.IBackground;

/**
 * Represents the background image
 * @author Stephi
 * @version 1.0
 */
public class Background implements IBackground {

	private String imagePath;
	
	public Background(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String getImagePath() {
		return imagePath;
	}

}
