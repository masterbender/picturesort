package de.fhkiel.picturesort;

import java.util.ArrayList;

import org.mt4j.AbstractMTApplication;
import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;

import org.mt4j.components.visibleComponents.widgets.MTTextField;
import org.mt4j.util.font.FontManager;

public class PictureContainer extends MTComponent {

	ArrayList<String> mtImageArray = new ArrayList<String>();
	int offsetText = 5;
	int pictureNumber = 0;
	MTRectangle rect;

	public PictureContainer(AbstractMTApplication pApplet, float x, float y, float width,
			float height) {
		
		super(pApplet);
		MTRectangle rect = new MTRectangle(pApplet, x,y, width, height);
		rect.removeAllGestureEventListeners();
		this.removeAllGestureEventListeners();

		MTTextField counterLabel = new MTTextField(pApplet, x + offsetText, y
				+ offsetText, 50, 30, FontManager.getInstance().createFont(
				pApplet, "SansSerif", 18));
		counterLabel.setText("" + pictureNumber);
		counterLabel.setNoFill(true);
		counterLabel.setNoStroke(true);
		rect.addChild(counterLabel);
		this.addChild(rect);

	}

	public void setPicturenumber(int value) {
		pictureNumber = value;

	}

	public ArrayList<SortImage> getMtImageArray() {
		return null;
	}


	public void addImagetoList(String image) {
		mtImageArray.add(image);
	}
	
	public void removeImagefromList(String image){
		mtImageArray.remove(image);
	}

}
