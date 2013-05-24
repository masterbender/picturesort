package de.fhkiel.test;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.mt4j.AbstractMTApplication;
import org.mt4j.MTApplication;
import org.mt4j.components.MTComponent;
import org.mt4j.components.PickResult;
import org.mt4j.components.TransformSpace;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.input.IMTInputEventListener;
import org.mt4j.input.inputData.MTInputEvent;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;

import processing.core.PImage;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import de.fhkiel.picturesort.SortImage;

public class Test extends MTApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = -521231864256214275L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initialize();

	}

	@Override
	public void startUp() {
		this.addScene(new MainScene(this, "Hauptfenster"));

	}

}

class MainScene extends AbstractScene {

	public MainScene(AbstractMTApplication mtApplication, String name) {
		super(mtApplication, name);

		CursorTracer c = new CursorTracer(mtApplication, this);
		registerGlobalInputProcessor(c);

		 MTRectangle dropzone = new MTRectangle(mtApplication, 200, 200);
		// dropzone.setPickable(true);
		dropzone.setFillColor(new MTColor(255, 0, 255));
		dropzone.setPositionGlobal(new Vector3D(400, 200, 0));
		dropzone.setName("dropzone");
		dropzone.removeAllGestureEventListeners();

		this.getCanvas().addChild(dropzone);

		final MTRectangle rect = new MTRectangle(mtApplication, 70, 70);
		rect.setName("test_rect");
		rect.addGestureListener(DragProcessor.class,
				new IGestureEventListener() {

					@Override
					public boolean processGestureEvent(MTGestureEvent ge) {

						switch (ge.getId()) {

						case MTGestureEvent.GESTURE_ENDED: {
							Vector3D location = ((DragEvent) ge).getTo();
							PickResult pr = getCanvas().pick(location.x,
									location.y);
							if(pr.getPickList().size() > 1) {
								System.out.println("nail");
								rect.destroy();
							}

						}
						}

						return false;
					}

				});

		this.getCanvas().addChild(rect);

		PImage temp = mtApplication.loadImage("01.png");
		final SortImage img = new SortImage(mtApplication, temp, null);
		img.setName("dd");
		
		img.addGestureListener(DragProcessor.class,
				new IGestureEventListener() {

			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {

				switch (ge.getId()) {

				case MTGestureEvent.GESTURE_ENDED: {
					Vector3D location = ((DragEvent) ge).getTo();
					PickResult pr = getCanvas().pick(location.x,
							location.y);
					if(pr.getPickList().size() > 1) {
						System.out.println("nail");
						img.destroy();
					}

				}
				}

				return false;
			}

		});
		
		this.getCanvas().addChild(img);
	}

}
