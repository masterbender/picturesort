package de.fhkiel.picturesort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PictureExport {

	/**
	 * @return ArrayList<string> List contains Picture Path read the files form
	 *         export.txt to set up the last application session
	 */
	public ArrayList<String> getImport() {
		BufferedReader br = null;
		ArrayList<String> tempList = new ArrayList<String>();
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("export.txt"));
			while ((sCurrentLine = br.readLine()) != null) {
				tempList.add(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return tempList;
	}

	/**
	 * @param writeList
	 *            Updates the export.txt with pictures used in application
	 */
	public void updateStatus(ArrayList<String> writeList) {
		try {

			File file = new File("export.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < writeList.size(); i++) {
				bw.write(writeList.get(i) + "\n");
			}
			bw.close();
			System.out.println("Done saving...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
