package fr.formation.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // http.formLogin(Customizer.withDefaults());

        http.httpBasic(Customizer.withDefaults());

        http.authorizeHttpRequests(authorize -> {
            authorize.requestMatchers("/**").authenticated();
            // authorize.requestMatchers("/**").permitAll();
        });

        // Configuration protection CSRF (désactiver cette protection - généralement on fait ça quand on a des jetons JWT)
        http.csrf(csrf -> csrf.disable());

        // Configuration CORS générale
        http.cors(cors -> {
            CorsConfigurationSource source = request -> {
                CorsConfiguration config = new CorsConfiguration();

                config.setAllowedHeaders(List.of("*"));
                config.setAllowedMethods(List.of("*"));
                config.setAllowedOrigins(List.of("*"));

                return config;
            };

            cors.configurationSource(source);
        });

        // Authentification par jeton JWT Keycloak
        http.oauth2ResourceServer(server -> {
            server.jwt(Customizer.withDefaults());
        });

        return http.build();
    }

    // @Bean
    UserDetailsService inMemory(PasswordEncoder passwordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        System.out.println("Mot de passe hashé 1 : " + passwordEncoder.encode("123456"));
        System.out.println("Mot de passe hashé 2 : " + passwordEncoder.encode("123456"));

        manager.createUser(
            User.withUsername("jeremy")
                // .password("{noop}123456")
                .password(passwordEncoder.encode("123456"))
                .roles("USER")
                .build()
        );

        return manager;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
