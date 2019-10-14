package com.skilldistillery.tat;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class TrelloCsvFile {

	// F i e l d s

	private String fileName;
	private int errorCount;

	// C o n s t r u c t o r s

	public TrelloCsvFile(String fileName) {
		// ToDo: Write method - easy - 1 line?
		this.setFileName(fileName);
	}

	// M e t h o d s

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<Topic> getTopics(String pathName) {
		List<Topic> parsedTopics = new ArrayList<Topic>();
		try {
			Reader reader = Files.newBufferedReader(Paths.get(pathName + fileName));
			CSVParser csvParser = new CSVParser(reader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			for (CSVRecord csvRecord : csvParser) {
				// Accessing values by the names assigned to each column
				String topicName = csvRecord.get("Card Name");
				String instructors = csvRecord.get("Labels");
				String[] instructorArray = instructors.split(", ");
				List<String> instructorList = Arrays.asList(instructorArray);
				String date = csvRecord.get("List Name");

				Topic topic = new Topic(instructorList, date, topicName);
				parsedTopics.add(topic);
				System.out.println(topic);
//				System.out.println("Record No - " + csvRecord.getRecordNumber());
//				System.out.println("---------------");
//				System.out.println("Topic Name : " + topicName);
//				System.out.println("Instructors : " + Arrays.deepToString(instructorArray));
//				System.out.println("Date : " + date);
//				System.out.println("---------------\n\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return parsedTopics;
	}

	public Map<String, Integer> getInstructorTopicTallyMap(List<Topic> topics) {
		Map<String, Integer> tallyMap = new HashMap<String, Integer>();
		for (Topic topic : topics) {
			for (String instructor : topic.getInstructors()) {
				int count = tallyMap.containsKey(instructor) ? tallyMap.get(instructor) : 0;
				tallyMap.put(instructor, count + 1);
				
			}

		}
		return tallyMap;
	}

	@Override
	public String toString() {
		return "TrelloCsvFile [fileName=" + fileName + "]";
	}

}
