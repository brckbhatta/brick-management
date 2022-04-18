package com.bhatta.management.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="account")
@EntityListeners(AuditingEntityListener.class)
public class Account implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_id")
	private Long accountId;
	
	@Column(name="account_name")
	private String accountName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone_no")
	private Long phoneNo;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="address")
	private String address;
	
	@Column(name="is_verified", columnDefinition = " boolean default false")
	private Boolean isVerified;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name="created_on",updatable=false)
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date createdOn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name="updated_on")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date updatedOn;
	
	@Column(name="updated_by")
	private String updatedBy;

}
