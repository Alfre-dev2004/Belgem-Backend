package com.belgem.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desactiva CSRF para permitir POST/PUT/DELETE desde Postman
                .csrf(csrf -> csrf.disable())

                // Permite acceso libre a todos los endpoints del módulo articulos
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/articulos/**").permitAll()
                        .anyRequest().permitAll() // también puedes dejar todo público mientras desarrollas
                )

                // Desactiva autenticación básica y formulario
                .httpBasic(httpBasic -> httpBasic.disable())
                .formLogin(form -> form.disable());

        return http.build();
    }
}
