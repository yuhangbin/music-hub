package com.cboy.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static String uri = "http://localhost:9000";

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator myRoute(RouteLocatorBuilder builder) {
		return builder.routes()
			// A route defined by a given identification(ID),
			// a destination(URI) and set of predicates and filters.
			.route("app", p -> p.path("/app/**")
				// filter - a standard Spring WebFilter
					.filters(f -> f.addResponseHeader("hello", "world"))
				// the URI for the route
					.uri(uri))
			.build();
	}

}
