package com.bae.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SearchLogs {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column (length = 40)
	private int memberNumber;
	@Column (length = 40)
	private String name;
	@Column (length=50)
	private String searchTerm;
	@Column (length=50)
	private String time;
	


public SearchLogs() {
	
}

public SearchLogs(Long id, int memberNumber, String name, String searchTerm, String time) {
	super();
	this.id=id;
	this.memberNumber = memberNumber;
	this.name = name;
	this.searchTerm=searchTerm;
	this.time=time;
	
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public int getMemberNumber() {
	return memberNumber;
}

public void setMemberNumber(int memberNumber) {
	this.memberNumber = memberNumber;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getSearchTerm() {
	return searchTerm;
}

public void setSearchTerm(String searchTerm) {
	this.searchTerm = searchTerm;
}

public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}

}