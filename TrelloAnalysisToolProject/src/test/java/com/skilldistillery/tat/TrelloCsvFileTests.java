package com.skilldistillery.tat;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

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
		List<TrelloCsvFile> myCsvs = myTrelloDir.getAllCsvFiles("SD16_Unit2.csv");

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
		List<TrelloCsvFile> myCsvs = myTrelloDir.getAllCsvFiles("src/main/resources/");
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
//	@Test
//	public void testGetInstructorTopicTallyMapReturnsSomeTallies() {
//		List<TrelloCsvFile> myCsvs = myTrelloDir.getAllCsvFiles("src/main/resources/");
//		List<Topic> myTopics = null;
//		TrelloCsvFile myCsvFile = new TrelloCsvFile("SD16_Unit2.csv");
//		myTopics = myCsvFile.getTopics("src/main/resources/");
//		Map<String,Integer> myTallyMap = myCsvFile.getInstructorTopicTallyMap(myCsvFile.getTopics("src/main/resources/"));
//		System.out.println("*************************" + myTallyMap.size());
//		Set<String> s = myTallyMap.keySet();      // Set of Integer keys
//		Iterator<String> it = s.iterator();
//
//		while (it.hasNext()) {
//		  String key = it.next();
//		  System.out.print("Key: " + key);
//		  System.out.println(" Value: " + myTallyMap.get(key));
//		}
//		
//		assertNotNull(myTallyMap);
//		assertTrue(myTallyMap.size() > 0);
//	}

}
