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
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
		return builder.routes().route("stock-service",
				r -> r.path("/stocks/**")
						.filters(f -> f.filter(filterFactory.apply())
								.hystrix(c -> c.setName("stocks-fb").setFallbackUri("forward:/stocks-fallback")))
						.uri("lb://stock-service"))
				.route(("dividend-service"),
						r -> r.path("/dividends/**")
								.filters(f -> f.filter(filterFactory.apply()).hystrix(
										c -> c.setName("dividend-fb").setFallbackUri("forward:/dividend-fallback")))
								.uri("lb://dividend-service/"))
				.route(("favorites-service"),
						r -> r.path("/favorites/**")
								.filters(f -> f.filter(filterFactory.apply()).hystrix(
										c -> c.setName("favorites-fb").setFallbackUri("forward:/favorites-fallback")))
								.uri("lb://favorites-service"))
				.route(("news-service"),
						r -> r.path("/news/**")
								.filters(f -> f.filter(filterFactory.apply())
										.hystrix(c -> c.setName("news-fb").setFallbackUri("forward:/news-fallback")))
								.uri("lb://news-service"))
				.route(("historical-service"),
						r -> r.path("/historical/**")
								.filters(f -> f.filter(filterFactory.apply()).hystrix(
										c -> c.setName("historical-fb").setFallbackUri("forward:/historical-fallback")))
								.uri("lb://historical-service"))
				.route(("company-service"),
						r -> r.path("/company/**")
								.filters(f -> f.filter(filterFactory.apply()).hystrix(
										c -> c.setName("company-fb").setFallbackUri("forward:/company-fallback")))
								.uri("lb://company-service"))
				.build();
	}

	@Bean
	@LoadBalanced
	WebClient.Builder loadBalancedWebClientBuilder() {
		return WebClient.builder();
	}

}
