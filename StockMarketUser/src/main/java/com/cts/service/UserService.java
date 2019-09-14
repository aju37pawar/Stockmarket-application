package com.cts.service;

import com.cts.entity.User;

public interface UserService {
	String register(User user);
	User signIn(User user);
	String verifyUserEmail(int userId);
	String updateProfile(User user);
}
