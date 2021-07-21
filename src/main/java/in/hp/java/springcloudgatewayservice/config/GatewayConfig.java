package in.hp.java.springcloudgatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p
                        .path("/user-api/**")
                        .uri("lb://USER-SERVICE"))
                .route(p -> p
                        .path("/book-api/**")
                        .uri("lb://BOOK-SERVICE"))
                .route(p -> p
                        .path("/library-api/**")
                        .uri("lb://LIBRARY-SERVICE"))
                .build();
    }
}
