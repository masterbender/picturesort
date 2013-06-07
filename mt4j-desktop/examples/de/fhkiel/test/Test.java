package de.fhkiel.test;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.mt4j.AbstractMTApplication;
import org.mt4j.MTApplication;
import org.mt4j.components.MTComponent;
import org.mt4j.components.PickResult;
import org.mt4j.components.TransformSpace;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.MTTextField;
import org.mt4j.input.IMTInputEventListener;
import org.mt4j.input.inputData.MTInputEvent;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;
import org.mt4j.util.font.FontManager;
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

	public MTRectangle rect;
	public MTTextField text;
	
	public MainScene(AbstractMTApplication mtApplication, String name) {
		super(mtApplication, name);

		 text =  new MTTextField(mtApplication, 10, 10, 100, 50, FontManager.getInstance().createFont(
				mtApplication, "SansSerif", 18));
		text.setText("Hallo");
		text.updateComponent(100);
		this.getCanvas().addChild(text);
		rect = new MTRectangle(mtApplication, 100, 100);
		rect.setName("muhh");
		rect.setFillColor(new MTColor(23, 23, 0));
		this.getCanvas().addChild(rect);
		

		updateColor(mtApplication);
		
		
	}

	public void updateColor(AbstractMTApplication mtApplication) {
		rect.setFillColor(new MTColor(255, 255, 0));
		text.setText("moethod");
		mtApplication.update(mtApplication.getGraphics());
		
	}

}
