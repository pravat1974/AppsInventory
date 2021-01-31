package com.ps.inventory.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import com.ps.inventory.exceptions.NoDataFoundException;
import com.ps.inventory.model.Inventory;
import com.ps.inventory.model.ItemPrice;
import com.ps.inventory.repo.ReactiveInventoryCrudRepository;
import com.ps.inventory.repo.ReactiveInventoryRepository;
import com.ps.inventory.repo.ReactiveItemPriceCrudRepository;
import com.ps.inventory.repo.ReactiveItemPriceRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Transactional
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private ReactiveInventoryRepository inventoryRepository;
	@Autowired
	private ReactiveInventoryCrudRepository reactiveInventoryCrudRepository;
	@Autowired
	private ReactiveItemPriceRepository reactiveItemPriceRepository;
	@Autowired
	private ReactiveItemPriceCrudRepository reactiveItemPriceCrudRepository;

	@Override
	public Mono<Inventory> createInventory(Mono<Inventory> inventory) {
		Mono<Inventory> inventoryData = inventory.flatMap(data -> {
			return reactiveInventoryCrudRepository.save(data);
		});
		return inventoryData;
	}

	@Override
	public Flux<Object> populateInventoryWithPrice(Mono<Inventory> inventory) {

		Mono<Inventory> inventoryData = inventory.flatMap(result -> {
			return this.reactiveInventoryCrudRepository.save(result);
		});
		Mono<ItemPrice> itemPriceData = inventory.flatMap(itemPrice -> {
			return this.reactiveItemPriceCrudRepository.save(itemPrice.getItemPrice());
		});

		return Mono.zip(inventoryData, itemPriceData).flatMapMany(data -> {

			Inventory inventoryZip = data.getT1();
			ItemPrice itemPriceZip = data.getT2();
			inventoryZip.setItemPriceId(itemPriceZip.getId());
			itemPriceZip.setInventoryId(inventoryZip.getId());
			inventoryZip.setItemPrice(itemPriceZip);
			inventoryRepository.updateInventory(inventoryZip);
			reactiveItemPriceRepository.updateItemPrice(itemPriceZip);
			return Mono.just(inventoryZip);
		});

	}

	private Mono<ItemPrice> saveItemPrice(Mono<Inventory> inventory) {
		return inventory.flatMap(data -> {
			ItemPrice itemPrice = data.getItemPrice();
			itemPrice.setInventoryId(data.getId());
			return this.reactiveItemPriceCrudRepository.save(itemPrice);
		});
  
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
