package com.bhatta.management.entity;

import java.time.YearMonth;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRawValue;

public class TransactionMaster {

	@OneToOne(cascade = CascadeType.REMOVE, mappedBy = "customerId")
	private Customer customer;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "account_id")
	private Account accountId;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date createdOn;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date updatedOn;

}
