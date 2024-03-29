package com.skilldistillery.tat;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class TrelloCsvFileTests //
{
	TrelloDir myTrelloDir = new TrelloDir("src/main/resources/");

	@Test
	public void test_trello_csv_file_constructor_returns_some_topics() //
	{
		TrelloCsvFile sd16Unit1 = new TrelloCsvFile("src/main/resources/SD16_Unit1.csv");
		assertNotNull(sd16Unit1);

		List<Topic> topics = sd16Unit1.getTopics();
		assertNotNull(topics);
		assertTrue(topics.size() > 0);
	}
	

	@Test
	public void testTrelloCsvFileReturnsSomeTopics() //
	{
		List<TrelloCsvFile> myCsvs = myTrelloDir.getAllCsvFiles();

		List<Topic> myTopics = null;
//		if (myCsvs.size() > 0) //
//		{
//			myTopics = myCsvs.get(0).getTopics("src/main/resources/");
//		} 
//		else
//		{
			TrelloCsvFile myCsvFile = new TrelloCsvFile("src/main/resources/SD16_Unit2.csv");
			myTopics = myCsvFile.getTopics();
//		}
		assertNotNull(myCsvs);
		assertTrue(myCsvs.size() > 0);

		myTopics = myCsvs.get(0).getTopics();

		assertNotNull(myTopics);
		for (Topic topic : myTopics) {
			System.out.println(topic);
		}
		assertTrue(myTopics.size() > 0);
	}
	
	@Test
	public void testGetInstructorTopicTallyMapReturnsSomeTallies() {
		// refactor so that this method returns tallies from multiple files (3 or 4 files? maybe 5?)
		List<TrelloCsvFile> myCsvs = myTrelloDir.getAllCsvFiles();
		List<Topic> myTopics = null;
		TrelloCsvFile myCsvFile = new TrelloCsvFile("src/main/resources/SD16_Unit2.csv");
		myTopics = myCsvFile.getTopics();
		Map<String,Integer> myTallyMap = myCsvFile.getInstructorTopicTallyMap(myCsvFile.getTopics());
		System.out.println("*************************" + myTallyMap.size());
		Set<String> s = myTallyMap.keySet();      
		Iterator<String> it = s.iterator();

		while (it.hasNext()) {
		  String key = it.next();
		  System.out.print("Key: " + key);
		  System.out.println(" Value: " + myTallyMap.get(key));
		}
		
		assertNotNull(myTallyMap);
		assertTrue(myTallyMap.size() > 0);
	}
	@Test
	public void test_trello_csv_file_constructor_returns_some_topics_PostSteve() //
	{
		TrelloCsvFile sd22Unit2 = new TrelloCsvFile("src/main/resources/postSteve/SD22_Unit2.csv");
		assertNotNull(sd22Unit2);
		
		List<Topic> topics = sd22Unit2.getTopics();
		assertNotNull(topics);
		assertTrue(topics.size() > 0);
	}
	
	
	@Test
	public void testTrelloCsvFileReturnsSomeTopics_PostSteve() //
	{
		List<TrelloCsvFile> myCsvs = myTrelloDir.getAllCsvFiles();
		
		List<Topic> myTopics = null;
//		if (myCsvs.size() > 0) //
//		{
//			myTopics = myCsvs.get(0).getTopics("src/main/resources/");
//		} 
//		else
//		{
		TrelloCsvFile myCsvFile = new TrelloCsvFile("src/main/resources/postSteve/SD22_Unit2.csv");
		myTopics = myCsvFile.getTopics();
//		}
		assertNotNull(myCsvs);
		assertTrue(myCsvs.size() > 0);
		
		myTopics = myCsvs.get(0).getTopics();
		
		assertNotNull(myTopics);
		for (Topic topic : myTopics) {
			System.out.println(topic);
		}
		assertTrue(myTopics.size() > 0);
	}
	
	@Test
	public void testGetInstructorTopicTallyMapReturnsSomeTallies_PostSteve() {
		// refactor so that this method returns tallies from multiple files (3 or 4 files? maybe 5?)
		List<TrelloCsvFile> myCsvs = myTrelloDir.getAllCsvFiles();
		List<Topic> myTopics = null;
		TrelloCsvFile myCsvFile = new TrelloCsvFile("src/main/resources/postSteve/SD22_Unit2.csv");
		myTopics = myCsvFile.getTopics();
		Map<String,Integer> myTallyMap = myCsvFile.getInstructorTopicTallyMap(myCsvFile.getTopics());
		System.out.println("*************************" + myTallyMap.size());
		Set<String> s = myTallyMap.keySet();      
		Iterator<String> it = s.iterator();
		
		while (it.hasNext()) {
			String key = it.next();
			System.out.print("Key: " + key);
			System.out.println(" Value: " + myTallyMap.get(key));
		}
		
		assertNotNull(myTallyMap);
		assertTrue(myTallyMap.size() > 0);
	}
}
