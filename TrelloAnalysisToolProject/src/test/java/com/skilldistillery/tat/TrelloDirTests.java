package com.skilldistillery.tat;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class TrelloDirTests //
{

	@Test
	public void test_TrelloDir_returns_some_csv_files() //
	{
		TrelloDir myTrelloDir = new TrelloDir("src/main/resources/");
		List<TrelloCsvFile> myCsvs = myTrelloDir.getAllCsvFiles();
		assertNotNull(myCsvs);
		assertTrue(myCsvs.size() > 0);
	} // end ( )

	@Test
	public void test_TrelloDir_returns_good_csv_files() //
	{
		TrelloDir myTrelloDir = new TrelloDir("src/main/resources/");
		List<TrelloCsvFile> myCsvs = myTrelloDir.getAllCsvFiles();

		for (TrelloCsvFile myCsv : myCsvs) //
		{
			String csvName = myCsv.getFileName();
			assertNotNull(csvName);
			assertTrue(csvName.startsWith("src/main/resources/"));
			assertTrue(csvName.endsWith(".csv"));
			List<Topic> topics = myCsv.getTopics();
			assertNotNull(topics);
			assertTrue(topics.size() > 0);
		}
	} // end ( )
	@Test
	public void test_TrelloDir_returns_some_csv_files_PostSteve() //
	{
		TrelloDir myTrelloDir = new TrelloDir("postSteve/");
		List<TrelloCsvFile> myCsvs = myTrelloDir.getAllCsvFiles();
		assertNotNull(myCsvs);
		assertTrue(myCsvs.size() > 0);
	} // end ( )
	
	@Test
	public void test_TrelloDir_returns_good_csv_files_PostSteve() //
	{
		TrelloDir myTrelloDir = new TrelloDir("postSteve/");
		List<TrelloCsvFile> myCsvs = myTrelloDir.getAllCsvFiles();
		
		for (TrelloCsvFile myCsv : myCsvs) //
		{
			String csvName = myCsv.getFileName();
			assertNotNull(csvName);
			assertTrue(csvName.startsWith("postSteve/"));
			assertTrue(csvName.endsWith(".csv"));
			List<Topic> topics = myCsv.getTopics();
			assertNotNull(topics);
			assertTrue(topics.size() > 0);
		}
	} // end ( )

}
