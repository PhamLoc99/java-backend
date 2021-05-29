package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo.dto.StudentAlnDto;
import com.example.demo.enity.StudentEnity;
import com.example.demo.repository.StudentRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class StudentServiceImlp implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<StudentEnity> pageableStudent(int pagenumber, int rowsofpage) {
		// TODO Auto-generated method stub
		return studentRepository.pageableStudent(pagenumber, rowsofpage);
	}
	
//	@Override
//	public List<StudentAlnDto> analyList(int startAge,int endAge)
//	{
//		return studentRepository.analyList(startAge, endAge);
//	}
		

}
