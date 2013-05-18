package de.fhkiel.picturesort;

import org.mt4j.components.PickResult;
import org.mt4j.components.visibleComponents.widgets.MTImage;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.util.math.Vector3D;

import processing.core.PApplet;
import processing.core.PImage;

public class SortImage extends MTImage{

	public SortImage(PApplet pApplet, PImage texture) {
		super(pApplet, texture);
		
	
		this.addGestureListener(DragProcessor.class,
				new IGestureEventListener() {

					@Override
					public boolean processGestureEvent(MTGestureEvent ge) {

						switch (ge.getId()) {

						case MTGestureEvent.GESTURE_ENDED: {
							Vector3D location = ((DragEvent) ge).getTo();
							PickResult pr = pick(location.x,
									location.y);
							pr.printList();
							if(pr.getPickList().size() > 1) {
								System.out.println("nail");
							}

						}
						}

						return false;
					}

				});
		
	}

	
}
