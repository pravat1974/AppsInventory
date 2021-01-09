package com.ps.inventory.service;

import static io.r2dbc.pool.PoolingConnectionFactoryProvider.MAX_SIZE;
import static io.r2dbc.spi.ConnectionFactoryOptions.DATABASE;
import static io.r2dbc.spi.ConnectionFactoryOptions.DRIVER;
import static io.r2dbc.spi.ConnectionFactoryOptions.HOST;
import static io.r2dbc.spi.ConnectionFactoryOptions.PASSWORD;
import static io.r2dbc.spi.ConnectionFactoryOptions.PORT;
import static io.r2dbc.spi.ConnectionFactoryOptions.USER;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.ps.inventory.model.Inventory;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface InventoryService {
	
	public Mono<Inventory> createInventory(Inventory inventory);
	public Mono<Inventory> updateInventory(Inventory inventory);
	public Mono<Void> deleteUser(Integer id);
	public Flux<Inventory> geAllInventory();
	public Mono<Inventory> getInventory(Integer id);
	public Flux<Inventory> getInventoryByCriteria();

}

