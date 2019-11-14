package com.skilldistillery.tat;



import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;


public class TopicTests //
{

	@Test
	public void test_topics_are_mostly_filled_in() //
	{
		int dateCount = 0;
		int instructorCount = 0;
		int monthCount = 0;
		int nameCount = 0;
		int yearCount = 0;

		TrelloCsvFile sd16Unit1 = new TrelloCsvFile("src/main/resources/SD16_Unit1.csv");
		List<Topic> topics = sd16Unit1.getTopics();
		for (Topic topic : topics) {
			String dateStr = topic.getDateStr();
			if (dateStr != null && dateStr.length() > 0) {
				dateCount++;
			}

			List<String> instructors = topic.getInstructors();
			if (instructors != null && instructors.size() > 0) {
				for (String instructor : instructors) {
					if (instructor != null && instructor.length() > 0) {
						instructorCount++;
						break;
					}
				}
			}

			Integer month = topic.getMonth();
			if (month != null && month >= 1 && month <= 12) {
				monthCount++;
			}

			String topicName = topic.getTopicName();
			if (topicName != null && topicName.length() > 0) {
				nameCount++;
			}

			Integer year = topic.getYear();
			if (year != null && year >= 2018) {
				yearCount++;
			}
		} // end for each topic

		assertTrue(dateCount * 2 >= topics.size());
		assertTrue(instructorCount * 2 >= topics.size());
		assertTrue(monthCount * 2 >= topics.size());
		assertTrue(nameCount * 2 >= topics.size());
		assertTrue(yearCount * 2 >= topics.size());
	} // end test_topics_are_mostly_filled_in( )

}
