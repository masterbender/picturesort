package de.fhkiel.picturesort;

import org.mt4j.MTApplication;

public class StartPictureSort extends MTApplication{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2988017643658535797L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initialize();

	}
	
	@Override
	public void startUp() {
		addScene(new MainScene(this, "Main"));
	}

}
