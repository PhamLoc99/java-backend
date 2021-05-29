package com.example.demo.enity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "class")
public class ClassEnity implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "course")
    private String course;
    
    @Column(name = "department_id")
    private String department_id;
    
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})   
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private DepartmentEnity departmentenity;
    
    @Column(name = "description")
    private String description;
    @Column(name = "TIME_CREATE", nullable = true, updatable = true)
    @CreatedDate
    private Timestamp TIME_CREATE;

   
    @Column(name = "TIME_UPDATE", nullable = true)
    @LastModifiedDate
    private Timestamp TIME_UPDATE;


	public ClassEnity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ClassEnity(String id, String name, String course, String department_id, DepartmentEnity departmentenity,
			String description, Timestamp tIME_CREATE, Timestamp tIME_UPDATE) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.department_id = department_id;
		this.departmentenity = departmentenity;
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


	public void setDepartment_Id(String department_id) {
		this.department_id = department_id;
	}


	public DepartmentEnity getDepartmentenity() {
		return departmentenity;
	}


	public void setDepartmentenity(DepartmentEnity departmentenity) {
		this.departmentenity = departmentenity;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
