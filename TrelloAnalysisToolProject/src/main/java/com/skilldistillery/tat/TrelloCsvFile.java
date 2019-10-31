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
	//TODO: add a pathname as a field and include it in the constructor. refactor the methods to reflect this. also get rid of setters
	private String pathAndFileName;
	private int errorCount;
	private String startDate;
	private String endDate;
	
	// C o n s t r u c t o r s

	public TrelloCsvFile(String pathAndFileName) {
		// ToDo: Write method - easy - 1 line?
		this.pathAndFileName = pathAndFileName;
	}

	// M e t h o d s
	public String getFileName() {
		return fileName;
	}
	
	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setFileName(String fileName) {
		/*if we wanted to use the whole path name as the fileName, 
		the user would have to type the path twice (once for the Directory 
		constructor, and another time for directory's getCsvFiles() method call
		 * I thought that would be prone to typos so I split them into the path + fileName
		 * (so now, the user would have to input the path name once, and input the actual csv file name when calling getCsvFiles())
		 * The setter is required to set this combination of path+fileName to be the actual filename so the tests run successfully
		 */
		
		this.fileName = fileName;
	}

	public String getPathAndFileName() {
		return pathAndFileName;
	}

	public List<Topic> getTopics() {
		List<Topic> parsedTopics = new ArrayList<Topic>();
		try {
			Reader reader = Files.newBufferedReader(Paths.get(pathAndFileName));
			CSVParser csvParser = new CSVParser(reader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			for (CSVRecord csvRecord : csvParser) {
				// Accessing values by the names assigned to each column
				String topicName = csvRecord.get("Card Name");
				String instructors = csvRecord.get("Labels");
				String[] instructorArray = instructors.split("\\s\\([^\\)]+\\)[,]?");
				List<String> instructorList = Arrays.asList(instructorArray);
				String date = csvRecord.get("List Name");

				Topic topic = new Topic(instructorList, date, topicName);
				parsedTopics.add(topic);
//				System.out.println(topic);
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
	public Map<String, Integer> getInstructorTopicTallyMapByMonth(String month, List<Topic> topics) {
		// Some CSV files are missing some dates
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
