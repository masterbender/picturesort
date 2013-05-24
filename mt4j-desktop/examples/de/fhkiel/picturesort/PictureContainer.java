package de.fhkiel.picturesort;

import java.util.ArrayList;

import org.mt4j.AbstractMTApplication;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;

import org.mt4j.components.visibleComponents.widgets.MTTextField;
import org.mt4j.util.font.FontManager;

public class PictureContainer extends MTRectangle {

	ArrayList<SortImage> mtImageArray = new ArrayList<SortImage>();
	int offsetText = 5;
	int pictureNumber = 0;

	public PictureContainer(AbstractMTApplication pApplet, float x, float y, float width,
			float height) {
		
		super(pApplet, x, y, width, height);
		this.removeAllGestureEventListeners();

		MTTextField counterLabel = new MTTextField(pApplet, x + offsetText, y
				+ offsetText, 50, 30, FontManager.getInstance().createFont(
				pApplet, "SansSerif", 18));
		counterLabel.setText("" + pictureNumber);
		counterLabel.setNoFill(true);
		counterLabel.setNoStroke(true);
		this.addChild(counterLabel);

	}

	public void setPicturenumber(int value) {
		pictureNumber = value;

	}

	public ArrayList<SortImage> getMtImageArray() {
		return mtImageArray;
	}


	public void addImagetoList(SortImage image) {
		mtImageArray.add(image);
	}
	
	public void removeImagefromList(SortImage image){
		mtImageArray.remove(image);
	}

}
