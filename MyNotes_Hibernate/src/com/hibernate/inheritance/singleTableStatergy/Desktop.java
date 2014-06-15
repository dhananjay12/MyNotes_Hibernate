package com.hibernate.inheritance.singleTableStatergy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Desktop computer")
public class Desktop extends ComputerDetails{
	
	private String keyBoardDetails;

	public String getKeyBoardDetails() {
		return keyBoardDetails;
	}

	public void setKeyBoardDetails(String keyBoardDetails) {
		this.keyBoardDetails = keyBoardDetails;
	}	
}
