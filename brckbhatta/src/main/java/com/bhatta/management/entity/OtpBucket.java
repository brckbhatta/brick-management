package com.bhatta.management.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="otp_bucket")
public class OtpBucket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="account_id")
	private Long accountId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="otp")
	private String otp;
	
	@Column(name="otp_expire_time")
	private LocalTime otpExpireTime;
	
}
