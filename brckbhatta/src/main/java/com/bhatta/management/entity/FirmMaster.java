package com.bhatta.management.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="firm_master")
@EntityListeners(AuditingEntityListener.class)
public class FirmMaster {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="firm_id")
	private Long firmId;
	
	@Column(name="firm_name")
	private String firmName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(nullable = false,updatable=false)
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date createdOn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(nullable = false)
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date updatedOn;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="acc_id")
	private Account account;
	
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "firmMaster")
	private List<Customer> customer;
	
//	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "firmMaster")
//	private List<Employee> employees;
//	
//	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "firmMaster")
//	private List<Designation> designations;
	
}
