package com.hibernate.inheritance.tablePerConceteClassStatergy;

import javax.persistence.Entity;

@Entity
public class Desktop extends ComputerDetails{
	
	private String keyBoardDetails;

	public String getKeyBoardDetails() {
		return keyBoardDetails;
	}

	public void setKeyBoardDetails(String keyBoardDetails) {
		this.keyBoardDetails = keyBoardDetails;
	}	
}
