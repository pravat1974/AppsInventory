package com.ps.inventory.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ps.inventory.model.Category;
import com.ps.inventory.repo.ReactiveCategoryRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private ReactiveCategoryRepository reactiveCategoryRepository;
	@Override
	public Mono<Category> createCategory(Mono<Category> category) {
	Mono<Category> categoryData = category.flatMap(data->{
		return reactiveCategoryRepository.save(data);
	});
		return categoryData;
	}

	@Override
	public Mono<Category> updateCategory(Mono<Category> category) {
		Mono<Category> categoryData = category.flatMap(data->{
			return reactiveCategoryRepository.findById(89).flatMap(result->{
				BeanUtils.copyProperties(data, result);
				return reactiveCategoryRepository.save(result);
			});
		});
		return null;
	}

	@Override
	public Mono<Category> deleteCategoryById(Integer id) {
		return reactiveCategoryRepository.findById(id).flatMap(category->
			
			this.reactiveCategoryRepository.delete(category).thenReturn(category));
		
			
		
	}

	@Override
	public Flux<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Category> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Category> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
