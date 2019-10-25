package com.skilldistillery.tat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TrelloDir {

	// F i e l d s
	private String directoryPath;

	// C o n s t r u c t o r s
	public TrelloDir(String directoryPath) {
		super();
		this.directoryPath = directoryPath;
	}
	// M e t h o d s

	public List<TrelloCsvFile> getAllCsvFiles() {
		List<TrelloCsvFile> result = new ArrayList<>();

		File folder = new File(directoryPath);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				// code goes here
				TrelloCsvFile newCSV = new TrelloCsvFile(directoryPath + listOfFiles[i].getName());
				newCSV.setFileName(directoryPath + listOfFiles[i].getName());
				result.add(newCSV);
//				System.out.println(newCSV);
			} else if (listOfFiles[i].isDirectory()) {
				// code goes here
			}
		}
		return result;
	}

	public List<TrelloCsvFile> getAllCsvFilesByMonth(String month) {
		List<TrelloCsvFile> csvFiles = getAllCsvFiles();
		List<TrelloCsvFile> filesByMonth = new ArrayList<TrelloCsvFile>();
		for (TrelloCsvFile csv : csvFiles) {
			//stuff Emily did 10/24 AM
			List<Topic> topics = csv.getTopics();
			for (Topic topic : topics) {
				if (topic.getDateStr().contains(month)) { 
					// see https://www.geeksforgeeks.org/enummap-class-java-example/
					//should we have an EnumMap class:
					//public enum Month {Jan, Feb, Mar, Apr, May, ... }
					// EnumMap<Month, String> monthMap = new EnumMap<Month, String>(Month.class)
					// where String values for Jan (for example) are "1", "Jan", "January", etc
					// we can then retrieve the key from the value given from the user.
					filesByMonth.add(csv);
				}
			}
			//end stuff Emily did 10/24 AM
//			if (csv.get)
		}
		return filesByMonth;
	}
}
