package com.skilldistillery.tat;

import java.util.List;

public class Topic {

	// F i e l d s
	
	private List<String> instructors;
	private String dateStr; // This shouldn't be a String.
	private String topicName;
	
	// C o n s t r u c t o r
	// ToDo: Write constructor
	public Topic() {
		super();
	}
	
	public Topic(List<String> instructors, String dateStr, String topic) {
		super();
		this.instructors = instructors;
		this.dateStr = dateStr;
		this.topicName = topic;
	}

	// M e t h o d s
	
	// ToDo: Definitely add gets.
	// ToDo: Maybe add sets (maybe not).

	public List<String> getInstructors() {
		return instructors;
	}

	public String getDateStr() {
		return dateStr;
	}
	public String getTopicName() {
		return topicName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Topic instructors: ");
		for (String instructorName : instructors) {
			builder.append(instructorName);
		}
		builder.append(", dateStr: ")
		.append(dateStr)
		.append(", topic: ")
		.append(topicName);
		return builder.toString();
	}
	
	
	
	
	
}
