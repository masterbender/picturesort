package de.fhkiel.picturesort;

import org.mt4j.AbstractMTApplication;
import org.mt4j.util.MTColor;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;

public class MainScene extends AbstractScene {

	public MainScene(AbstractMTApplication mtApplication, String name) {
		super(mtApplication, name);

		MTColor red = new MTColor(255, 0, 0);
		MTColor green = new MTColor(0, 255, 0);
		MTColor blue = new MTColor(0, 0, 255);
		MTColor grey = new MTColor(105, 105, 105);

		CursorTracer c = new CursorTracer(mtApplication, this);
		registerGlobalInputProcessor(c);

		/*
		 * init GUI Layout for Mainscene TOP = PicuterContainer BUTTOM =
		 * PictureLoader
		 */

		PictureContainer keep = new PictureContainer(mtApplication, 50, 50,
				270, 500);
		keep.setFillColor(green);
		keep.setEnabled(false);
		this.getCanvas().addChild(keep);

		PictureContainer maybe = new PictureContainer(mtApplication, 380, 50,
				270, 500);
		maybe.setFillColor(blue);
		maybe.setEnabled(false);
		this.getCanvas().addChild(maybe);
		PictureContainer trash = new PictureContainer(mtApplication, 708, 50,
				270, 500);
		trash.setFillColor(red);
		trash.setEnabled(false);
		this.getCanvas().addChild(trash);

		/*
		 * drawing buttom Container for Picture Loader
		 */
		MTRectangle bottomLayer = new MTRectangle(mtApplication, 0, 618, 1024,
				150);
		bottomLayer.setFillColor(grey);
		bottomLayer.setEnabled(false);

		this.getCanvas().addChild(bottomLayer);
	}

	public void onEnter() {
	}

	public void onLeave() {
	}
}
