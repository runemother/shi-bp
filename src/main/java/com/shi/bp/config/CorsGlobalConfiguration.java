package com.shi.bp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@EnableWebFlux
public class CorsGlobalConfiguration implements WebFluxConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins(CorsConfiguration.ALL)
				.allowedMethods("GET", "POST", "PUT", "DELETE")
				.allowedHeaders(CorsConfiguration.ALL)
				.allowCredentials(false)
				.maxAge(3600);
	}
}