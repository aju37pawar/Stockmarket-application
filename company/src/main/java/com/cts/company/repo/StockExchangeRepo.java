package com.cts.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.company.entity.StockExchange;

public interface StockExchangeRepo extends JpaRepository<StockExchange, Integer>{

}
