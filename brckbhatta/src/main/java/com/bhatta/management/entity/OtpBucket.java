package com.bhatta.management.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public LocalTime getOtpExpireTime() {
		return otpExpireTime;
	}

	public void setOtpExpireTime(LocalTime otpExpireTime) {
		this.otpExpireTime = otpExpireTime;
	}
	
}
