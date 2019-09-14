package com.cts.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.User;
import com.cts.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("confirm-account/{userid}")
	public ResponseEntity<String> verifyUserEmail(@PathVariable() int userid) {

		userService.verifyUserEmail(userid);

		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@PostMapping()
	public ResponseEntity<String> registerUser(@RequestBody User user) {

		String result = userService.register(user);
		String responseMessage = "";
		if (result.equals("duplicate")) {
			responseMessage = "Email/Phone Number/Username Already Exists";
			return new ResponseEntity<String>(responseMessage, HttpStatus.FORBIDDEN);
		} else {
			responseMessage = "Registered Successfully";
			return new ResponseEntity<String>(responseMessage, HttpStatus.CREATED);
		}

	}

	@PostMapping("/login")
	public ResponseEntity<HashMap<String, Object>> signIn(@RequestBody User user) {

		User userData = null;
		HashMap<String, Object> map = new HashMap<String, Object>();
		userData = userService.signIn(user);
		HttpStatus status;

		if (userData != null) {
			if (userData.getUserType().equals("user")) {
				if (userData.getConfirmed().equals("no")) {
					map.put("message", "Invalid Credentials.");
					status = HttpStatus.UNAUTHORIZED;
				} else {
					map.put("result", userData);
					status = HttpStatus.ACCEPTED;
					System.out.println(status);
				}
			} else {
				map.put("result", userData);
				status = HttpStatus.ACCEPTED;
			}
		} else {
			map.put("message", "Invalid Credentials.");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<>(map, status);

	}

	@PostMapping("/edit")
	public ResponseEntity<String> updateUserProfile(@RequestBody User userData) {
		String updateResponse = userService.updateProfile(userData);
		HttpStatus status;
		String message = "";
		if (updateResponse.equals("error")) {
			status = HttpStatus.NOT_MODIFIED;
			message = "Unable to update data";
		} else {

			status = HttpStatus.ACCEPTED;
			message = "Record updated";
		}
		return new ResponseEntity<>(message, status);
	}
}
