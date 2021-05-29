package com.example.demo.enity;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "student")
public class StudentEnity implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthdate")
    private Date birthdate;
    @Column(name = "gender")
    private int gender;
    
    @Column(name = "class_id")
    private String class_id;
    
    @ManyToOne(optional = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id", insertable = false, updatable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})   
    private ClassEnity classEnity;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "TIME_CREATE")
    @CreatedDate
    private Timestamp TIME_CREATE;
    
    @Column(name = "TIME_UPDATE")
    @LastModifiedDate
    private Timestamp TIME_UPDATE;

	public StudentEnity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentEnity(String id, String name, Date birthdate, int gender, String class_id, ClassEnity classEnity,
			String address, Timestamp tIME_CREATE, Timestamp tIME_UPDATE) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.class_id = class_id;
		this.classEnity = classEnity;
		this.address = address;
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

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public ClassEnity getClassEnity() {
		return classEnity;
	}

	public void setClassEnity(ClassEnity classEnity) {
		this.classEnity = classEnity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
