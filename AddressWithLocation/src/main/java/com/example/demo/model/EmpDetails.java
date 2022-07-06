package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="emp_details")
public class EmpDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)		
private Integer id;
private String empName;
private String jobDescription;
private Integer salary;



public EmpDetails() {
	super();
	// TODO Auto-generated constructor stub
}



public EmpDetails(Integer id, String empName, String jobDescription, Integer salary) {
	super();
	this.id = id;
	this.empName = empName;
	this.jobDescription = jobDescription;
	this.salary = salary;
}



public Integer getId() {
	return id;
}



public void setId(Integer id) {
	this.id = id;
}



public String getEmpName() {
	return empName;
}



public void setEmpName(String empName) {
	this.empName = empName;
}



public String getJobDescription() {
	return jobDescription;
}



public void setJobDescription(String jobDescription) {
	this.jobDescription = jobDescription;
}



public Integer getSalary() {
	return salary;
}



public void setSalary(Integer salary) {
	this.salary = salary;
}







}


