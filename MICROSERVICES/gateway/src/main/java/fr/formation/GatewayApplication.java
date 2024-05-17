package fr.formation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            // Configuration pour aller vers produit service
            .route(r ->
                r   .path("/api/produit/**")
                    .uri("lb://produit-service")
            )
            
            // Configuration pour aller vers commentaire service
            .route(r ->
                r   .path("/api/commentaire/**")
                    .uri("lb://commentaire-service")
            )

            .build();
    }
}
