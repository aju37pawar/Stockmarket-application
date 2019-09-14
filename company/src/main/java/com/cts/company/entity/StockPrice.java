package com.cts.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock_price")
public class StockPrice {

	@Id
	private int compCode;
	
	@Column(name="st_exchange_name", nullable = false, length = 20, unique = true)
	private String stockExchangeName;
	
	@Column(name="current_price", nullable = false)
	private double currentPrice;
	
	@Column(name="date", length = 50)
	private String date;
	
	@Column(name="time", length = 50)
	private String time;

	public String getStockExchangeName() {
		return stockExchangeName;
	}

	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public StockPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCompCode() {
		return compCode;
	}

	public void setCompCode(int compCode) {
		this.compCode = compCode;
	}

	public StockPrice(int compCode, String stockExchangeName, double currentPrice, String date, String time) {
		super();
		this.compCode = compCode;
		this.stockExchangeName = stockExchangeName;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}

	@Override
	public String toString() {
		return "StockPrice [compCode=" + compCode + ", stockExchangeName=" + stockExchangeName + ", currentPrice="
				+ currentPrice + ", date=" + date + ", time=" + time + "]";
	}

	
	
	
}
