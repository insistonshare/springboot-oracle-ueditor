package com.zhx.help;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.zhx.help.dao"})
public class ZhxHelpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZhxHelpApplication.class, args);
	}
}
