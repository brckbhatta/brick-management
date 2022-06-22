package com.bhatta.management.entity;

import java.io.Serializable;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "ledger_master")
public class LedgerMaster implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ledger_id")
	private Long ledgerId;

	@Column(name = "last_year_amount")
	private Double lastYearAmount;

	@Column(name = "year")
	private Year year;
	
	@Column(name = "month")
	private Month month;

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

	@Column(name = "account_id")	
	private Long accountId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "firm_id")
	private FirmMaster firmMaster;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id")
	private Customer customer;

}
