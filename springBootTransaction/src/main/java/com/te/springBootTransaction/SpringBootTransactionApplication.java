package com.te.springBootTransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SpringBootTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTransactionApplication.class, args);
	}
	
	@Scheduled(fixedRate = 3000)
	public void get() {
		System.out.println("hellow");
	}
}
