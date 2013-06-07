package de.fhkiel.picturesort;

import java.util.List;
import org.mt4j.AbstractMTApplication;
import org.mt4j.components.PickResult;
import org.mt4j.components.PickResult.PickEntry;
import org.mt4j.components.visibleComponents.widgets.MTImage;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.util.math.Vector3D;
import de.fhkiel.picturesort.PictureContainer;

import processing.core.PImage;

public class SortImage extends MTImage {

	public PickResult pr;

	/**
	 * @param pApplet
	 * @param texture
	 * @param path
	 */
	public SortImage(final AbstractMTApplication pApplet, PImage texture,
			final String path) {
		super(pApplet, texture);

		this.addGestureListener(DragProcessor.class,
				new IGestureEventListener() {

					@Override
					public boolean processGestureEvent(MTGestureEvent ge) {

						switch (ge.getId()) {

						case MTGestureEvent.GESTURE_ENDED: {
							Vector3D location = ((DragEvent) ge).getTo();
							PickResult pr = pApplet.getScene("Main")
									.getCanvas().pick(location.x, location.y);

							List<PickEntry> underneathComponents = pr
									.getPickList();
							for (PickEntry pe : underneathComponents) {

								if (pe.hitObj.getName().equals("keepContainer")) {

									pApplet.invokeLater(new Runnable() {

										@Override
										public void run() {
											((PictureContainer) pApplet
													.getScene("Main")
													.getCanvas()
													.getChildByName(
															"keepContainer"))
													.addImagetoList(path);
											((PictureContainer) pApplet
													.getScene("Main")
													.getCanvas()
													.getChildByName(
															"keepContainer"))
													.updateNumber(pApplet);

										}

									});

									destroy();
								}
								if (pe.hitObj.getName()
										.equals("maybeContainer")) {

									pApplet.invokeLater(new Runnable() {

										@Override
										public void run() {
											((PictureContainer) pApplet
													.getScene("Main")
													.getCanvas()
													.getChildByName(
															"maybeContainer"))
													.addImagetoList(path);
											((PictureContainer) pApplet
													.getScene("Main")
													.getCanvas()
													.getChildByName(
															"maybeContainer"))
													.updateNumber(pApplet);
										}

									});

									destroy();
								}
								if (pe.hitObj.getName()
										.equals("trashContainer")) {
									pApplet.invokeLater(new Runnable() {

										@Override
										public void run() {
											((PictureContainer) pApplet
													.getScene("Main")
													.getCanvas()
													.getChildByName(
															"trashContainer"))
													.addImagetoList(path);
											((PictureContainer) pApplet
													.getScene("Main")
													.getCanvas()
													.getChildByName(
															"trashContainer"))
													.updateNumber(pApplet);
										}

									});
									destroy();
								}

							}
							return true;

						}
						}

						return false;
					}

				});

	}

}
