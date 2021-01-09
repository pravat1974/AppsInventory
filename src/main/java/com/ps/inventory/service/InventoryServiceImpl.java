package com.ps.inventory.service;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ps.inventory.dtos.InventoryDTO;
import com.ps.inventory.model.Inventory;
import com.ps.inventory.repo.ReactiveInventoryRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private ReactiveInventoryRepository inventoryRepository;

	private InventoryDTO  convert(Inventory inventory){
		InventoryDTO dto = new InventoryDTO();
       BeanUtils.copyProperties(inventory, dto);
       return dto;
	}

	@Override
	public Mono<Inventory> createInventory(Inventory inventory) {
		
		return inventoryRepository.save(inventory);
	}

	@Override
	public Mono<Inventory> updateInventory(Inventory inventory) {
		
		return inventoryRepository.update(inventory);
	}

	@Override
	public Mono<Void> deleteUser(Integer id) {
		return inventoryRepository.findById(id).flatMap(inventoryRepository::delete) ;
	}

	@Override
	public Flux<Inventory> geAllInventory() {
	
		return inventoryRepository.findAll();
	}

	@Override
	public Mono<Inventory> getInventory(Integer id) {
	
		return inventoryRepository.findById(id);
	}

	@Override
	public Flux<Inventory> getInventoryByCriteria() {
	
		return null;
	}

}
