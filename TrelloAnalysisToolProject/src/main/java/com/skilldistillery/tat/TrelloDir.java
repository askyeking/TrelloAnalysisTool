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
		

		File folder = new File(directoryPath);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				//code goes here
				TrelloCsvFile newCSV = new TrelloCsvFile(directoryPath, listOfFiles[i].getName());
				result.add(newCSV);
//				System.out.println(newCSV);
			}
			else if (listOfFiles[i].isDirectory()) {
				//code goes here
			}
		}
		return result;
	}

}
