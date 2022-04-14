package com.bhatta.management.service;

import java.time.LocalTime;
import java.util.Objects;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bhatta.management.entity.Account;
import com.bhatta.management.entity.OtpBucket;
import com.bhatta.management.exceptions.BrickBhattaException;
import com.bhatta.management.repository.AccountRepository;
import com.bhatta.management.repository.OtpBucketRepository;
import com.bhatta.management.util.CommonUtil;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private OtpBucketRepository bucketRepository;
	
	@Autowired
	private CommonUtil commonUtil;
	
	@Override
	public String saveDetails(Account accountDetails) throws MessagingException {
		try {
			Account account = accountRepository.save(accountDetails);
			String otp = commonUtil.generateOtp();
			OtpBucket otpBucket = new OtpBucket();
			if (Objects.nonNull(account)) {
				otpBucket.setOtp(otp);
				otpBucket.setAccountId(account.getAccountId());
				otpBucket.setEmail(account.getEmail());
				otpBucket.setOtpExpireTime(LocalTime.now().plusMinutes(5));
				bucketRepository.save(otpBucket);
				commonUtil.sendOtp(account.getEmail(), "mdsalim10040@gmail.com", otp, "Account verification Mail");
				return "Otp sent successfully to your email";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean verifyOtp(String otp) throws BrickBhattaException {
		try {
			OtpBucket otpBucketData = bucketRepository.findByOtp(otp);
			if (Objects.nonNull(otpBucketData)) {
				if (otpBucketData.getOtpExpireTime().equals(LocalTime.now())
						|| otpBucketData.getOtpExpireTime().isBefore(LocalTime.now())) {
					Optional<Account> account = accountRepository.findById(otpBucketData.getAccountId());
					if (account.isPresent()) {
						account.get().setIsVerified(true);
						accountRepository.save(account.get());
						return true;
					}
				} else {
					throw new BrickBhattaException("Otp has been expired");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
