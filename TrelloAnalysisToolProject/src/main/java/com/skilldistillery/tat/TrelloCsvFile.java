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
	private String[] columnNames; //this is the first row of data from the CSV files, which contain the column names.
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
		List<Topic> result = new ArrayList<>();
		
		BufferedReader buffIn = null;
		try {
		  buffIn = new BufferedReader(new FileReader(pathName + fileName));
		  System.out.println(fileName);
		 
		  columnNames = buffIn.readLine().split(",");
		  if (columnNames.length == 19) {
			  readNinteen();
		  }
		  if (columnNames.length == 18) {
			  result = readEighteen(buffIn);
			  System.err.println("**********************" + columnNames.length);
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

	private List<Topic> readEighteen(BufferedReader buffIn) {
		String line;
		List<Topic> result = new ArrayList<Topic>();
		try {
			while ((line = buffIn.readLine()) != null) {
				  String[] currentLine =  line.split(",");
				  System.out.println(Arrays.deepToString(currentLine));
				  System.out.println("Current column length: " + currentLine.length);
				  //use if statement to test if currenetLine.length < 14.  if so, skip and move on to the next line
				  String[] topicInstructors = currentLine[3].split(",");
				  List<String> topicInstructorsList = Arrays.asList(topicInstructors);
				  String topicName;
				  String date;
				
					topicName = currentLine[1];
					  date = currentLine[14];
					  Topic newTopic = new Topic(topicInstructorsList, date, topicName);
					  result.add(newTopic);
				  System.out.println(newTopic);
				
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		return result;
	}

	private void readNinteen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "TrelloCsvFile [fileName=" + fileName + "]";
	}
	
	
}
