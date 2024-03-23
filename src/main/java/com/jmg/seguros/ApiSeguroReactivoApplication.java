package com.jmg.seguros;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EntityScan("com.jmg.seguros.model")
@EnableR2dbcRepositories
public class ApiSeguroReactivoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSeguroReactivoApplication.class, args);
	}

}
