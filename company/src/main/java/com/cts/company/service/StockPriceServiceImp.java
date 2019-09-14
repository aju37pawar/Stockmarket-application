package com.cts.company.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.company.entity.StockPrice;
import com.cts.company.repo.StockPriceRepo;

@Service("stockPriceService")
public class StockPriceServiceImp implements StockPriceService {

	@Autowired
	StockPriceRepo stockPriceRepo;

	@Transactional
	@Override
	public List<StockPrice> stockPriceList() {
		List<StockPrice> stockPriceList = new ArrayList<StockPrice>();
		stockPriceList = stockPriceRepo.findAll();
		return stockPriceList;
	}

}
