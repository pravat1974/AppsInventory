package com.ps.inventory.controller;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.inventory.dtos.InventoryDTO;

import com.ps.inventory.model.Inventory;
import com.ps.inventory.service.InventoryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/inventory/")
public class InventoryController {

	// @Autowired
	private InventoryService inventoryService;

	public InventoryController(InventoryService inventoryService) {
		super();
		this.inventoryService = inventoryService;
	}

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Inventory> createInventory(@RequestBody InventoryDTO inventoryDto) {
		Inventory inventory = new Inventory();

		BeanUtils.copyProperties(inventoryDto, inventory, "ID");

		

		inventory.setCreatedTime(LocalDateTime.now());
		inventory.setLastUpdatedTime(LocalDateTime.now());

		return inventoryService.createUser(inventory);

	}

	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Inventory> updateUser(@RequestBody InventoryDTO inventoryDto) {
		Inventory inventory = new Inventory();

		BeanUtils.copyProperties(inventoryDto, inventory);

		return inventoryService.updateInventory(inventory);

	}

	@PutMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Void> deleteUser(@PathVariable Integer id) {
	
		return inventoryService.deleteUser(id);

	}

	@GetMapping(value = "/findAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<InventoryDTO> findAllUser() {
		   	Flux<InventoryDTO> inventory = inventoryService.geAllInventory()
				.map(new Function<Inventory, InventoryDTO>() {
						public InventoryDTO apply(Inventory inventory) {
							InventoryDTO dto = new InventoryDTO();
							BeanUtils.copyProperties(inventory, dto);
							return dto;
			}
		});
  
		return inventory;

	}

}
