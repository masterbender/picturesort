package de.fhkiel.picturesort;

import org.mt4j.AbstractMTApplication;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;

public class MainScene extends AbstractScene {

	public MainScene(AbstractMTApplication mtApplication, String name) {
		super(mtApplication, name);

		CursorTracer c = new CursorTracer(mtApplication, this);
		registerGlobalInputProcessor(c);

		MTRectangle rect = new MTRectangle(mtApplication, 0, 0, 50, 50);


		this.getCanvas().addChild(rect);
	}

	public void onEnter() {
	}

	public void onLeave() {
	}
}
