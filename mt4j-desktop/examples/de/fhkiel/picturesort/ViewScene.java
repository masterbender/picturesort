package de.fhkiel.picturesort;

import java.util.ArrayList;

import org.mt4j.AbstractMTApplication;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.math.Vector3D;

import processing.core.PImage;

/**
 * @author masterbender
 * 
 */
public class ViewScene extends AbstractScene {

	/**
	 * @param mtApplication
	 * @param name
	 * @param mtImageArray
	 *            viewscene Constructor generates a scene with pictures listed
	 *            in mtImageArray
	 */
	public ViewScene(AbstractMTApplication mtApplication, String name,
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
	}
}
