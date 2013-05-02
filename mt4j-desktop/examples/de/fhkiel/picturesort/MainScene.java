package de.fhkiel.picturesort;

import org.mt4j.AbstractMTApplication;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;

public class MainScene extends AbstractScene {

	public MainScene(AbstractMTApplication mtApplication, String name) {
		super(mtApplication, name);
		
		MTColor keepColor = new MTColor(0,255,0);
		MTColor maybeColor = new MTColor(255,255,0);
		MTColor trashColor = new MTColor(255,0,0);

		CursorTracer c = new CursorTracer(mtApplication, this);
		registerGlobalInputProcessor(c);

		MTRectangle pictureListLayer = new MTRectangle(mtApplication, 0, (mtApplication.height - 230), mtApplication.width, 230);

		pictureListLayer.setEnabled(false);
		this.getCanvas().addChild(pictureListLayer);
		
		MTRectangle keepLayer = new MTRectangle(mtApplication, 40, 40, 230 , 450);
		keepLayer.setFillColor(keepColor);
		keepLayer.setEnabled(false);
		this.getCanvas().addChild(keepLayer);
		
		MTRectangle maybeLayer = new MTRectangle(mtApplication, 310, 40, 230 , 450);
		maybeLayer.setFillColor(maybeColor);
		maybeLayer.setEnabled(false);
		this.getCanvas().addChild(maybeLayer);
		
		MTRectangle trashLayer = new MTRectangle(mtApplication, 580, 40, 230 , 450);
		trashLayer.setFillColor(trashColor);
		trashLayer.setEnabled(false);
		this.getCanvas().addChild(trashLayer);
		
		
	}

	public void onEnter() {
	}

	public void onLeave() {
	}
}
