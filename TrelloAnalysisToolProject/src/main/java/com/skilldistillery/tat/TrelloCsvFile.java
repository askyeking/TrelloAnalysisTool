package com.skilldistillery.tat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrelloCsvFile {

	// F i e l d s
	
	private String fileName;
	
	
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

	public List<Topic> getTopics() {
		List<Topic> result = new ArrayList<>();
		
		BufferedReader buffIn = null;
		try {
		  buffIn = new BufferedReader(new FileReader("src/main/resources/" + fileName));
		  String line;
		  line = buffIn.readLine(); //to avoid the first row of the csv file - they're just labels
		  while ((line = buffIn.readLine()) != null) {
			  String[] currentLine =  line.split(",");
			  System.out.println(Arrays.deepToString(currentLine));
			  System.out.println("Current line length: " + currentLine.length);
			  String[] topicInstructors = currentLine[3].split(",");
			  List<String> topicInstructorsList = Arrays.asList(topicInstructors);
			  String topicName = currentLine[1];
			  String date = currentLine[14];
			  
			  Topic newTopic = new Topic(topicInstructorsList, date, topicName);
			  result.add(newTopic);
			  
		  }
		}
		catch (IOException e) {
		  System.err.println(e);
		}
		finally {
		  if (buffIn != null) {
		    try {
		      buffIn.close();
		    }
		    catch (IOException e) {
		      System.err.println(e);
		    }
		  }
		}
		
		// ToDo: Read the file, fill in the List
		//       This might use more methods in this class - private
		//       methods.
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		return result;
	}
	
}
