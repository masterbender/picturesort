package de.fhkiel.picturesort;

import org.mt4j.AbstractMTApplication;
import org.mt4j.util.MTColor;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;

public class MainScene extends AbstractScene {

	public MainScene(AbstractMTApplication mtApplication, String name) {
		super(mtApplication, name);

		MTColor red = new MTColor(255, 0, 0);
		MTColor green = new MTColor(0, 255, 0);
		MTColor blue = new MTColor(0, 0, 255);

		CursorTracer c = new CursorTracer(mtApplication, this);
		registerGlobalInputProcessor(c);

		/*
		 * init GUI Layout for Mainscene TOP = PicuterContainer BUTTOM =
		 * PictureLoader
		 */

		final PictureContainer keep = new PictureContainer(mtApplication, 50, 50,
				270, 500);
		keep.rect.setFillColor(green);
		keep.setName("keepContainer");
		
		this.getCanvas().addChild(keep);

		PictureContainer maybe = new PictureContainer(mtApplication, 380, 50,
				270, 500);
		maybe.rect.setFillColor(blue);
		maybe.setName("maybeContainer");
		
		this.getCanvas().addChild(maybe);
		
		PictureContainer trash = new PictureContainer(mtApplication, 708, 50,
				270, 500);
		trash.setName("trashContainer");
		trash.rect.setFillColor(red);
		
		this.getCanvas().addChild(trash);

		
		PictureLoader loader = new PictureLoader(mtApplication);
		this.getCanvas().addChild(loader);
		
		
		
		


	}


	public void onEnter() {
	}

	public void onLeave() {
	}
}
