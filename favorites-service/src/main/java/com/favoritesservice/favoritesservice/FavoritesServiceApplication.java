package com.favoritesservice.favoritesservice;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@EnableEncryptableProperties
@PropertySources({ @PropertySource("classpath:application.properties"), @PropertySource("classpath:env.properties") })
@EnableEurekaClient
@SpringBootApplication
public class FavoritesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavoritesServiceApplication.class, args);
	}

}
