package com.hibernate.one2many.mapping;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	/*@OneToMany
	@JoinTable(name="Employee_Address_Mapping",
				joinColumns=@JoinColumn(name="emp_id"),
				inverseJoinColumns=@JoinColumn(name="add_id"))
	private Collection<Address> address=new ArrayList<Address>();*/
	@OneToMany(mappedBy="employee")
	private Collection<Address> address=new ArrayList<Address>();

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

	public Collection<Address> getAddress() {
		return address;
	}

	public void setAddress(Collection<Address> address) {
		this.address = address;
	}
}
