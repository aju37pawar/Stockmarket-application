package com.cts.company.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cts.company.entity.Company;
import com.cts.company.entity.IpoDetail;
import com.cts.company.repo.CompanyRepo;
import com.cts.company.repo.IpoRepo;

@Service("ipoService")
public class IpoServiceImpl implements IpoService {

	@Autowired
	IpoRepo ipoRepo;
	
	@Autowired
	CompanyRepo compRepo;
	
	@Transactional
	@Override
	public String updateIpo(IpoDetail ipoDetail) {
		String message = null;
		IpoDetail detailUpdate = new IpoDetail();
		try {
//		System.out.println("--------------------------<----------------<"+ipoDetail.);
			detailUpdate = ipoRepo.findByIpoId(ipoDetail.getIpoId());
			if (detailUpdate != null) {
				detailUpdate.setCompanyName(ipoDetail.getCompanyName());
				detailUpdate.setDate(ipoDetail.getDate());
				detailUpdate.setPricePerShare(ipoDetail.getPricePerShare());
				detailUpdate.setStockExchange(ipoDetail.getStockExchange());
				detailUpdate.setTotalShare(ipoDetail.getTotalShare());
				ipoRepo.save(detailUpdate);
				message = "updated";
			} else {
				Company company = compRepo.findByCompanyName(ipoDetail.getCompanyName());
				ipoDetail.setCompany(company);
				ipoRepo.save(ipoDetail);
				message = "created";
			}
		} catch (Exception e) {
			message = "error";
		}
		return message;
	}

	@Override
	public List<IpoDetail> listIpo() {
		List<IpoDetail> ipoList = new ArrayList<IpoDetail>();
		ipoList = ipoRepo.findAll(Sort.by(Sort.Direction.ASC, "date"));
		return ipoList;
	}
}
