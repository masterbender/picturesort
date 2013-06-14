package de.fhkiel.picturesort;

import java.util.ArrayList;

import org.mt4j.AbstractMTApplication;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.input.IMTInputEventListener;
import org.mt4j.input.inputData.MTInputEvent;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.math.Vector3D;

import processing.core.PImage;

public class ViewScene extends AbstractScene {

	public ViewScene( AbstractMTApplication mtApplication, String name,
			ArrayList<String> mtImageArray) {
		super(mtApplication, name);

		int xpos = 10;
		int ypos = 10;

		for (int i = 0; i < mtImageArray.size(); i++) {
			PImage temp = mtApplication.loadImage(mtImageArray.get(i));
			temp.resize(300, 320);
			SortImage imgtemp = new SortImage(mtApplication, temp,
					mtImageArray.get(i));
			imgtemp.setNoFill(true);
			imgtemp.setNoStroke(true);
			imgtemp.translateGlobal(new Vector3D(xpos, ypos, 0));
			imgtemp.removeAllGestureEventListeners();
			this.getCanvas().addChild(imgtemp);
			xpos += (300 + 20);

		}
		
		MTRectangle closeRect = new MTRectangle(mtApplication, 50, 50);
		closeRect.setName("close");
		closeRect.translateGlobal(new Vector3D(400,400,0));
		closeRect.addInputListener(new IMTInputEventListener() {
			
			@Override
			public boolean processInputEvent(MTInputEvent inEvt) {
				//TODO wieder dies scene wechseln
				return false;
			}
		});
		this.getCanvas().addChild(closeRect);
		
		
	}
}
