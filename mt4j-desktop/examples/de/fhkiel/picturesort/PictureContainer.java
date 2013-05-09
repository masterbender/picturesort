package de.fhkiel.picturesort;

import java.util.ArrayList;

import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.MTImage;
import org.mt4j.components.visibleComponents.widgets.MTTextField;
import org.mt4j.util.font.FontManager;

import processing.core.PApplet;

public class PictureContainer extends MTRectangle {

	ArrayList<MTImage> mtImageArray = new ArrayList<MTImage>();
	int offsetText = 5;
	int pictureNumber= 0;

	public PictureContainer(PApplet pApplet, float x, float y, float width,
			float height) {
		super(pApplet, x, y, width, height);

		MTTextField counterLabel = new MTTextField(pApplet, x + offsetText, y
				+ offsetText, 50, 30, FontManager.getInstance().createFont(
				pApplet, "SansSerif", 18));
		counterLabel.setText(""+pictureNumber);
		counterLabel.setNoFill(true);
		counterLabel.setNoStroke(true);
		counterLabel.setEnabled(false);
		super.addChild(counterLabel);

	}
	
	public void setPicturenumber(int value) {
		pictureNumber = value;
		
	}

	public ArrayList<MTImage> getMtImageArray() {
		return mtImageArray;
	}

	public void setMtImageArray(ArrayList<MTImage> mtImageArray) {
		this.mtImageArray = mtImageArray;
	}

	


}
