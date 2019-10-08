package com.skilldistillery.tat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TrelloDir {

	// F i e l d s
	
	// C o n s t r u c t o r s
	
	// M e t h o d s
	
	public List<TrelloCsvFile> getAllCsvFiles() {
		List<TrelloCsvFile> result = new ArrayList<>();
		
		// ToDo: Write the code for this method here.

		/* An idea from StackOverflow
		File folder = new File("your/path");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
		*/
		
		File folder = new File("src/main/resources");
		File[] list = folder.listFiles();
		for (File f : list) {
			if (f.getName().endsWith(".csv")) {
				result.add(new TrelloCsvFile(f.getName()));
			}
		}
		
		return result;
	}

}
