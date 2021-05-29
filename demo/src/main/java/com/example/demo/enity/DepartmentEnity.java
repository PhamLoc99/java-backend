package com.example.demo.enity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


@Entity
@Table(name = "department")
public class DepartmentEnity implements Serializable {
	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	    @Column(name = "id", updatable = false, nullable = false)
	    private String id;
	    @Column(name = "name")
	    private String name;

	    @Column(name = "description")
	    private String description;
	    
	    @Column(name = "TIME_CREATE")
	    @CreatedDate
	    private Timestamp TIME_CREATE;
	    
	    @Column(name = "TIME_UPDATE")
	    @LastModifiedDate
	    private Timestamp TIME_UPDATE;

		public DepartmentEnity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public DepartmentEnity(String id, String name, String description, Timestamp tIME_CREATE,
				Timestamp tIME_UPDATE) {
			super();
			this.id = id;
			this.name = name;
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
