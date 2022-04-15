package com.bhatta.management.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="brick_details")
public class BrickDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="brick_id")
	private BrickMaster brickMaster;
	
	@Column(name="brick_quantity")
	private Long brickQuantity;
	
	@Column(name="brick_price")
	private Double brickPrice;
	
	@Column(name="account_id")
	private Long accountId;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BrickMaster getBrickMaster() {
		return brickMaster;
	}

	public void setBrickMaster(BrickMaster brickMaster) {
		this.brickMaster = brickMaster;
	}

	public Long getBrickQuantity() {
		return brickQuantity;
	}

	public void setBrickQuantity(Long brickQuantity) {
		this.brickQuantity = brickQuantity;
	}

	public Double getBrickPrice() {
		return brickPrice;
	}

	public void setBrickPrice(Double brickPrice) {
		this.brickPrice = brickPrice;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	} 
	
	
}
