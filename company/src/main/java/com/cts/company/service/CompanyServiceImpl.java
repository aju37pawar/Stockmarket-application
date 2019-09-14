package com.cts.company.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.company.entity.Company;
import com.cts.company.repo.CompanyRepo;

@Service("/compService")
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepo compRepo;

	@Transactional
	@Override
	public List<Company> companyList() {
		List<Company> compList = new ArrayList<Company>();
		compList = compRepo.findAll();
		return compList;
	}

	@Transactional
	@Override
	public String addCompany(Company company) {
		String message = null;
		try {
			compRepo.save(company);
			message = "added";
		} catch (Exception exception) {
			message = "error";
		}
		return message;
	}

	@Transactional
	@Override
	public String updateCompany(Company company) {
		String message = null;
		Company companyUpdate = new Company();
		companyUpdate = compRepo.findByCompanyId(company.getCompanyId());
		companyUpdate.setAbout(company.getAbout());
		companyUpdate.setBoardOfDirectors(company.getBoardOfDirectors());
		companyUpdate.setCeo(company.getCeo());
		companyUpdate.setCompanyName(company.getCompanyName());
		companyUpdate.setSector(company.getSector());
		companyUpdate.setTurnover(company.getTurnover());
		try {
			compRepo.save(companyUpdate);
			message = "updated";
		} catch (Exception exception) {
			message = "error";
		}
		return message;
	}

	@Transactional
	@Override
	public String activationStatus(int id) {
		String message = null;
		Company company = new Company();
		company = compRepo.findByCompanyId(id);
		try {
			if (company.getActivation() == 1) {
				company.setActivation(0);
				compRepo.save(company);
				message = "deactivated";
			} else {
				company.setActivation(1);
				compRepo.save(company);
				message = "activated";
			}
		} catch (Exception e) {
			message = "error";
		}
		return message;
	}

}
