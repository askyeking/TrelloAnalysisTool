package com.skilldistillery.tat;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrelloDir {

	// F i e l d s
	
	// C o n s t r u c t o r s
	
	// M e t h o d s
	
	public List<TrelloCsvFile> getAllCsvFiles(String directoryPath) {
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
//<<<<<<< HEAD
//		
//		File folder = new File("src/main/resources");
//		File[] list = folder.listFiles();
//		for (File f : list) {
//			if (f.getName().endsWith(".csv")) {
//				result.add(new TrelloCsvFile(f.getName()));
//			}
//		}
//		
//=======
	
		File folder = new File(directoryPath);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				//code goes here
				TrelloCsvFile newCSV = new TrelloCsvFile(listOfFiles[i].getName());
				result.add(newCSV);
//				System.out.println(newCSV);
			}
			else if (listOfFiles[i].isDirectory()) {
				//code goes here
			}
		}
//>>>>>>> c2c7c83d9297fb99df85c2f08b70e25c5e3c5baa
		return result;
	}

}
