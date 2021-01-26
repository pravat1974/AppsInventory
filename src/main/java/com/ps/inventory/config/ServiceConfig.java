package com.ps.inventory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ps.inventory.service.CategoryService;
import com.ps.inventory.service.CategoryServiceImpl;
import com.ps.inventory.service.InventoryService;
import com.ps.inventory.service.InventoryServiceImpl;



@Configuration
public class ServiceConfig {
	
	@Bean
	public InventoryService inventoryService(){
		  return new InventoryServiceImpl(); 
	  }
	@Bean
	public CategoryService categoryService(){
		  return new CategoryServiceImpl(); 
	  }

}
