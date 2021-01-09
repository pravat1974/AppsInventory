package com.ps.inventory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ps.inventory.service.InventoryService;
import com.ps.inventory.service.InventoryServiceImpl;



@Configuration
public class ServiceConfig {
	
	@Bean
	public InventoryService inventotyService(){
		  return new InventoryServiceImpl(); 
	  }

}
