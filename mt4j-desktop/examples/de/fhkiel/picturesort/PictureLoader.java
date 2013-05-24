package de.fhkiel.picturesort;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import org.mt4j.AbstractMTApplication;
import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.buttons.MTImageButton;
import org.mt4j.input.IMTInputEventListener;
import org.mt4j.input.inputData.MTInputEvent;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;

import processing.core.PImage;

public class PictureLoader extends MTComponent {

	ArrayList<String> ListArray = new ArrayList<String>();
	JFileChooser fc;
	FileFilter filter;
	MTColor grey = new MTColor(105, 105, 105);
	// String loadFile = "load.jpg";
	int imageX = 150;
	int imageY = 650;

	// array of supported extensions (use a List if you prefer)
	static final String[] EXTENSIONS = new String[] { "gif", "png", "bmp" };
	// filter to identify images based on their extensions
	static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

		@Override
		public boolean accept(final File dir, final String name) {
			for (final String ext : EXTENSIONS) {
				if (name.endsWith("." + ext)) {
					return (true);
				}
			}
			return (false);
		}
	};

	public PictureLoader(final AbstractMTApplication pApplet) {
		super(pApplet);
		MTRectangle bottomLayer = new MTRectangle(pApplet, 0, 618, 1024, 150);
		bottomLayer.setFillColor(grey);
		bottomLayer.setPickable(false);
		bottomLayer.setName("buttomLayer");
		super.addChild(bottomLayer);

		fc = new JFileChooser();
		fc.setCurrentDirectory(new java.io.File(
				"/home/masterbender/git/picturesort/mt4j-desktop/examples/data/"));
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		// fc.addChoosableFileFilter(filter);

		PImage loadPhoto = pApplet.loadImage("load.jpg");
		MTImageButton loadButton = new MTImageButton(pApplet, loadPhoto);
		loadButton.setName("loadButton");
		loadButton.setSizeLocal(30, 30);
		loadButton.setNoStroke(true);
		loadButton.translateGlobal(new Vector3D(5, 622, 0));
		loadButton.addInputListener(new IMTInputEventListener() {

			@Override
			public boolean processInputEvent(MTInputEvent inEvt) {
				// TODO bug : open several times when click button
				int returnVal = fc.showOpenDialog(pApplet);

				if (returnVal == JFileChooser.APPROVE_OPTION) {

					File dir = fc.getSelectedFile();

					if (dir.isDirectory()) {
						for (File f : dir.listFiles(IMAGE_FILTER)) {

							addToFilelist(f, pApplet);

						}
					}
					printImage(pApplet);
					return true;
				} else {
					System.out.println("Open command cancelled by user.");
				}

				return false;

			}

		});

		bottomLayer.addChild(loadButton);

	}

	private void addToFilelist(File f, AbstractMTApplication pApplet) {
		//System.out.println(f.getAbsolutePath());
		// TODO loadimage only load from data dictonary ... neuen pfad einbinden
		//PImage temp = pApplet.loadImage(f.getAbsolutePath());
		//temp.resize(100, 120);
		//SortImage imgtemp = new SortImage(pApplet, temp, f);
		ListArray.add(f.getAbsolutePath());

	}

	private void printImage(AbstractMTApplication pApplet) {
		int xpos = 100;
		int ypos = 632;

		for (int i = 0; i < ListArray.size(); i++) {
			PImage temp = pApplet.loadImage(ListArray.get(i));
			temp.resize(100,200);
			SortImage imgtemp = new SortImage(pApplet, temp, ListArray.get(i));
			
			
			imgtemp.setNoFill(true);
			imgtemp.setNoStroke(true);
			imgtemp.translateGlobal(new Vector3D(xpos, ypos, 0));
			super.addChild(imgtemp);
			xpos += (100 + 20);
		}
	}

}
