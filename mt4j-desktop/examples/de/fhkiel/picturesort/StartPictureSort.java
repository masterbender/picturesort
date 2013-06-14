package de.fhkiel.picturesort;

import org.mt4j.MTApplication;

/**
 * @author masterbender
 * cant get rid of warning ...
 */
public class StartPictureSort extends MTApplication{
	private static final long serialVersionUID = 2988017643658535797L;

	public static void main(String[] args) {
		initialize();
		

	}	
	@Override
	public void startUp() {
		addScene(new MainScene(this, "Main"));
	}
}
