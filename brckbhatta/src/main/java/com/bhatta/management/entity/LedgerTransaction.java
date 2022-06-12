package com.bhatta.management.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ledger_transaction")
public class LedgerTransaction {
	
	@OneToOne(cascade = CascadeType.REMOVE, mappedBy = "customerId")
	private Customer customer;

}
