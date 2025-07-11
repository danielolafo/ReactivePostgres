package com.reactive.postgres.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.reactive.postgres.service.JwtService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final JwtService jwtService;
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	//private final PasswordEncoder passwordEncoder;
	

    public SecurityConfig(
    		JwtService jwtService,
    		JwtAuthenticationFilter jwtAuthenticationFilter
    		) {
        this.jwtService = jwtService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http
        .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless API
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless session
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/auth/**").permitAll() // Public endpoints
            .anyRequest().authenticated() // All other requests require authentication
        )
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); // Add custom JWT filter

    // Handle unauthorized and forbidden access (optional but recommended)
    // .exceptionHandling(exceptions -> exceptions
    //     .authenticationEntryPoint(jwtAuthenticationEntryPoint)
    //     .accessDeniedHandler(jwtAccessDeniedHandler)
    // );

    return http.build();
    }

//    @Bean
//    AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(null); // Setting our custom user details service
//        provider.setPasswordEncoder(passwordEncoder); // Setting the password encoder
//        return provider;
//    }
}
