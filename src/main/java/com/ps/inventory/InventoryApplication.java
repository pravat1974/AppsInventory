package com.ps.inventory;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

//@EnableEurekaClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Inventory APIs", version = "1.0", description = "Documentation APIs v1.0"))
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	@Bean
	public GroupedOpenApi inventoryOpenApi() {
		String[] paths = { "/inventory-service/inventory/**" };
		return GroupedOpenApi.builder().group("Inventory").pathsToMatch(paths).build();
	}
	@Bean
	public GroupedOpenApi categoryOpenApi() {
		String[] paths = { "/inventory-service/category/**" };
		return GroupedOpenApi.builder().group("Category").pathsToMatch(paths).build();
	}

}
