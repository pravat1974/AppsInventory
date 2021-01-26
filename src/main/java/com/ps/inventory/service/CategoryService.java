package com.ps.inventory.service;

import com.ps.inventory.model.Category;
import com.ps.inventory.model.Inventory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryService {

	Mono<Category> createCategory(Mono<Category> category);
	Mono<Category> updateCategory(Mono<Category> category);
	Mono<Category>  deleteCategoryById(Integer id);
	Flux<Category> findAllCategory();
	Mono<Category> findById(Integer id);
	Flux<Category> findByName(String name);

}
