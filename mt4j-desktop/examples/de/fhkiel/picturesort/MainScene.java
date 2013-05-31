package de.fhkiel.picturesort;

import org.mt4j.AbstractMTApplication;
import org.mt4j.util.MTColor;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.sceneManagement.IPreDrawAction;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;

public class MainScene extends AbstractScene {

	public MainScene(AbstractMTApplication mtApplication, String name) {
		super(mtApplication, name);

		MTColor containerColor = new MTColor(7, 44, 49);

		CursorTracer c = new CursorTracer(mtApplication, this);
		registerGlobalInputProcessor(c);


		PictureContainer keep = new PictureContainer(mtApplication, 50, 50,
				270, 500, "keepContainer", containerColor);
		
		this.getCanvas().addChild(keep);
		
		PictureContainer maybe = new PictureContainer(mtApplication, 380, 50,
				270, 500, "maybeContainer", containerColor);

		
		this.getCanvas().addChild(maybe);
		
		PictureContainer trash = new PictureContainer(mtApplication, 708, 50,
				270, 500, "trashContainer", containerColor);

		
		this.getCanvas().addChild(trash);

		
		PictureLoader loader = new PictureLoader(mtApplication);
		this.getCanvas().addChild(loader);
		
		

	}


	public void onEnter() {
	}

	public void onLeave() {
	}



}
