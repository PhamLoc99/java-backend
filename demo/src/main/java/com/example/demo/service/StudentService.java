package com.example.demo.service;

import java.util.List;

//import com.example.demo.dto.StudentAlnDto;
import com.example.demo.enity.StudentEnity;

public interface StudentService {
	
	List<StudentEnity> pageableStudent(int pagenumber,int rowsofpage);

	//List<StudentAlnDto> analyList(int startAge, int endAge);

}
