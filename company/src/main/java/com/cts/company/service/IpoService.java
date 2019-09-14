package com.cts.company.service;

import java.util.List;

import com.cts.company.entity.IpoDetail;

public interface IpoService {

	List<IpoDetail> listIpo();
	String updateIpo(IpoDetail ipoDetail);
}
