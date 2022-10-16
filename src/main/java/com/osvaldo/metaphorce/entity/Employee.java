package com.osvaldo.metaphorce.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;

	@Column(name= "TaxIdNumber" ,nullable=false,length = 13)
	private String taxIdNumber;
	@Column(name= "Name",length = 60 ,nullable=false )
	private String name;
	@Column(name= "LastName",length = 120 ,nullable=false )
	private String lastName;
	@Column(name= "BirthDate",nullable = false)
	private LocalDate birthDate;
	@Column(name= "Email",length = 60 ,nullable=false )
	private String email;
	@Column(name= "CellPhone",length = 20 ,nullable=false )
	private String cellPhone;
	@Column(name= "IsActive" ,nullable=false)
	private Boolean isActive;
	@CreationTimestamp
	@Column(name= "DateCreated",nullable=false)
	private LocalDate dateCreated;
	
    @OneToMany(
            mappedBy = "employeeId"

        )
    private List<Contract> contracts;
	


}
