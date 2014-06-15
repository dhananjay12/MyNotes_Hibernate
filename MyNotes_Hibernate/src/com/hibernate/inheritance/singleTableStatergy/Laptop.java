package com.hibernate.inheritance.singleTableStatergy;

import javax.persistence.Entity;

@Entity
public class Laptop extends ComputerDetails {
	
	private String chargerId;

	public String getChargerId() {
		return chargerId;
	}

	public void setChargerId(String chargerId) {
		this.chargerId = chargerId;
	}

}
