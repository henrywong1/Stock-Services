package com.historicalservice.historicalservice;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@EnableEurekaClient
@PropertySources({ @PropertySource("classpath:application.properties"), @PropertySource("classpath:env.properties") })
@EnableEncryptableProperties
@SpringBootApplication
public class HistoricalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HistoricalServiceApplication.class, args);
	}

}
