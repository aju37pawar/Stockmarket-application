package com.cts.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.cts.company.repo.CompanyRepo;
import com.cts.company.repo.IpoRepo;
import com.cts.company.repo.SectorRepo;
import com.cts.company.repo.StockExchangeRepo;

@EnableEurekaClient
@SpringBootApplication
public class CompanyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CompanyApplication.class, args);
	}

	@Autowired
	SectorRepo sectorRepo;
	
	@Autowired
	CompanyRepo compRepo;
	
	@Autowired
	IpoRepo ipoRepo;
	
	@Autowired
	StockExchangeRepo exchangeRepo;
	
	@Override
	public void run(String... args) throws Exception {
		runSector();	
		runCompany();
		runIpo();
		runStockExchange();
		runStockPrice();
	}

	private void runStockPrice() {
			
	}

	private void runStockExchange() {
//		StockExchange exchange = new StockExchange();
//		exchange.setStockExchangeName("BSE");
//		exchange.setBrief("One of the best");
//		exchange.setAddress("Ghar ke peeche");
//		exchange.setRemark("Atb");
//		
//		exchangeRepo.save(exchange);
		
	}

	private void runIpo() {
//		IpoDetail ipoDetail = new IpoDetail();
//		Company company = compRepo.findByCompanyName("Son Pari");
//		ipoDetail.setCompanyName(company.getCompanyName());
//		ipoDetail.setId(company.getCompanyId());
//		ipoDetail.setDate("22/08/2019");
//		ipoDetail.setPricePerShare(1000);
//		ipoDetail.setTotalShare(40000);
//		ipoDetail.setStockExchange("BSE");
//		
//		ipoRepo.save(ipoDetail);
	}
	
	private void runCompany() {
//		Company company = new Company();
//		Sector sector = sectorRepo.findBySecName("IT");
//		company.setCeo("Kirti");
//		company.setAbout("Best");
//		company.setBoardOfDirectors("None");
//		company.setCompanyName("Son Pari");
//		company.setTurnover(20000);
//		company.setSector(sector);
//		
//		compRepo.save(company);
		
	}

	private void runSector() {
//		Sector sector = new Sector();
//		sector.setSecName("Marketing");
//		sector.setSectorBrief("Not Best");
//		sectorRepo.save(sector);
	}
	
	
}
