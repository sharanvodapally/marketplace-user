package com.marketplace.marketplaceuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MarketplaceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketplaceUserApplication.class, args);
	}

}