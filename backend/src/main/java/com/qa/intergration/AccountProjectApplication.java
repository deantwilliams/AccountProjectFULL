package com.qa.intergration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.qa.persistence.repository")
@ComponentScan("com.qa.persistence")
@EntityScan("com.qa.persistence.domain")
@ComponentScan(basePackageClasses = AccountsController.class)
public class AccountProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountProjectApplication.class, args);
	}
}
