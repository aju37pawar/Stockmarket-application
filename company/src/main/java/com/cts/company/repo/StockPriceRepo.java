package com.cts.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.company.entity.StockPrice;

public interface StockPriceRepo extends JpaRepository<StockPrice, Integer> {

}
