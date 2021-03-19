package com.apigateway;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.security.oauth2.gateway.TokenRelayGatewayFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@EnableEncryptableProperties
@PropertySources({ @PropertySource("classpath:application.properties"), @PropertySource("classpath:env.properties") })
@EnableEurekaClient
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Autowired
	TokenRelayGatewayFilterFactory filterFactory;

	// Defining routes with loadbalance uris
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("stock-service",
						r -> r.path("/stocks", "/stocks/{symbol}").filters(f -> f.filter(filterFactory.apply()))
								.uri("lb://stock-service"))
				.route(("dividend-service"),
						r -> r.path("/dividends", "/dividends/{symbol}").filters(f -> f.filter(filterFactory.apply()))
								.uri("lb://dividend-service/"))
				.route(("favorites-service"),
						r -> r.path("/favorites", "/favorites/add/{symbol}")
								.filters(f -> f.filter(filterFactory.apply())).uri("lb://favorites-service"))
				.route(("news-service"), r -> r.path("/news", "/news/{symbol}", "/news/add")
						.filters(f -> f.filter(filterFactory.apply())).uri("lb://news-service"))
				.build();
	}

}
