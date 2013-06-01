package de.fhkiel.picturesort;

import java.util.ArrayList;

import org.mt4j.AbstractMTApplication;
import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.MTTextField;
import org.mt4j.input.IMTInputEventListener;
import org.mt4j.input.inputData.MTInputEvent;
import org.mt4j.util.MTColor;
import org.mt4j.util.font.FontManager;

public class PictureContainer extends MTComponent {

	ArrayList<String> mtImageArray = new ArrayList<String>();
	int offsetText = 5;
	int pictureNumber = 0;
	MTRectangle rect;
	MTColor text = new MTColor(113, 159, 166);

	public PictureContainer(final AbstractMTApplication pApplet, float x,
			float y, float width, float height, String name,
			MTColor containerColor) {

		super(pApplet);

		this.setName(name);
		MTRectangle rect = new MTRectangle(pApplet, x, y, width, height);
		rect.setName(name);
		rect.setFillColor(containerColor);
		rect.removeAllGestureEventListeners();
		this.removeAllGestureEventListeners();

		MTTextField counterLabel = new MTTextField(pApplet, x + offsetText, y
				+ offsetText, 50, 30, FontManager.getInstance().createFont(
				pApplet, "SansSerif", 18));
		counterLabel.setText("" + pictureNumber);
		counterLabel.setNoFill(true);
		counterLabel.setNoStroke(true);
		counterLabel.setFontColor(text);
		rect.addChild(counterLabel);
		this.addChild(rect);

		this.addInputListener(new IMTInputEventListener() {

			@Override
			public boolean processInputEvent(MTInputEvent inEvt) {
				pApplet.invokeLater(new Runnable() {

					@Override
					public void run() {

						pApplet.pushScene();
						ViewScene viewScene = null;

						if (viewScene == null) {
							viewScene = new ViewScene(pApplet, "ViewScene",
									mtImageArray);
							// Add the scene to the mt application
							pApplet.addScene(viewScene);
						}
						// Do the scene change
						pApplet.changeScene(viewScene);

					}

				});

				return false;
			}
		});

	}

	public void addImagetoList(String image) {
		mtImageArray.add(image);
		pictureNumber++;

	}

}
