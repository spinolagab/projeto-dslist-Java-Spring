package com.devsuperior.dslist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Esta classe configura o cors no backend

@Configuration
public class WebConfig {
	
	// Se a variavel de ambiente nao existe libera para o local em application.properties 
	// Se tiver uma variavel de ambiente libera para ela e eh passada para a variavel
	@Value("${cors.origins}")
	private String corsOrigins;
	
	// Classe do framework para configurar o cors
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// permite o acesso aos enderecos que estiverem nessa variavel corsOrigins
				registry.addMapping("/**").allowedMethods("*").allowedOrigins(corsOrigins);
			}
		};
	}
	
}