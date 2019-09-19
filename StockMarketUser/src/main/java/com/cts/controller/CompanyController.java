package com.cts.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.service.CompanyServiceProxy;

@RestController
@RequestMapping("/user-company")
@CrossOrigin
public class CompanyController {
	@Autowired
	CompanyServiceProxy companyServiceProxy;
	
	@GetMapping()
	public ResponseEntity<HashMap<String, Object>> getAllCompany() {
		System.out.println(">>>>>>>>>> "+companyServiceProxy.getAllCompany());
		return companyServiceProxy.getAllCompany();
	}
	
	@GetMapping("/stockprice")
	public ResponseEntity<HashMap<String, Object>> getAllStockPrice(){
		System.out.println(">>>>>>>>>"+ companyServiceProxy.getAllStockPrice());
		return companyServiceProxy.getAllStockPrice();
		
	}
}
