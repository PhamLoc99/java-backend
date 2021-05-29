package com.example.demo.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClassDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.enity.ClassEnity;
import com.example.demo.enity.StudentEnity;
import com.example.demo.repository.ClassRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private StudentService studentService;
	
  private Sort.Direction getSortDirection(String direction) {
  if (direction.equals("asc")) {
      return Sort.Direction.ASC;
  } else if (direction.equals("desc")) {
      return Sort.Direction.DESC;
  }

  return Sort.Direction.ASC;
}
//  @GetMapping("/anal-student")
//  public List<StudentAlnDto> getAllStudents(@RequestParam(defaultValue = "20") int startAge,
//          @RequestParam(defaultValue = "25") int endAge) {
//
//      return studentRepository.analyList(startAge, endAge);
//  }

	
  @GetMapping("/student/page")
  public ResponseEntity<Map<String, Object>> pageable(@RequestParam(required = false) String name,
          @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size,
          @RequestParam(defaultValue = "id,desc") String[] sort) {

      try {
          List<StudentEnity> students = studentService.pageableStudent(page, size);
          Map<String, Object> response = new HashMap<>();
          response.put("students", students);

          return new ResponseEntity<>(response, HttpStatus.OK);
      } catch (Exception e) {
          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
	
	 @GetMapping("/student")
	    public List<StudentEnity> getAllStudents() {
	        return studentRepository.findAll();
	    }
	 @GetMapping("/student/{id}")
	    public StudentEnity getStudentId(@PathVariable String id) {
	        StudentEnity student = studentRepository.findById(id).get();
	        if (student == null) {
	            throw new RuntimeException("Student not found for the Id:" + id);
	        }
	        return student;
	    }
	 @DeleteMapping("/student/{id}")
	 @PreAuthorize("hasRole('ADMIN')")
	    public String delete(@PathVariable String id) {
	        studentRepository.deleteById(id);
	        return "xóa thành công";
	    }


	 @PutMapping("/student/{id}")
	 @PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<StudentEnity> update(@RequestBody StudentEnity studentEnity, @PathVariable String id) {
	        Optional<ClassEnity> optionalclass = classRepository.findById(studentEnity.getClassEnity().getId());
	        if (!optionalclass.isPresent()) {
	            return ResponseEntity.unprocessableEntity().build();
	        }

	        Optional<StudentEnity> optionalstudent = studentRepository.findById(id);
	        if (!optionalstudent.isPresent()) {
	            return ResponseEntity.unprocessableEntity().build();
	        }

	        studentEnity.setClassEnity(optionalclass.get());
	        studentEnity.setId(optionalclass.get().getId());
	        studentRepository.save(studentEnity);

	        return ResponseEntity.noContent().build();
	    }
	  @PostMapping("/class/{id}/student")
	  @PreAuthorize("hasRole('ADMIN')")
	  public StudentEnity createStudent(@PathVariable(value = "id") String id, @RequestBody StudentEnity studentEnity)
	  {
		  return classRepository.findById(id).map(ClassEnity->{
			  studentEnity.setClassEnity(ClassEnity);
			  return studentRepository.save(studentEnity);
		  }).orElseThrow();
	  }




}
