package com.inatel.quotationmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuotationManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuotationManagementApplication.class, args);
	}
}