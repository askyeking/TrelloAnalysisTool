package com.skilldistillery.tat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public List<Topic> getAllCsvFilesByMonth(String month) {
		List<TrelloCsvFile> csvFiles = getAllCsvFiles();
		List<Topic> topicsByMonth = new ArrayList<Topic>();
		for (TrelloCsvFile csv : csvFiles) {
			//stuff Emily did 10/24 AM
			List<Topic> topics = csv.getTopics();
			Pattern pitterPattern = Pattern.compile("\\s(\\d{1,2})[\\/]");
			for (Topic topic : topics) {
				Matcher matcher = pitterPattern.matcher(topic.getDateStr());
				String topicMonth;
				if(matcher.find()) {
					topicMonth = matcher.group(1);
					if (topicMonth.equals(month)) {
						topicsByMonth.add(topic);
					}
				}
//				
			}
		
		}
		return topicsByMonth;
	}

	public String getDirectoryPath() {
		return directoryPath;
	}
}
