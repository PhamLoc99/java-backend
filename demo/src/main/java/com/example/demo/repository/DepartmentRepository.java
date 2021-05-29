package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.enity.DepartmentEnity;

public interface DepartmentRepository extends JpaRepository<DepartmentEnity, String> {

}
