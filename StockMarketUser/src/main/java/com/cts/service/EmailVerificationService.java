package com.cts.service;

import com.cts.entity.User;

public interface EmailVerificationService {

	public String sendVerificationEmail(User user);
}
