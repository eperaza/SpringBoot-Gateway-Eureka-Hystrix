package com.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
    
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/end1/**")
                		.filters(f -> f.hystrix(h -> h.setName("Hystrix")
                				.setFallbackUri("forward:/fallback/message")))
                        .uri("lb://end1")
                        .id("end1"))
                .route(r -> r.path("/end2/**")
                		.filters(f -> f.hystrix(h -> h.setName("Hystrix")
                				.setFallbackUri("forward:/fallback/message")))
                        .uri("lb://end2")
                        .id("end2"))
                .build();
    }

}