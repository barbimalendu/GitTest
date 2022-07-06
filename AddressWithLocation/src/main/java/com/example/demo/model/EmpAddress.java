package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name ="emp_address")
public class EmpAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private String streetName;
	private String landmark;
	private String addressLine1;
	private String addressLine2;
	
	
	
	
	public EmpAddress() {
		super();
		// TODO Auto-generated constructor stub
	}




	public EmpAddress(Integer id, String streetName, String landmark, String addressLine1, String addressLine2) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.landmark = landmark;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
	}




	public EmpAddress(String streetName, String landmark, String addressLine1, String addressLine2) {
		super();
		this.streetName = streetName;
		this.landmark = landmark;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getStreetName() {
		return streetName;
	}




	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}




	public String getLandmark() {
		return landmark;
	}




	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}




	public String getAddressLine1() {
		return addressLine1;
	}




	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}




	public String getAddressLine2() {
		return addressLine2;
	}




	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	
	
	

}


