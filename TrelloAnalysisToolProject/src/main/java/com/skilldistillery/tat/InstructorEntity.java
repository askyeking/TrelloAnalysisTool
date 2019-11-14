package com.skilldistillery.tat;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "instructor")
public class InstructorEntity {
	
	//FIELDS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private boolean active;
	
	@ManyToMany
	@JoinTable(name = "instructor_topic", 
				joinColumns = @JoinColumn(name = "instructor_id"), 
				inverseJoinColumns = @JoinColumn(name = "topic_id"))
	@JsonIgnore
	private List<Topic> topicList;

	//CTORS
	public InstructorEntity() {
		super();
	}
	
	public InstructorEntity(String name, boolean active) {
		super();
		this.name = name;
		this.active = active;
	}
	
	//METHODS
	
	//TODO: write add/removes
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + id;
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
		InstructorEntity other = (InstructorEntity) obj;
		if (active != other.active)
			return false;
		if (id != other.id)
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
		StringBuilder builder = new StringBuilder();
		builder.append("InstructorEntity [id=").append(id).append(", name=").append(name).append(", active=")
				.append(active).append("]");
		return builder.toString();
	}
	
	
	
	
}
