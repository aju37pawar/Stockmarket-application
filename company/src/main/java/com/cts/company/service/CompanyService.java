package com.cts.company.service;

import java.util.List;

import com.cts.company.entity.Company;

public interface CompanyService {

	List<Company> companyList();
	String addCompany(Company company);
	String updateCompany(Company company);
	String activationStatus(int id);
	
}
