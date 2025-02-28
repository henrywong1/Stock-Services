package com.stock.stockservice;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@EnableEncryptableProperties
@PropertySources({ @PropertySource("classpath:application.properties"), @PropertySource("classpath:env.properties") })
@SpringBootApplication
@EnableEurekaClient
public class StockServiceApplication implements RepositoryRestConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(StockServiceApplication.class, args);
	}

}
