package com.skilldistillery.tat;

import java.util.List;

public class Topic {

	// F i e l d s
	
	private List<String> instructors;
	private String dateStr; // This shouldn't be a String.
	private String topic;
	
	// C o n s t r u c t o r
	// ToDo: Write constructor
	public Topic() {
		super();
	}
	
	

	public Topic(List<String> instructors, String dateStr, String topic) {
		super();
		this.instructors = instructors;
		this.dateStr = dateStr;
		this.topic = topic;
	}



	// M e t h o d s
	
	// ToDo: Definitely add gets.
	// ToDo: Maybe add sets (maybe not).

	public List<String> getInstructors() {
		return instructors;
	}

	public void setInstructors(List<String> instructors) {
		this.instructors = instructors;
	}

	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}


	public int getMonth() {
		// ToDo: Write this code to get the integer month out of dateStr.
		
		return 1; // Temp until code written
	}
	
	public int getYear() {
		// ToDo: Write this code to get the integer year out of dateStr.
		
		return 2019; // Temp until code written.
	}

	@Override
	public String toString() {
		return "Topic [instructors=" + instructors + ", dateStr=" + dateStr + ", topic=" + topic + "]";
	}
	
	
	
	
	
}
