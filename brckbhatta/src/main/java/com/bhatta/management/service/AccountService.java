package com.bhatta.management.service;

import javax.mail.MessagingException;

import com.bhatta.management.entity.Account;
import com.bhatta.management.exceptions.BrickBhattaException;

public interface AccountService {

	String saveDetails(Account accountDetails)throws MessagingException;

	Boolean verifyOtp(String otp)throws BrickBhattaException;

}
