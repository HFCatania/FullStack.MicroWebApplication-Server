package com.beansbeans.moneyapp;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;




@SpringBootApplication
@EnableJpaRepositories
public class MoneyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneyappApplication.class, args);
	}


}
