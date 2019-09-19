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

import com.cts.company.entity.IpoDetail;
import com.cts.company.service.IpoService;

@RestController
@RequestMapping("/ipo")
@CrossOrigin
public class IpoController {

	private static String MESSAGE = "message";
	
	@Autowired
	IpoService ipoService;
	
	@PostMapping()
	public ResponseEntity<HashMap<String, Object>> ipoUpdate(@RequestBody IpoDetail ipoDetail) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		String check = ipoService.updateIpo(ipoDetail);
		HttpStatus status;
		if (check.equals("updated") || check.equals("created")) {
			status = HttpStatus.OK;
			hashMap.put(MESSAGE, "updated ipo details");			
		} else {
			status = HttpStatus.BAD_REQUEST;
			hashMap.put(MESSAGE, "error updating ipo details");
		}
		return new ResponseEntity<HashMap<String, Object>>(hashMap, status);
	}
	
	@GetMapping()
	public ResponseEntity<HashMap<String, Object>> ipoList(){
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<IpoDetail> ipoList = new ArrayList<IpoDetail>();
		ipoList = ipoService.listIpo();
		HttpStatus status;
		if(ipoList.size()==0) {
			hashMap.put(MESSAGE, "No IpoList was found");
			status = HttpStatus.BAD_REQUEST;
		}else {
			hashMap.put("Result", ipoList);
			status = HttpStatus.OK;
		}
		return new ResponseEntity<HashMap<String,Object>>(hashMap, status);
		
	}
}
