package com.osvaldo.metaphorce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osvaldo.metaphorce.entity.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {

	List<Contract> findByEmployeeIdEmployeeId(Long employeeId);

	Contract findByIsActiveAndEmployeeIdEmployeeId(Boolean isActive,Long employeeId);

}
