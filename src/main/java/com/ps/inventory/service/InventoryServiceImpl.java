package com.ps.inventory.service;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ps.inventory.dtos.InventoryDTO;
import com.ps.inventory.exceptions.NoDataFoundException;
import com.ps.inventory.model.Inventory;
import com.ps.inventory.repo.ReactiveInventoryCrudRepository;
import com.ps.inventory.repo.ReactiveInventoryRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private ReactiveInventoryRepository inventoryRepository;
	@Autowired
	private ReactiveInventoryCrudRepository reactiveInventoryCrudRepository;

	@Override
	public Mono<Inventory> createInventory(Mono<Inventory> inventory) {
		Mono<Inventory> inventoryData = inventory.flatMap(data -> {
			return reactiveInventoryCrudRepository.save(data);
		});
		return inventoryData;
	}

	@Override
	public Mono<Inventory> deleteInventoryById(Integer id) {
		return reactiveInventoryCrudRepository.findById(id)
				.flatMap(inventory -> reactiveInventoryCrudRepository.delete(inventory).thenReturn(inventory));

	}

	@Override
	public Flux<Inventory> findAllInventory() {

		return reactiveInventoryCrudRepository.findAll();
	}

	@Override
	public Mono<Inventory> getInventoryById(Integer id) {

		return reactiveInventoryCrudRepository.findById(id);
	}

	@Override
	public Flux<Inventory> getInventoryByCriteria() {

		return null;
	}

	@Override
	public Mono<Inventory> updateInventory(Mono<Inventory> inventory) {
		return inventory.flatMap(data -> {

			return reactiveInventoryCrudRepository.findById(data.getId()).flatMap(result -> {
				if (result == null) {
					return Mono
							.error(new NoDataFoundException(HttpStatus.NOT_FOUND, "Inventory data is not available"));
				}
				return reactiveInventoryCrudRepository.findById(data.getId());
			});

		});

	}
}
