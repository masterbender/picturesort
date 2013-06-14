package de.fhkiel.picturesort;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import org.mt4j.AbstractMTApplication;
import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.buttons.MTImageButton;
import org.mt4j.input.IMTInputEventListener;
import org.mt4j.input.inputData.MTInputEvent;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;
import processing.core.PImage;

/**
 * @author masterbender
 * 
 */
public class PictureLoader extends MTComponent {

	public ArrayList<String> mtListArray = new ArrayList<String>();
	private JFileChooser fc;
	private MTColor grey = new MTColor(42, 61, 63);
	private MTImageButton loadButton;
	private PictureExport exp = new PictureExport();

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

	/**
	 * @param pApplet
	 *            Constructor for Picture Loader
	 */
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
		loadButton = new MTImageButton(pApplet, loadPhoto);
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
					returnVal = -1;
					return true;
				} else {
					System.out.println("Open command cancelled by user.");
				}
				return false;
			}
		});
		bottomLayer.addChild(loadButton);
		if ((mtListArray = exp.getImport()) != null) {
			printImage(pApplet);
		}
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				exp.updateStatus(mtListArray);

			}
		}));

	}

	/**
	 * @param f
	 * @param pApplet
	 *            add Filepath from image to Array List
	 */
	private void addToFilelist(File f, AbstractMTApplication pApplet) {
		mtListArray.add(f.getAbsolutePath());
	}

	/**
	 * @param pApplet
	 *            printing formatet images in a row below the screen
	 */
	private void printImage(AbstractMTApplication pApplet) {
		int xpos = 100;
		int ypos = 632;
		for (int i = 0; i < mtListArray.size(); i++) {
			PImage temp = pApplet.loadImage(mtListArray.get(i));
			temp.resize(100, 120);
			SortImage imgtemp = new SortImage(pApplet, temp, mtListArray.get(i));
			imgtemp.setNoFill(true);
			imgtemp.setNoStroke(true);
			imgtemp.translateGlobal(new Vector3D(xpos, ypos, 0));
			super.addChild(imgtemp);
			xpos += (100 + 20);
		}
	}
}
