package com.osvaldo.metaphorce.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.osvaldo.metaphorce.dto.request.EmployeeReqDto;
import com.osvaldo.metaphorce.dto.response.ContractDto;
import com.osvaldo.metaphorce.dto.response.EmployeeDataDto;
import com.osvaldo.metaphorce.dto.response.EmployeeDto;
import com.osvaldo.metaphorce.dto.response.EmployeeResponseDto;
import com.osvaldo.metaphorce.dto.response.PageDto;
import com.osvaldo.metaphorce.dto.response.ResultDto;
import com.osvaldo.metaphorce.entity.Employee;
import com.osvaldo.metaphorce.repository.EmployeeRepository;
import com.osvaldo.metaphorce.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository employer;

	@Override
	public EmployeeResponseDto saveEmployee(EmployeeReqDto employee) {
		Employee emp = Employee.builder().build();
		BeanUtils.copyProperties(employee, emp);
		

		try {
			employer.save(emp);
			return buildDto(201, "created", "entity was created");
		} catch (Exception e) {
			log.error("Erorr:", e.getStackTrace());
			return buildDto(409, "conflict", e.getMessage());
		}
	}

	@Override
	public EmployeeResponseDto updateEmployee(EmployeeReqDto employee, Long employeeId) {
		Employee emp = employer.findById(employeeId).get();

		BeanUtils.copyProperties(employee, emp);
		emp.setEmployeeId(employeeId);

		try {
			employer.save(emp);
			return buildDto(204, "Not content", "entity was updated");
		} catch (Exception e) {
			log.error("Erorr:", e.getStackTrace());
			return buildDto(409, "conflict", "entity could not be updated");
		}

	}

	private EmployeeResponseDto buildDto(Integer code, String info, String message) {

		return EmployeeResponseDto.builder()
				.result(ResultDto.builder().statusCode(code).info(info).message(message).build()).build();
	}

	@Override
	public EmployeeResponseDto getEmployees( Integer page, Integer size) {
		Pageable pageable= PageRequest.of(page, size);
		System.out.println(pageable.getPageSize());
		System.out.println(pageable.getPageNumber());


		try {
			Page<Employee> pEmployees=employer.findByIsActive(true,pageable);
			
			List<EmployeeDto> lEmp = pEmployees.getContent().stream().map(employee -> {

				EmployeeDto employeeDto = EmployeeDto.builder().build();
				BeanUtils.copyProperties(employee, employeeDto);
				employeeDto.setFullName(employee.getName() + " " + employee.getLastName());
				
				ContractDto contractDto = ContractDto.builder().build();
				List<ContractDto> contrasctDto=employee.getContracts().stream().map(contract->{
					
					BeanUtils.copyProperties(contract, contractDto);
					if(Boolean.TRUE.equals(contract.getIsActive())) {
					contractDto.setName(contract.getContractTypeId().getName());
				
					}else {
						contractDto.setName(null);
						contractDto.setDateFrom(null);
						contractDto.setDateTo(null);
						contractDto.setSalaryPerDay(null);
					}
					
					return contractDto;
				}).collect(Collectors.toList());
				employeeDto.setContracts(contrasctDto);
				return employeeDto;
			}).collect(Collectors.toList());
			
			PageDto pageS=PageDto.builder()
					.size(pEmployees.getSize())
					.totalElements(pEmployees.getTotalElements()).
					totalPages(pEmployees.getTotalPages()).number(pEmployees.getNumber()).build();

			return EmployeeResponseDto.builder()
					.result(ResultDto.builder().statusCode(200).info("Ok").message("List Employees").build())
					.data(EmployeeDataDto.builder().employees(lEmp).pageDto(pageS).build())
					.build();

		} catch (Exception e) {
            log.error("Error:",e.getStackTrace());
			return EmployeeResponseDto.builder()
					.result(ResultDto.builder().statusCode(200).info("200").message("List Employees").build()).build();
		}

	}

}
