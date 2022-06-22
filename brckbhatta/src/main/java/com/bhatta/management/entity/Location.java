package com.bhatta.management.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="location")
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="location_id")
	private Long locationId;
	
	@Column(name="location_Address")
	private String locationAddress;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="country")
	private String country;
	
	@Column(name="location_Name")
	private String locationName;
	
	@Column(name="account_id")
	private Long accountId;
	
//	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "location")
//	List<Employee> employees;
	
	@Column(nullable = false ,updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@JsonFormat(pattern= "dd/MM/yyyy")
	private Date createdOn; 
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@JsonFormat(pattern= "dd/MM/yyyy")
	private Date updatedOn; 
}
