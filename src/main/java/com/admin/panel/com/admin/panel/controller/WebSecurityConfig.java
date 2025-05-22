/**package com.admin.panel.com.admin.panel.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF para pruebas con Postman
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll()  // Permite acceso sin login a tu API
                        .anyRequest().authenticated()            // El resto sí requiere autenticación
                )
                .formLogin(Customizer.withDefaults()); // Usa autenticación básica (opcional para pruebas)

        return http.build();
    }
}*/
