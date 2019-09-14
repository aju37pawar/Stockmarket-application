package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("com.cts.service")
public class StockMarketUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMarketUserApplication.class, args);
	}

}
