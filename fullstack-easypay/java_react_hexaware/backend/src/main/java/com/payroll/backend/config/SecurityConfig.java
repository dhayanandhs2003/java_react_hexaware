package com.payroll.backend.config;

import com.payroll.backend.security.JwtAuthenticationFilter;
import com.payroll.backend.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Autowired
    private JwtAuthenticationFilter jwtAuthFilter;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    // ✅ Password Encoder Bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // ✅ Authentication Provider
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    // ✅ Authentication Manager Bean
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // ✅ Security Filter Chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .cors(cors -> cors.configurationSource(request -> {
            var config = new CorsConfiguration();
            config.setAllowedOrigins(List.of("http://localhost:3001"));
            config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
            config.setAllowedHeaders(List.of("*"));
            config.setAllowCredentials(true);
            return config;
        }))
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
            	    .requestMatchers("/api/auth/**").permitAll()

            	    // Admin + Super Admin
            	    .requestMatchers("/api/users/**").hasAnyRole("ADMIN_HR", "SUPER_ADMIN")
            	    .requestMatchers("/api/employees/**").hasAnyRole("ADMIN_HR", "EMPLOYEE", "SUPER_ADMIN")
            	    .requestMatchers("/api/policies/**").hasAnyRole("ADMIN_HR", "SUPER_ADMIN")
            	    .requestMatchers("/api/audit-logs/**").hasAnyRole("ADMIN_HR", "SUPER_ADMIN")

            	    // Payroll Processor
            	    .requestMatchers(HttpMethod.POST, "/api/payrolls").hasAnyRole("PAYROLL_PROCESSOR", "SUPER_ADMIN")
            	    .requestMatchers(HttpMethod.PUT, "/api/payrolls").hasAnyRole("PAYROLL_PROCESSOR", "SUPER_ADMIN")
            	    .requestMatchers(HttpMethod.POST, "/api/benefits/**").hasAnyRole("PAYROLL_PROCESSOR", "SUPER_ADMIN")
            	    .requestMatchers(HttpMethod.PUT, "/api/benefits/**").hasAnyRole("PAYROLL_PROCESSOR", "SUPER_ADMIN")

            	    // Employee
            	    .requestMatchers("/api/notifications/**").hasAnyRole("EMPLOYEE", "SUPER_ADMIN")
            	    .requestMatchers("/api/leave-requests/**").hasAnyRole("EMPLOYEE", "SUPER_ADMIN")
            	    .requestMatchers("/api/timesheets/**").hasAnyRole("EMPLOYEE", "PAYROLL_PROCESSOR", "MANAGER_SUPERVISOR", "SUPER_ADMIN")

            	    // Manager/Supervisor
            	    .requestMatchers(HttpMethod.PUT, "/api/leave-requests/**").hasAnyRole("MANAGER_SUPERVISOR", "SUPER_ADMIN")

            	    // Common test access
            	    .requestMatchers("/api/test/**").hasAnyRole("EMPLOYEE", "ADMIN_HR", "PAYROLL_PROCESSOR", "MANAGER_SUPERVISOR", "SUPER_ADMIN")

            	    .anyRequest().authenticated()
            	)

            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider())
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

