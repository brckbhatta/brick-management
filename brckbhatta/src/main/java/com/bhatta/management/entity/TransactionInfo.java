package com.bhatta.management.entity;

import java.io.Serializable;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
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
public class TransactionInfo implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="cust_id")
	private Customer customer;
	
	@Column(name = "transaction_info")
	@JsonRawValue
	private String transactionInfo; //amount, Transaction type, date, Balance, particular
	
	@Column(name = "year")
	private Year year;
	
	@Column(name = "month")
	private Month month;
	
	@Column(name = "account_id")
	private Long accountId;
	
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
