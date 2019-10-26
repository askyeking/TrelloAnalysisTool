package com.skilldistillery.tat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PostSteveApp {
	//FIELDS
	private TrelloDir myTrelloDir = new TrelloDir("src/main/resources/postSteve/");
	Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) {
		PostSteveApp app = new PostSteveApp();
		app.run();
	}
	
	public void run() {
//		myTrelloDir.getAllCsvFiles();
		System.out.println("What month would you like data for?");
		System.out.println(myTrelloDir.getDirectoryPath());
		String monthNumber = kb.next();
		List<Topic> topicsForMonth = myTrelloDir.getAllCsvFilesByMonth(monthNumber);
//		System.out.println(topicsForMonth.size());
//		for (Topic topic : topicsForMonth) {
//			System.out.println(topic);
//		}
		Map<String, Integer> myTallyMap = new HashMap<String, Integer>();
		for (Topic topic : topicsForMonth) {
			for (String instructor : topic.getInstructors()) {
				int count = myTallyMap.containsKey(instructor) ? myTallyMap.get(instructor) : 0;
				myTallyMap.put(instructor, count + 1);
			}
		}
		
		
		Set<String> s = myTallyMap.keySet();      
		Iterator<String> it = s.iterator();

		while (it.hasNext()) {
		  String key = it.next();
		  System.out.print("Key: " + key);
		  System.out.println(" Value: " + myTallyMap.get(key));
		}
		
	}

}
