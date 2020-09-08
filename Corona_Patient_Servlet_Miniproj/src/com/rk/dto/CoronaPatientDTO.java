package com.rk.dto;

import java.io.Serializable;

public class CoronaPatientDTO implements Serializable {

	//read input
	private String name;
	private String add;
	private int age;
	private int number_day;
	private String hospital_name;
	private String hospital_type;
	
	//getters & setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNumber_day() {
		return number_day;
	}
	public void setNumber_day(int number_day) {
		this.number_day = number_day;
	}
	public String getHospital_name() {
		return hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	public String getHospital_type() {
		return hospital_type;
	}
	public void setHospital_type(String hospital_type) {
		this.hospital_type = hospital_type;
	}
}
