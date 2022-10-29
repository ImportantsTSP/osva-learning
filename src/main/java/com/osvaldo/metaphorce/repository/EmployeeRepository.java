package com.osvaldo.metaphorce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.osvaldo.metaphorce.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	public  Page<Employee> findByIsActive(Boolean isActive,Pageable pageable);

}
