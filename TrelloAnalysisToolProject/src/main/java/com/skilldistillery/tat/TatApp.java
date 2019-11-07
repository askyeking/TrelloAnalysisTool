package com.skilldistillery.tat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TatApp {

	// ToDo: How the heck will this app work?
	//       All static methods? Not sure.
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		TrelloDir myDir = new TrelloDir("src/main/resources/2019/");
		System.out.println("Hello TAT World");
		// ToDo: Write this method and maybe others.
//		TrelloCsvFile newFile = new TrelloCsvFile("src/main/resources/SD16_Unit1.csv");
		System.out.println("Which Topic would you like to see?");
		String userTopic = kb.nextLine();
	}
	
	public Map<String, Integer> createDirectoryTopicsTallyMap(List<Topic> directoryTopics, String userTopic){
		Map<String, Integer> topicInstructorDistribution = new HashMap<>();
		for (Topic topic : directoryTopics) {
			if (topic.getTopicName().equalsIgnoreCase(userTopic)) {
				topic.getInstructors();
			}
		}
		return topicInstructorDistribution;
	}

}
