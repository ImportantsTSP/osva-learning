package com.osvaldo.metaphorce.entity;

import java.io.Serializable;
import java.time.LocalDate;
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

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractType implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contracTypeId;
	@Column(name= "Name",length = 80 ,nullable=false )
	private String name;
	@Column(name= "Description",length = 255 ,nullable=true)
	private String description;
	@Column(name= "IsActive" ,nullable=false)
	private Boolean isActive;
	@CreationTimestamp
	@Column(name= "DateCreated",nullable=false)
	private LocalDate dateCreated;
	
	@OneToMany
	(
            mappedBy = "employeeId"

        )
    private List<Contract> contracts;
	

}
