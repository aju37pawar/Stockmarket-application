package com.cts.company.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.company.entity.StockExchange;
import com.cts.company.repo.StockExchangeRepo;

@Service("stockExchangeService")
public class StockExchangeServiceImpl implements StockExchangeService{

	@Autowired
	StockExchangeRepo exchangeRepo;
	
	@Transactional
	@Override
	public List<StockExchange> stockExchangeList() {
		List<StockExchange> stockExchange = new ArrayList<StockExchange>();
		stockExchange = exchangeRepo.findAll();
		return stockExchange;
	}

	@Transactional
	@Override
	public String addStockExchange(StockExchange stockExchange) {
		String message = null;
		try {
			exchangeRepo.save(stockExchange);
			message = "added";
		}catch(Exception exception) {
			message = "error";
		}
		return message;
	}

}
