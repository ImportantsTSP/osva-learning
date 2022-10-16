package com.osvaldo.metaphorce.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osvaldo.metaphorce.dto.request.ContractReqDto;
import com.osvaldo.metaphorce.dto.response.ContractResponseDto;
import com.osvaldo.metaphorce.dto.response.ResultDto;
import com.osvaldo.metaphorce.entity.Contract;
import com.osvaldo.metaphorce.entity.ContractType;
import com.osvaldo.metaphorce.entity.Employee;
import com.osvaldo.metaphorce.repository.ContractRepository;
import com.osvaldo.metaphorce.service.ContractService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContractServiceImp implements ContractService {

	@Autowired
	ContractRepository contractRepository;

	@Override
	public ContractResponseDto saveContract(ContractReqDto contractReqDto) {
		Contract contract = Contract.builder().build();
		BeanUtils.copyProperties(contractReqDto,contract);
		contract.setContractTypeId(ContractType.builder().contracTypeId(contractReqDto.getContractTypeId()).build());
		contract.setEmployeeId(Employee.builder().employeeId(contractReqDto.getEmployeeId()).build());

		try {
			List<Contract> contracts=contractRepository.findByEmployeeIdEmployeeId(contractReqDto.getEmployeeId());
			System.out.println("#######"+contracts.size());
			if(contracts.isEmpty()) {
                log.info("employe does not exist");
				contractRepository.save(contract);
			}else  {//set contract that are active to no active
				contracts.stream().filter(c->c.getIsActive()).forEach(c->{
					System.out.println(c);
					c.setIsActive(false);
					c.setDateTo(LocalDate.now());
					contractRepository.save(c);
					contractRepository.save(contract);
				});
				
				
				
			}
			return buildDto(201, "created", "entity was created");
		} catch (Exception e) {
			log.error("Erorr:", e.getCause());
			return buildDto(409, "conflict", e.getMessage());
		}
	}

	@Override
	public ContractResponseDto deleteContract(Long employeeId) {


		try {
			Contract  contract=	contractRepository.findByIsActiveAndEmployeeIdEmployeeId(true,employeeId);          
		System.out.println(contract);
		contract.setIsActive(false);
		contract.setDateTo(LocalDate.now());
		contractRepository.save(contract);
			return buildDto(204, "Not content", "entity was deleted");
		} catch (Exception e) {
			log.error("Erorr:", e.getCause());
			return buildDto(409, "conflict", "entity could not be deleted");
		}
		

	}

	private ContractResponseDto buildDto(Integer code, String info, String message) {

		return ContractResponseDto.builder()
				.result(ResultDto.builder().statusCode(code).info(info).message(message).build()).build();
	}



}
