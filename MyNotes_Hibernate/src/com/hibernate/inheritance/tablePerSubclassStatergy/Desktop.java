package com.hibernate.inheritance.tablePerSubclassStatergy;

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
