package com.cts.company.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.company.entity.StockExchange;
import com.cts.company.service.StockExchangeServiceImpl;

@RestController
@RequestMapping("/stockExchange")
@CrossOrigin
public class StockExchangeController {
	
	private static String MESSAGE = "message";
	
	@Autowired
	StockExchangeServiceImpl serviceImpl;
	
	@GetMapping()
	public ResponseEntity<List<StockExchange>> listStockExchange(){
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<StockExchange> stockExchange = new ArrayList<StockExchange>();
		stockExchange = serviceImpl.stockExchangeList();
		HttpStatus status;
		if(stockExchange.size()==0) {
			status = HttpStatus.BAD_REQUEST;
			hashMap.put(MESSAGE, "No records Found");
			return new ResponseEntity<List<StockExchange>>(stockExchange, status);
		}else {
			status = HttpStatus.OK;
			hashMap.put(MESSAGE, "Records Found");
			return new ResponseEntity<List<StockExchange>>(stockExchange, status);
		}
		
	}
	
	@PostMapping()
	public ResponseEntity<HashMap<String, Object>> stockExchangeAdd(@RequestBody StockExchange stockExchange){
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		String check = serviceImpl.addStockExchange(stockExchange);
		HttpStatus status = null;
		if(check.equals("added")) {
			status = HttpStatus.OK;
			hashMap.put(MESSAGE, "added stock exchange");
		}else if(check.equals("error")) {
			status = HttpStatus.BAD_REQUEST;
			hashMap.put(MESSAGE, "error adding stock exchange");
		}
		return new ResponseEntity<HashMap<String,Object>>(hashMap, status);
	}

}
