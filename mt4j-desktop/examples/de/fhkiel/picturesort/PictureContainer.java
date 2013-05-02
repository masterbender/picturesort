package de.fhkiel.picturesort;

import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.MTTextField;
import org.mt4j.util.font.FontManager;

import processing.core.PApplet;

public class PictureContainer extends MTRectangle {

	int offsetText = 5;

	public PictureContainer(PApplet pApplet, float x, float y, float width,
			float height) {
		super(pApplet, x, y, width, height);

		MTTextField counterLabel = new MTTextField(pApplet, x + offsetText, y
				+ offsetText, 50, 30, FontManager.getInstance().createFont(
				pApplet, "SansSerif", 18));
		counterLabel.setText("0");
		counterLabel.setEnabled(false);
		super.addChild(counterLabel);

	}

}
