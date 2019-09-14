package com.cts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="user")
@DynamicUpdate
public class User {

	@Id
	@Column(name = "us_id",length=11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	
	@Column(name = "us_name",length = 30,nullable = false,unique = true)
	String username;
	
	@Column(name = "us_password",length = 30,nullable = false)
	String password;
	
	@Column(name = "us_type",length = 30,nullable = false)
	String userType;
	
	@Column(name = "us_email",length = 30,nullable = false,unique = true)
	String email;
	
	@Column(name = "us_mobile",length = 20,nullable = false,unique = true)
	String mobile;
	
	@Column(name = "us_confirmed",length = 10,nullable = false)
	String confirmed;

	public User(int userId, String username, String password, String userType, String email, String mobile,
			String confirmed) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.email = email;
		this.mobile = mobile;
		this.confirmed = confirmed;
	}
	public User() {
		super();
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", userType=" + userType
				+ ", email=" + email + ", mobile=" + mobile + ", confirmed=" + confirmed + "]";
	}

	
	
	
	
}
