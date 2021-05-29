package com.example.demo.dto;

import java.sql.Date;
import java.sql.Timestamp;


public class StudentDto {
	private String id;
    private String name;
    private Date birthdate;
    private int gender;
    private String address;
    private String classk_id;
    private Timestamp TIME_CREATE;
	private Timestamp TIME_UPDATE;
	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentDto(String id, String name, Date birthdate, int gender, String address, String classk_id,
			Timestamp tIME_CREATE, Timestamp tIME_UPDATE) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.classk_id = classk_id;
		TIME_CREATE = tIME_CREATE;
		TIME_UPDATE = tIME_UPDATE;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getClassk_id() {
		return classk_id;
	}
	public void setClassk_id(String classk_id) {
		this.classk_id = classk_id;
	}
	public Timestamp getTIME_CREATE() {
		return TIME_CREATE;
	}
	public void setTIME_CREATE(Timestamp tIME_CREATE) {
		TIME_CREATE = tIME_CREATE;
	}
	public Timestamp getTIME_UPDATE() {
		return TIME_UPDATE;
	}
	public void setTIME_UPDATE(Timestamp tIME_UPDATE) {
		TIME_UPDATE = tIME_UPDATE;
	}
	
}
