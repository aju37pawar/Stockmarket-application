package com.cts.service;

import java.util.HashMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="netflix-zuul-api-gateway-server")
public interface CompanyServiceProxy {

	@GetMapping("/stock-market-company/company")
	public ResponseEntity<HashMap<String, Object>> getAllCompany();
	
	@GetMapping("/stock-market-company/stockprice")
	public ResponseEntity<HashMap<String , Object>> getAllStockPrice();
}
