package com.bhatta.management.util;

import java.text.DecimalFormat;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public String generateOtp() {
		String otp = new DecimalFormat("0000").format(new Random().nextInt(9999));
		return otp;
	}
	
	public void sendOtp(String to, String from,String otp,String subject) throws MessagingException{
		MimeMessage msg=javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(msg,true);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(otp);
		javaMailSender.send(msg);
	}
}
