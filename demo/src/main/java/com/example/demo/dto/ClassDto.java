package com.example.demo.dto;

import java.sql.Timestamp;

public class ClassDto {
	private String id;
    private String name;
    private String course;
    private String department_id;
    private String description;
    private Timestamp TIME_CREATE;
	private Timestamp TIME_UPDATE;
	public ClassDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClassDto(String id, String name, String course, String department_id, String description,
			Timestamp tIME_CREATE, Timestamp tIME_UPDATE) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.department_id = department_id;
		this.description = description;
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
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
