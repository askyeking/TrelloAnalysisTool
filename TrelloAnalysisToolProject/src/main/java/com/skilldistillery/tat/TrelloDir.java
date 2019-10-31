package com.skilldistillery.tat;

import java.awt.Choice;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrelloDir {

	// F i e l d s
	private String directoryPath;
	HashSet<String> instructorNames = new HashSet<String>();

	// C o n s t r u c t o r s
	public TrelloDir(String directoryPath) {
		super();
		this.directoryPath = directoryPath;

		for (Instructor instructor : Instructor.values()) {
			instructorNames.add(instructor.name());
		}
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

	public List<Topic> getAllTopicsByMonth(String month) {
		List<TrelloCsvFile> csvFiles = getAllCsvFiles();
		List<Topic> topicsByMonth = new ArrayList<Topic>();
		for (TrelloCsvFile csv : csvFiles) {
			List<Topic> topics = csv.getTopics();
			Pattern pitterPattern = Pattern.compile("\\s(\\d{1,2})[\\/]"); // finds month by number
			for (Topic topic : topics) {
				Matcher matcher = pitterPattern.matcher(topic.getDateStr());
				String topicMonth;
				if (matcher.find()) {
					topicMonth = matcher.group(1);
					if (topicMonth.equals(month)) {
						topicsByMonth.add(topic);
					}
				}
			}
		}
		return topicsByMonth;
	}

	public Map<String, Integer> getInstructorTopicTallyMapByMonth(String month, List<Topic> topics) {
		// Some CSV files are missing some dates
		Map<String, Integer> tallyMap = new HashMap<String, Integer>();
		int count = 0;
		for (Topic topic : topics) {
			for (String instructor : topic.getInstructors()) {
				if (instructorNames.contains(instructor)) {
					int tally = tallyMap.containsKey(instructor) ? tallyMap.get(instructor) : 0;
					tallyMap.put(instructor, tally + 1);
					count++;
				}
			}
		}
		tallyMap.put("totalTallies", count);
		return tallyMap;
	}

	public String getDirectoryPath() {
		return directoryPath;
	}
}
