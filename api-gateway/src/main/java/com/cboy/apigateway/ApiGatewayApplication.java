package com.cboy.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
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
			.route("fallback", p -> p.host("*.circuitbreaker.com")
				.filters(f -> f.circuitBreaker(config -> config
					.setName("mycmd")
					.setFallbackUri("forward:/fallback")))
				.uri(uri))
			.build();
	}

	@RequestMapping(path = "/fallback")
	public Mono<String> fallback() {
		return Mono.just("fallback");
	}

}
