package com.skilldistillery.tat;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Topic {

	// F i e l d s
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "date_string")
	private String dateStr; // This shouldn't be a String.
	
	@ManyToMany(mappedBy = "topicsList")
	private List<String> instructors;
	
	@Column(name = "last_edit_date")
	private String lastEditDate;
	
	@Column(name = "name")
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
	//TODO: write add/removes
	
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
	public void setTopicName(String topic) {
		this.topicName = topic;
	}


	public Integer getMonth() {
		// ToDo: Write this code to get the integer month out of dateStr.
		
		return null; // Temp until code written
	}
	
	public Integer getYear() {
		// ToDo: Write this code to get the integer year out of dateStr.
		
		return null; // Temp until code written.
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
