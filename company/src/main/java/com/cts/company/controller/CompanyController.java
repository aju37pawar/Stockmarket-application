package com.cts.company.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.company.entity.Company;
import com.cts.company.service.CompanyServiceImpl;

@RestController
@RequestMapping("/company")
@CrossOrigin
public class CompanyController {

	private static String MESSAGE = "message";

	@Autowired
	CompanyServiceImpl companyServiceImpl;

	@GetMapping()
	public ResponseEntity<HashMap<String, Object>> listCompany() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<Company> company = new ArrayList<Company>();
		HttpStatus status;
		company = companyServiceImpl.companyList();
		if (company.size() == 0) {
			hashMap.put("message", "No records available");
			status = HttpStatus.FORBIDDEN;
		} else {
			hashMap.put("result", company);
			status = HttpStatus.OK;
		}
		return new ResponseEntity<HashMap<String, Object>>(hashMap, status);
	}

	@PostMapping()
	public ResponseEntity<HashMap<String, Object>> companyAdd(@RequestBody Company company) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		String check = companyServiceImpl.addCompany(company);
		HttpStatus status;
		if (check.equals("added")) {
			status = HttpStatus.OK;
			hashMap.put(MESSAGE, "added company");
		} else {
			status = HttpStatus.FORBIDDEN;
			hashMap.put(MESSAGE, "error adding company");
		}
		return new ResponseEntity<HashMap<String, Object>>(hashMap, status);
	}

	@PostMapping("/update")
	public ResponseEntity<HashMap<String, Object>> companyUpdate(@RequestBody Company company) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		String check = companyServiceImpl.updateCompany(company);
		HttpStatus status;
		if (check.equals("updated")) {
			status = HttpStatus.OK;
			hashMap.put(MESSAGE, "updated company");
		} else {
			status = HttpStatus.BAD_REQUEST;
			hashMap.put(MESSAGE, "error updating company");		
		}
		return new ResponseEntity<HashMap<String, Object>>(hashMap, status);
	}

	@GetMapping("/{id}")
	public ResponseEntity<HashMap<String, Object>> activation(@PathVariable int id) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		String check = companyServiceImpl.activationStatus(id);
		HttpStatus status;
		if (check.equals("activated") || check.equals("deactivated")) {
			status = HttpStatus.OK;
			hashMap.put(MESSAGE, "Activation status updated");			
		} else {
			status = HttpStatus.BAD_REQUEST;
			hashMap.put(MESSAGE, "error in activation status");
		}
		return new ResponseEntity<HashMap<String, Object>>(hashMap, status);
	}

	
}
