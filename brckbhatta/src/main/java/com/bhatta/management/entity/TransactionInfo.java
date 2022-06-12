package com.bhatta.management.entity;

import java.time.YearMonth;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRawValue;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ledger_transaction")
public class TransactionInfo {
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customerId")
	private Customer customer;
	
	@Column(name = "transaction_info")
	@JsonRawValue
	private String transactionInfo; //amount, Transaction type, date, Balance, particular
	
	@Column(name="yearMonth")
	private YearMonth yearMonth;
	
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
