package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmailOrUsernameOrMobile(String email,String username,String mobile);

	public User findByEmailAndPassword(String email, String password);

	public User findByUserId(int userId);
}
