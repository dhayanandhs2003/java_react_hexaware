package com.example.managetask.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
        .csrf(csrf -> csrf.disable()) // Disable CSRF for testing in Postman
        .authorizeHttpRequests(auth -> auth
            // Allow GETs for anyone
            .requestMatchers(HttpMethod.GET, "/api/tasks/**").permitAll()
            
            // Require login for POST, PUT, DELETE
            .requestMatchers(HttpMethod.POST, "/api/tasks/**").authenticated()
            .requestMatchers(HttpMethod.PUT, "/api/tasks/**").authenticated()
            .requestMatchers(HttpMethod.DELETE, "/api/tasks/**").authenticated()

            // All other requests require login
            .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults()); // Basic authentication for simplicity

    return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userShekar = User.withDefaultPasswordEncoder()
                .username("shekar")
                .password("shekar@123")
                .roles("USER")
                .build();

        UserDetails userGiri = User.withDefaultPasswordEncoder()
                .username("giri")
                .password("giri@123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userShekar, userGiri);
    }
}

