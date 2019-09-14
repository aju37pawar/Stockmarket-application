package com.cts.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ipo_detail")
public class IpoDetail {
	
//	@OneToOne(mappedBy = "ipoDetail", cascade = CascadeType.ALL)
//	private Company company;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ipoId;

	@Column(name="comp_name", nullable = false, length = 40)
	private String companyName;
	
	@Column(name="stock_exchange", nullable = false, length = 15)
	private String stockExchange;
	
	@Column(name="price_per_share", nullable = false)
	private double pricePerShare;
	
	@Column(name="total_share", nullable = false)
	private double totalShare;
	
	@Column(name="date", nullable = false, length = 15)
	private String date;

	@OneToOne
	@JoinColumn(name="comp_id")
	private Company company;
	
//	public Company getCompany() {
//		return company;
//	}
//
//	public void setCompany(Company company) {
//		this.company = company;
//	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getIpoId() {
		return ipoId;
	}

	public void setIpoId(int ipoId) {
		this.ipoId = ipoId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public double getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public double getTotalShare() {
		return totalShare;
	}

	public void setTotalShare(double totalShare) {
		this.totalShare = totalShare;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public IpoDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IpoDetail(int ipoId, String companyName, String stockExchange, double pricePerShare, double totalShare,
			String date, Company company) {
		super();
		this.ipoId = ipoId;
		this.companyName = companyName;
		this.stockExchange = stockExchange;
		this.pricePerShare = pricePerShare;
		this.totalShare = totalShare;
		this.date = date;
		this.company = company;
	}

	@Override
	public String toString() {
		return "IpoDetail [ipoId=" + ipoId + ", companyName=" + companyName + ", stockExchange=" + stockExchange
				+ ", pricePerShare=" + pricePerShare + ", totalShare=" + totalShare + ", date=" + date + ", company="
				+ company + "]";
	}
	
	
}
