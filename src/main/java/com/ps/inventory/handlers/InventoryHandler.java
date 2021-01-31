package com.ps.inventory.handlers;

import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import com.ps.inventory.dtos.InventoryDTO;
import com.ps.inventory.model.Inventory;
import com.ps.inventory.service.InventoryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class InventoryHandler {
	private static String SERVICE_NAME = "/api/inventory-service";
	private static Mono<ServerResponse> notFound = ServerResponse.notFound().build();
	@Autowired
	// @Qualifier("serviceInventory")
	private InventoryService inventoryService;

	@Bean
	public RouterFunction<ServerResponse> monoRouterInventoryFunction() {
		return route()
				.GET(SERVICE_NAME + "/inventories", accept(APPLICATION_JSON), this::findAllInventory,
						ops -> ops.beanClass(InventoryService.class).beanMethod("findAllInventory"))
				.build()
				.and(route().GET(SERVICE_NAME + "/inventory/{id}", accept(APPLICATION_JSON), this::getInventoryById,
						ops -> ops.beanClass(InventoryService.class).beanMethod("getInventoryById")).build())
				.and(route().POST(SERVICE_NAME + "/inventory/create", accept(APPLICATION_JSON), this::createInventory,
						ops -> ops.beanClass(InventoryService.class).beanMethod("createInventory")).build())

				.and(route().PUT(SERVICE_NAME + "/inventory/update", accept(APPLICATION_JSON), this::updateInventory,
						ops -> ops.beanClass(InventoryService.class).beanMethod("updateInventory")).build())
				.and(route()
						.DELETE(SERVICE_NAME + "/inventory/delete/{id}", accept(APPLICATION_JSON), this::deleteInventoryById,
								ops -> ops.beanClass(InventoryService.class).beanMethod("deleteInventoryById"))
						.build());
	}

	public Mono<ServerResponse> createInventory(ServerRequest serverRequest) {
		Mono<Inventory> inventory = serverRequest.bodyToMono(Inventory.class);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(inventoryService.createInventory(inventory), Inventory.class).switchIfEmpty(notFound);

	}

	public Mono<ServerResponse> getInventoryById(ServerRequest serverRequest) {
		Integer id = new Integer(serverRequest.pathVariable("id"));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(inventoryService.getInventoryById(id), Inventory.class).switchIfEmpty(notFound);

	}

	public Mono<ServerResponse> updateInventory(ServerRequest serverRequest) {
		Mono<Inventory> inventory = serverRequest.bodyToMono(Inventory.class);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(inventoryService.updateInventory(inventory), Inventory.class).switchIfEmpty(notFound);

	}

	public Mono<ServerResponse> deleteInventoryById(ServerRequest serverRequest) {

		Integer id = new Integer(serverRequest.pathVariable("id"));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(inventoryService.deleteInventoryById(id), Inventory.class).switchIfEmpty(notFound);

	}

	public Mono<ServerResponse> findAllInventory(ServerRequest serverRequest) {
		Flux<Inventory> inventory = inventoryService.findAllInventory();

		return ServerResponse.ok().contentType(APPLICATION_JSON).body(inventory, Inventory.class)
				.switchIfEmpty(notFound);

	}
}
