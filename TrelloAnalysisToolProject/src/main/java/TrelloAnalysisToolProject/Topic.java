package TrelloAnalysisToolProject;

import java.util.Date;
import java.util.List;

public class Topic {
	//fields
	private String name;
	private int durationInMins;
	private Date date;
	private List<String> instructorList;
	
	//ctors
	public Topic() {
		super();
	}
	
	public Topic(String name, Date date, List<String> instructorList) {
		super();
		this.name = name;
		this.date = date;
		this.instructorList = instructorList;
	}

	public Topic(String name, int durationInMins, Date date, List<String> instructorList) {
		super();
		this.name = name;
		this.durationInMins = durationInMins;
		this.date = date;
		this.instructorList = instructorList;
	}
	
	//getters & setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDurationInMins() {
		return durationInMins;
	}

	public void setDurationInMins(int durationInMins) {
		this.durationInMins = durationInMins;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<String> getInstructorList() {
		return instructorList;
	}

	public void setInstructorList(List<String> instructorList) {
		this.instructorList = instructorList;
	}

	//hashcode & equals & toString
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + durationInMins;
		result = prime * result + ((instructorList == null) ? 0 : instructorList.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (durationInMins != other.durationInMins)
			return false;
		if (instructorList == null) {
			if (other.instructorList != null)
				return false;
		} else if (!instructorList.equals(other.instructorList))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Topic [name=" + name + ", durationInMins=" + durationInMins + ", date=" + date + "]";
	}
	
	
	
	
}
