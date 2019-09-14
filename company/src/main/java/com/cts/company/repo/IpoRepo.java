package com.cts.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.company.entity.IpoDetail;

public interface IpoRepo extends JpaRepository<IpoDetail, Integer>{
	IpoDetail findByIpoId(int id);
}
