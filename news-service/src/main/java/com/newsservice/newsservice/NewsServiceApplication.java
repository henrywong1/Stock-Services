package com.newsservice.newsservice;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.reactive.function.client.WebClient;

@EnableEncryptableProperties
@PropertySources({ @PropertySource("classpath:application.properties"), @PropertySource("classpath:env.properties") })
@EnableEurekaClient
@SpringBootApplication
public class NewsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsServiceApplication.class, args);
	}

	// Build a webclient that is annotated with Bean, making it a singleton when
	// used anywhere in this application
	@Bean
	@LoadBalanced
	WebClient.Builder loadBalancedWebClientBuilder() {
		return WebClient.builder();
	}
}
