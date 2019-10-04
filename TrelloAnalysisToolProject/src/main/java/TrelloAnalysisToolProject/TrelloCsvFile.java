package TrelloAnalysisToolProject;

import java.util.List;

public class TrelloCsvFile {
	
	//fields
	private String pathName;
	private List<Topic> topicsList;
	
	//ctors
	public TrelloCsvFile() {
		super();
	}
	public TrelloCsvFile(String pathName, List<Topic> topicsList) {
		super();
		this.pathName = pathName;
		this.topicsList = topicsList;
	}
	
	//getters & setters
	public String getPathName() {
		return pathName;
	}
	public void setPathName(String pathName) {
		this.pathName = pathName;
	}
	public List<Topic> getTopicsList() {
		return topicsList;
	}
	public void setTopicsList(List<Topic> topicsList) {
		this.topicsList = topicsList;
	}
	
	//hashcode & equals & toString
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pathName == null) ? 0 : pathName.hashCode());
		result = prime * result + ((topicsList == null) ? 0 : topicsList.hashCode());
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
		TrelloCsvFile other = (TrelloCsvFile) obj;
		if (pathName == null) {
			if (other.pathName != null)
				return false;
		} else if (!pathName.equals(other.pathName))
			return false;
		if (topicsList == null) {
			if (other.topicsList != null)
				return false;
		} else if (!topicsList.equals(other.topicsList))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TrelloCsvFile [pathName=" + pathName + "]";
	}
	
	
	
	
	
	
	
}
