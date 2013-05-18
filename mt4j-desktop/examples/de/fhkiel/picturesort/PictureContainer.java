package de.fhkiel.picturesort;

import java.util.ArrayList;

import org.mt4j.components.visibleComponents.shapes.MTRectangle;

import org.mt4j.components.visibleComponents.widgets.MTTextField;
import org.mt4j.input.IMTInputEventListener;
import org.mt4j.input.inputData.MTInputEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragEvent;
import org.mt4j.util.font.FontManager;

import processing.core.PApplet;

public class PictureContainer extends MTRectangle {

	ArrayList<SortImage> mtImageArray = new ArrayList<SortImage>();
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
		
		super.addChild(counterLabel);
		
		this.removeAllGestureEventListeners();
		
	
		

	}
	
	public void setPicturenumber(int value) {
		pictureNumber = value;
		
	}

	public ArrayList<SortImage> getMtImageArray() {
		return mtImageArray;
	}

	public void setMtImageArray(ArrayList<SortImage> mtImageArray) {
		this.mtImageArray = mtImageArray;
	}
	
	public void addImagetoList(SortImage image) {
		mtImageArray.add(image);
	}
	

	


}
