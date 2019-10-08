package com.skilldistillery.tat;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class TrelloCsvFileTests //
{

	@Test
	public void testTrelloCsvFileReturnsSomeTopics() //
	{
		TrelloDir myTrelloDir = new TrelloDir();
		List<TrelloCsvFile> myCsvs = myTrelloDir.getAllCsvFiles("src/main/resources/");

		List<Topic> myTopics = null;
//		if (myCsvs.size() > 0) //
//		{
//			myTopics = myCsvs.get(0).getTopics("src/main/resources/");
//		} 
//		else
//		{
			TrelloCsvFile myCsvFile = new TrelloCsvFile("SD16_Unit1.csv");
			myTopics = myCsvFile.getTopics("src/main/resources/");
//		}
		assertNotNull(myTopics);
		assertTrue(myTopics.size() > 0);
	}

}
