package com.example.clasificacionweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * Mapeamos el Main para que coja el conector de la BBDD
 * 
 * @autor Javier
 * 
 * @see com.example.controller
 * 
 * @version 1.0
 */
@SpringBootApplication(scanBasePackages={"com.example.controller", "com.example.services"})
public class ClasificacionwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClasificacionwebApplication.class, args);
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}
