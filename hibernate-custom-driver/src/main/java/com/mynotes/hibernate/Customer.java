package com.mynotes.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@NamedNativeQueries({
	@NamedNativeQuery(
	name = "findActiveCustomer",
	query = "select * from customer where active=1",
    resultClass = Customer.class
	)
})

@Entity
@Table(name = "customer")
public class Customer {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Id
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "active")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean active;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", phone=" + phone + ", active=" + active + "]";
	}
	
	

}
