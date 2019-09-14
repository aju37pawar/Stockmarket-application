package com.cts.company.service;

import java.util.List;

import com.cts.company.entity.StockExchange;

public interface StockExchangeService {

	List<StockExchange> stockExchangeList();
	String addStockExchange(StockExchange stockExchange);
}
