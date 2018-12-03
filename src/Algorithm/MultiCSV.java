package Algorithm;


import java.io.File;
import java.io.IOException;

import GIS.csvWriter;


public class MultiCSV {
	public static void displayDirectoryContents(File dir) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.getName().endsWith(".csv")) {
					csvWriter.writeCsvFile("4444.csv");
					displayDirectoryContents(file);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
