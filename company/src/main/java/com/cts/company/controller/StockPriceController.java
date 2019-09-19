package com.cts.company.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.company.entity.StockPrice;
import com.cts.company.service.StockPriceService;

@RestController
@RequestMapping("/stockprice")
@CrossOrigin
public class StockPriceController {
	
	private static String MESSAGE = "message";
	
	@Autowired
	StockPriceService stockPriceService;
	
	@GetMapping()
	public ResponseEntity<HashMap<String, Object>> listStockPrice(){
		List<StockPrice> list = new ArrayList<StockPrice>();
		list = stockPriceService.stockPriceList();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		HttpStatus status;
		if(list.size() == 0) {
			hashMap.put(MESSAGE, "No records were found");
			status = HttpStatus.BAD_REQUEST;
		}else {
			status = HttpStatus.OK;
			hashMap.put("result", list);
		}
		return new ResponseEntity<HashMap<String,Object>>(hashMap, status);
	}
}
