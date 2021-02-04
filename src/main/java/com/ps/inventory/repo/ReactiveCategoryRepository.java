package com.ps.inventory.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.ps.inventory.model.Category;

public interface ReactiveCategoryRepository extends ReactiveCrudRepository<	Category, Integer> {

	
	
}
