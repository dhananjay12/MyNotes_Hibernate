package com.hibernate.many2many.mapping;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;	
	@ManyToMany(cascade=CascadeType.PERSIST)
	private Collection<Project> project=new ArrayList<Project>();

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

	public Collection<Project> getProject() {
		return project;
	}

	public void setProject(Collection<Project> project) {
		this.project = project;
	}

}
