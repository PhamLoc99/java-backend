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

import com.example.demo.dto.DepartmentDto;
import com.example.demo.enity.DepartmentEnity;
import com.example.demo.repository.DepartmentRepository;

@RestController
@RequestMapping("/api")
public class DepartmentController {
	@Autowired
	private DepartmentRepository departmentRepository;
	 @GetMapping("/department")
	    public List<DepartmentEnity> getAllDepartments() {
	        return departmentRepository.findAll();
	    }
	  @GetMapping("/department/{id}")
	    public DepartmentEnity getDepartId(@PathVariable String id) {
	        return departmentRepository.findById(id).get(); 
	    }
	  
	  @DeleteMapping("/department/{id}")
	  @PreAuthorize("hasRole('ADMIN')")
	    public String delete(@PathVariable String id) {
	        departmentRepository.deleteById(id);
	        return "xóa thành công";
	    }
	  @PostMapping("/department")
	  @PreAuthorize("hasRole('ADMIN')")
	    public DepartmentEnity saveDepartment(@RequestBody DepartmentDto departmentDto) {

	        DepartmentEnity department= new DepartmentEnity();
	         department.setDescription(departmentDto.getDescription());
	         department.setName(departmentDto.getName());
	         department.setTIME_CREATE(Timestamp.valueOf(LocalDateTime.now()));
	         department.setTIME_UPDATE(Timestamp.valueOf(LocalDateTime.now()));
	        departmentRepository.saveAndFlush(department);

	        return department;
	    }
	  @PutMapping("/department")
	  @PreAuthorize("hasRole('ADMIN')")
	    public DepartmentEnity updateDepartment(@RequestBody DepartmentDto departmentDto) {
	        DepartmentEnity department = departmentRepository.findById(departmentDto.getId()).get();
	        String name = departmentDto.getName();
	        String description = departmentDto.getDescription();
	        if (department != null) {
	            if (name != null) {
	                department.setName(name);
	            }
	            if(description != null){
	                department.setDescription(description);
	            }
	            department.setTIME_UPDATE(Timestamp.valueOf(LocalDateTime.now()));
	            departmentRepository.save(department);
	        }

	        return department;
	    }

}
