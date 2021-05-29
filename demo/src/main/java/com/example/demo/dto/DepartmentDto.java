package com.example.demo.dto;

import java.sql.Timestamp;

public class DepartmentDto {
	 private String id;

	    private String name;

	    private String description;

		private Timestamp TIME_CREATE;
		
		private Timestamp TIME_UPDATE;

		public DepartmentDto() {
			super();
			// TODO Auto-generated constructor stub
		}

		public DepartmentDto(String id, String name, String description, Timestamp tIME_CREATE,
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

		
}
