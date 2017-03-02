package com.adserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableJpaRepositories("com.adserver.dao")
@ComponentScan({"com.adserver.controller","com.adserver.service","com.adserver.metadata"})
@EnableAutoConfiguration
@EntityScan("com.adserver.entity")
@Configuration
@SpringBootApplication
public class SimpleAdServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SimpleAdServerApplication.class, args);
	}

}
