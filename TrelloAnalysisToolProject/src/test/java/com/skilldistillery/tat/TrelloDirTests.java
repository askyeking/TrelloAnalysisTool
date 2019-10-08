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
		List<TrelloCsvFile> myCsvs = myTrelloDir.getAllCsvFiles("src/main/resources/");
		TrelloCsvFile[] myCsvsArr = myCsvs.toArray(new TrelloCsvFile[myCsvs.size()]);
		for (int i = 0; i < myCsvsArr.length; i++) {
			System.out.println(myCsvsArr[i]);
		}
		System.out.println();
		assertTrue(myCsvs.size() > 0);
	}

}
