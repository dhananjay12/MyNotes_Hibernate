package com.hibernate.one2one.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int bankDetails_id;
	private String accountNumber;
	private String bankName;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getBankDetails_id() {
		return bankDetails_id;
	}

	public void setBankDetails_id(int bankDetails_id) {
		this.bankDetails_id = bankDetails_id;
	}

}
