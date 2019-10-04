package com.skilldistillery.tat;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class TrelloDirTests //
{

	@Test
	public void testTrelloDirReturnsSomeCsvFiles() //
	{
		TrelloDir myTrelloDir = new TrelloDir();
		List<TrelloCsvFile> myCsvs = myTrelloDir.getAllCsvFiles();
		assertTrue(myCsvs.size() > 0);
	}

}
