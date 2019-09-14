package com.cts.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.company.entity.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer> {
	Company findByCompanyName(String companyName);
	Company findByCompanyId(int companyId);
}
