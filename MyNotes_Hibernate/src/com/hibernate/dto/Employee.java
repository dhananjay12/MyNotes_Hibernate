package com.hibernate.dto;

import java.util.Date;

import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee_details")
public class Employee {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "Name")
	private String name;
	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name = "Phone")
	private String mobile;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "Street_Permanent")),
			@AttributeOverride(name = "city", column = @Column(name = "City_Permanent")),
			@AttributeOverride(name = "state", column = @Column(name = "State_Permanent")),
			@AttributeOverride(name = "pincode", column = @Column(name = "Pincode_Permanent")) })
	private Address permanentAddress;
	private Address presentAddress;

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public Address getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(Address presentAddress) {
		this.presentAddress = presentAddress;
	}

}
