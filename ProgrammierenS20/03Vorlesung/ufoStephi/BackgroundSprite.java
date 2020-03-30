package ufoStephi;

import view.IBackground;

public class BackgroundSprite implements IBackground {

	private String imagePath;
	
	public BackgroundSprite(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String getImagePath() {
		return imagePath;
	}

}
