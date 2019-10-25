package com.skilldistillery.tat;

import java.util.Scanner;

public class PostSteveApp {
	//FIELDS
	private TrelloDir myTrelloDir = new TrelloDir("src/main/resources/postSteve");
	Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) {
		PostSteveApp app = new PostSteveApp();
		app.run();
	}
	
	public void run() {
		myTrelloDir.getAllCsvFiles();
		
	}

}
