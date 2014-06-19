package com.hibernate.namedQueries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries({
	@NamedQuery(
	name = "findEmployeeById",
	query = "from Employee where id = :passId"
	)
})
@NamedNativeQueries({
	@NamedNativeQuery(
	name = "findEmployeeByIdNativeSQL",
	query = "select * from Employee_details where emp_id = :passId",
    resultClass = Employee.class
	),
	@NamedNativeQuery(
			name = "findEmployeeByIdStoreProcedure",
			query = "CALL GET_EMPLOYEE_BY_ID(:passId)",
		    resultClass = Employee.class
	)
})

@Entity
@Table(name="employee_details")
public class Employee {

	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
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
}
