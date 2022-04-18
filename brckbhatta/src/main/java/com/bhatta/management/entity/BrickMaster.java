package com.bhatta.management.entity;

import java.io.Serializable;
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

import com.bhatta.management.enums.BrickTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="brick_master")
public class BrickMaster implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="account_id")
	private Long accountId;
	
	@Column(name="brick_name")
	private String brickName;
	
	@Column(name="brick_type")
	private BrickTypeEnum brickType;
	
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
	
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "brickMaster")
	private List<BrickDetails> brickDetails;

}
