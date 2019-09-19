package com.cts.company.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cts.company.service.ImportService;

@RestController
@RequestMapping("/import")
@CrossOrigin
public class ImportController {
	
	private static String MESSAGE = "message";
	
	@Autowired
	ImportService importService;

	@PostMapping()
	public ResponseEntity<HashMap<String, Object>> readExcelData(@RequestParam("file") MultipartFile excelFile) throws IOException {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		String message = importService.addStockPrice(excelFile);
		HttpStatus status;
		if(message.equals("added")) {
			status = HttpStatus.OK;
			hashMap.put(MESSAGE, "Data stored");
		}else {
			status = HttpStatus.BAD_REQUEST;
			hashMap.put(MESSAGE, "Error with excel sheet");
		}
		return new ResponseEntity<HashMap<String,Object>>(hashMap, status);
	}
}
