package com.br.varejista;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API Varejista",
				version = "1.0",
				description = "Documentação da API Varejista"
		)
)
public class VarejistaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VarejistaApplication.class, args);
	}

}
