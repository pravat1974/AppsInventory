package com.ps.inventory.service;


import com.ps.inventory.model.Inventory;

import io.swagger.v3.oas.annotations.Operation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface InventoryService {
	public Mono<Inventory> updateInventory(Mono<Inventory> inventory);
	Mono<Inventory> deleteInventoryById(Integer id);
	@Operation(description = "Find  all the Inventories")
	public Flux<Inventory> findAllInventory();
	public Mono<Inventory> getInventoryById(Integer id);
	public Flux<Inventory> getInventoryByCriteria();
	Mono<Inventory> createInventory(Mono<Inventory> inventory);
	Flux<Object> populateInventoryWithPrice(Mono<Inventory> inventory);
	

}

