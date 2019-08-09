package com.bae.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@Column (length = 40)
private int memberNumber;
@Column (length = 40)
private String name;	


public User() {
}	

public User(Long id, int memberNumber, String name) {
	super();
	this.id=id;
	this.memberNumber = memberNumber;
	this.name = name;
	
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

}

