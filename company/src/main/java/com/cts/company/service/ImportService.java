package com.cts.company.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImportService {

	String addStockPrice(MultipartFile readExcelFile);
}
