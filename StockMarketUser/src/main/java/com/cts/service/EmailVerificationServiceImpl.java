package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cts.entity.User;

@Service
public class EmailVerificationServiceImpl implements EmailVerificationService {

	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public String sendVerificationEmail(User user) {
		String subject = "Stock Market Charting-Email Verification";
		String text = "To confirm your account, please click here : "+
		"http://localhost:8991/user/confirm-account/"+user.getUserId();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("stocktest37@outlook.com");
		message.setTo(user.getEmail());
		message.setSubject(subject);
		message.setText(text);
		try {
			javaMailSender.send(message);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("email link "+text);
		return "sent";
	}

}
