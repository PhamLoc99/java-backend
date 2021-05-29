package com.example.demo.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClassDto;
import com.example.demo.enity.ClassEnity;
import com.example.demo.repository.ClassRepository;
import com.example.demo.repository.DepartmentRepository;

@RestController
@RequestMapping("/api")
public class ClassController {
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	 @GetMapping("/class")
	    public List<ClassEnity> getAllClass() {
	        return classRepository.findAll();
	    }

	    @GetMapping("/class/{id}")
	    public ClassEnity getClassId(@PathVariable String id) {
	        ClassEnity classK = classRepository.findById(id).get();
	        if (classK == null) {
	            throw new RuntimeException("classK not found for the Id:" + id);
	        }
	        return classK;
	    }
	    @PostMapping("/department/{id}/class")
	    @PreAuthorize("hasRole('ADMIN')")
	    public ClassEnity createClass(@PathVariable(value = "id") String id, @RequestBody ClassEnity classEnity)
	    {
	    	return departmentRepository.findById(id).map(DepartmentEnity->{
	    		classEnity.setDepartmentenity(DepartmentEnity);
	    		return classRepository.save(classEnity);
	    	}).orElseThrow();
	    }
	    @PutMapping("/class")
	    @PreAuthorize("hasRole('ADMIN')")
	    public ClassEnity updateClass(@RequestBody ClassDto classDto) {
	        ClassEnity classenity = classRepository.findById(classDto.getId()).get();
	        String name = classDto.getName();
	        String course = classDto.getCourse();
	        String description = classDto.getDescription();
	        if (classenity != null) {
	            if (name != null) {
	            	classenity.setName(name);
	            }
	            if (course != null) {
	            	classenity.setCourse(course);
	            if (description != null) {
	            	classenity.setDescription(description);
	            }
	          
	            classenity.setDepartment_Id(classDto.getDepartment_id());
	            classenity.setTIME_CREATE(Timestamp.valueOf(LocalDateTime.now()));
	            classenity.setTIME_UPDATE(Timestamp.valueOf(LocalDateTime.now()));
	            classRepository.save(classenity);

	        }
	        }
	        return classenity;

	    }

	    @DeleteMapping("/class/{id}")
	    @PreAuthorize("hasRole('ADMIN')")
	    public String delete(@PathVariable String id) {
	        classRepository.deleteById(id);
	        return "xóa thành công";
	    }

}
