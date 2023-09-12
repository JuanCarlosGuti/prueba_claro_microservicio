package com.example.pruebaclaro.msvcusuarios;

import org.springdoc.core.*;
import org.springdoc.webmvc.ui.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsvcUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcUsuariosApplication.class, args);
	}

	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder()
				.group("api")
				.pathsToMatch("/api/usuarios/**") // Reemplaza con el patrón de tus rutas de API
				.build();
	}

	@Bean
	public SpringDocConfigProperties springDocConfigProperties() {
		return new SpringDocConfigProperties();
	}

	@Bean
	public SwaggerUiOAuthProperties swaggerUiOAuthProperties() {
		return new SwaggerUiOAuthProperties();
	}

	@Bean
	public SwaggerConfig swaggerConfig() {
		return new SwaggerConfig();
	}

	@Bean
	public SwaggerUiConfigParameters swaggerUiConfigParameters() {
		SwaggerUiConfigProperties swaggerUiConfigProperties = new SwaggerUiConfigProperties();
		return new SwaggerUiConfigParameters(swaggerUiConfigProperties);
	}


}
