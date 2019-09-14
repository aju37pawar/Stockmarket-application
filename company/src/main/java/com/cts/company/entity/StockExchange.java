package com.cts.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock_exchange")
public class StockExchange {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stock_id")
	private int stockId;
	
	@Column(name="st_exchange_name", nullable = false, length = 20, unique = true)
	private String stockExchangeName;
	
	@Column(name="brief", length = 40)
	private String brief;
	
	@Column(name="address", length = 50)
	private String address;
	
	@Column(name="remark", length = 50)
	private String remark;

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getStockExchangeName() {
		return stockExchangeName;
	}

	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public StockExchange(int stockId, String stockExchangeName, String brief, String address, String remark) {
		super();
		this.stockId = stockId;
		this.stockExchangeName = stockExchangeName;
		this.brief = brief;
		this.address = address;
		this.remark = remark;
	}

	public StockExchange() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StockExchange [stockId=" + stockId + ", stockExchangeName=" + stockExchangeName + ", brief=" + brief
				+ ", address=" + address + ", remark=" + remark + "]";
	}
	
	
}
