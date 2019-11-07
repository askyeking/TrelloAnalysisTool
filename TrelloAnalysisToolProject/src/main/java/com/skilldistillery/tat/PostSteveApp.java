package com.skilldistillery.tat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PostSteveApp {
	// FIELDS
	/*
	 * TODO For now, Directory is hardcoded, refactor so user can decide which to use (via Switch)
	 */
//	private TrelloDir myTrelloDir = new TrelloDir("src/main/resources/postSteve/");
	private TrelloDir myTrelloDir = new TrelloDir("src/main/resources/");
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		PostSteveApp app = new PostSteveApp();
		app.run();
	}

	public void run() {
		System.out.println("What month would you like data for?");
		System.out.println(myTrelloDir.getDirectoryPath());
		String monthNumber = kb.next();
		
		List<Topic> topicsForMonth = myTrelloDir.getAllTopicsByMonth(monthNumber);
		
		Map<String, Integer> myTallyMap = myTrelloDir.getInstructorTopicTallyMapByMonth(monthNumber, topicsForMonth);
		
		
		Set<String> s = myTallyMap.keySet();
		Iterator<String> it = s.iterator();
		int totalTallies = myTallyMap.get("totalTallies");
		while (it.hasNext()) {
			String key = it.next();
			System.out.print("Key: " + key);
			System.out.print("| Value: " + myTallyMap.get(key));
			if(totalTallies > 0) {
				System.out.print("| Percentage: " +  ((myTallyMap.get(key) * 100) / totalTallies ));
			}
			System.out.println();
		}

	}

}
