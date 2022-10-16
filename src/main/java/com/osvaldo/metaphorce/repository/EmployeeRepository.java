package com.osvaldo.metaphorce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osvaldo.metaphorce.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	public  List<Employee> findByIsActive(Boolean isActive);

}
