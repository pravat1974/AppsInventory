package com.ps.inventory.service;


import com.ps.inventory.model.ItemPrice;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItemPriceService {

	Mono<ItemPrice> createCategory(Mono<ItemPrice> itemPrice);
	Mono<ItemPrice> updateCategory(Mono<ItemPrice> itemPrice);
	Mono<ItemPrice>  deleteCategoryById(Integer id);
	Flux<ItemPrice> findAllCategory();
	Mono<ItemPrice> findById(Integer id);


}