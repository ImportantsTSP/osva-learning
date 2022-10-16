package com.osvaldo.metaphorce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osvaldo.metaphorce.entity.Contract;
import com.osvaldo.metaphorce.entity.ContractType;

public interface ContractTypeRepository extends JpaRepository<ContractType, Long> {

}
