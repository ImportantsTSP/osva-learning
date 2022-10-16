package com.osvaldo.metaphorce.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contract implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contractId;
	@Column(name= "DateFrom",nullable=false )
	private LocalDate dateFrom;
	@Column(name= "DateTo",nullable=false)
	private LocalDate dateTo;
	@Column(name= "salaryPerDay",nullable=false)
	private Long salaryPerDay;
	@Column(name= "IsActive" ,nullable=false)
	private Boolean isActive;
	@CreationTimestamp
	@Column(name= "DateCreated",nullable=false)	
	private LocalDate dateCreated;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="contracTypeId")
	private ContractType contractTypeId;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employeeId;

}
