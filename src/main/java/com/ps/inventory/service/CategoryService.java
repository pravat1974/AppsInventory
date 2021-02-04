package com.ps.inventory.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.inventory.model.Category;
import com.ps.inventory.model.LimitConfig;
import com.ps.inventory.model.Limits;
import com.ps.inventory.repo.ReactiveCategoryRepository;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class CategoryService  {
	
	@Autowired
	private ReactiveCategoryRepository reactiveCategoryRepository;
	

	public Mono<Category> createCategory(Mono<Category> category) {
	Mono<Category> categoryData = category.flatMap(data->{
		return reactiveCategoryRepository.save(data);
	});
		return categoryData;
	}


	public Mono<Category> updateCategory(Mono<Category> category) {
	
		Mono<Category> categoryData = category.flatMap(data->{
			
			return reactiveCategoryRepository.findById(data.getId()).flatMap(result->{
			
				
				BeanUtils.copyProperties(data, result);
				
				return reactiveCategoryRepository.save(result);
			});
		});
		return categoryData;
	}


	public Mono<Category> deleteCategoryById(@Parameter(in = ParameterIn.PATH) String id) {
		return reactiveCategoryRepository.findById(Integer.valueOf(id))
				.flatMap(category->			
							this.reactiveCategoryRepository.delete(category)
							.thenReturn(category));
		
			
		
	}

	public Flux<Category> findAllCategory() {
		
		return reactiveCategoryRepository.findAll();
	}


	public Mono<Category> getCategoryById(@Parameter(in = ParameterIn.PATH) String id) {
		
		return reactiveCategoryRepository.findById(Integer.valueOf(id));
	}


	public Flux<Category> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	public Mono<LimitConfig> getLimits() {
		Limits l =new Limits();
		//l.setMaximum(1000);
	//	l.setMinimum(1);
		LimitConfig limitConfig = new LimitConfig(l.getMinimum(),l.getMaximum());
		System.out.println("limitz   "+l);
		System.out.println("limitConfig  "+limitConfig);
		return Mono.just(limitConfig);
	}


}
