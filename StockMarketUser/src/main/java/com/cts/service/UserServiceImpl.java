package com.cts.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.User;
import com.cts.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	EmailVerificationService emailVerification;

	@Override
	@Transactional()
	public String register(User user) {
		String result = null;
		try {
			User data = repository.findByEmailOrUsernameOrMobile(user.getEmail(), user.getUsername(), user.getMobile());
			System.out.println("userData > " + data);
			if (data == null) {
				repository.save(user);
				result = "added";
				emailVerification.sendVerificationEmail(user);
			} else
				result = "duplicate";

		} catch (Exception e) {
			result = "duplicate";
		}

		return result;
	}

	@Override
	@Transactional
	public User signIn(User user) {
		User userData = repository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		return userData;
	}

	@Override
	@Transactional
	public String verifyUserEmail(int userId) {
		User userData = repository.findByUserId(userId);
		System.out.println("Data >> " + userData);

		if (userData.getConfirmed().equals("no")) {
			userData.setConfirmed("yes");
			repository.save(userData);
			System.out.println("userData > " + userData);
		}
		return null;
	}

	@Override
	@Transactional
	public String updateProfile(User user) {
		User userData = repository.findByUserId(user.getUserId());
		String response="";
		if(userData != null) {
			userData.setMobile(user.getMobile());
			userData.setPassword(user.getPassword());
			response = "updated";
			repository.save(userData);
		}else {
			response =  "error";
		}
		return response;
	}
}
