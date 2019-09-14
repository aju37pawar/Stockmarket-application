package com.cts.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.company.entity.Sector;

public interface SectorRepo extends JpaRepository<Sector, Integer>{
	Sector findBySecName(String secName);
}
