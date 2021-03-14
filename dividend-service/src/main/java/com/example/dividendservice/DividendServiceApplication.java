package com.example.dividendservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@EnableConfigurationProperties
@PropertySources({ @PropertySource("classpath:application.properties"), @PropertySource("classpath:env.properties") })
@EnableEurekaClient
@SpringBootApplication
public class DividendServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DividendServiceApplication.class, args);
	}

}
