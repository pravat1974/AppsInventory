package com.ps.inventory.handlers;

import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.ps.inventory.model.Category;
import com.ps.inventory.model.LimitConfig;
import com.ps.inventory.service.CategoryService;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component

public class CategoryHandler {
	private static String SERVICE_NAME = "/inventory-service/category";
	private static Mono<ServerResponse> notFound = ServerResponse.notFound().build();

	@Autowired
	private CategoryService categoryService;
	


	public CategoryHandler(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	@Bean
	public RouterFunction<ServerResponse> routerFunction() {
		return route().GET(SERVICE_NAME,
				this::findAllCategory,
				ops -> ops.beanClass(CategoryService.class).beanMethod("findAllCategory")).build()
				
				.and(route().GET(SERVICE_NAME + "/limits", this::getLimits,
						ops -> ops.beanClass(CategoryService.class).beanMethod("getLimits"))
						.build())
						.and(route().POST(SERVICE_NAME + "/create",
								this::createCategory,
								ops -> ops.beanClass(CategoryService.class).beanMethod("createCategory")).build())
						.and(route().PUT(SERVICE_NAME + "/update",  this::updateCategory,
								ops -> ops.beanClass(CategoryService.class).beanMethod("updateCategory")).build())
						.and(route().DELETE(SERVICE_NAME + "/delete/{id}",
								this::deleteCategoryById,
								ops -> ops.beanClass(CategoryService.class).beanMethod("deleteCategoryById"))
								.build())
						
						.and(route().GET(SERVICE_NAME + "/{id}", 
								this::getCategoryById,
								ops -> ops.beanClass(CategoryService.class).beanMethod("getCategoryById"))
								.build());
						//.and()
						
	}

	public Mono<ServerResponse> createCategory(ServerRequest serverRequest) {
		Mono<Category> category = serverRequest.bodyToMono(Category.class);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(categoryService.createCategory(category), Category.class).switchIfEmpty(notFound);

	}
	
	public Mono<ServerResponse> getLimits(ServerRequest serverRequest) {
		System.out.println(".....Calling getLimits .....");
		
		  return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
		  .body(categoryService.getLimits(),
		  LimitConfig.class).switchIfEmpty(notFound);
		 
		
		//return notFound;
	}


	public Mono<ServerResponse> getCategoryById(ServerRequest serverRequest) {
		
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(categoryService.getCategoryById(serverRequest.pathVariable("id")), Category.class).switchIfEmpty(notFound);

	}

	public Mono<ServerResponse> updateCategory(ServerRequest serverRequest) {
		
		Mono<Category> category = serverRequest.bodyToMono(Category.class);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(categoryService.updateCategory(category), Category.class).switchIfEmpty(notFound);

	}

	public Mono<ServerResponse> deleteCategoryById(ServerRequest serverRequest) {
		Integer id = new Integer(serverRequest.pathVariable("id"));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(categoryService.deleteCategoryById(serverRequest.pathVariable("id")), Category.class).switchIfEmpty(notFound);

	}

	public Mono<ServerResponse> findAllCategory(ServerRequest serverRequest) {
		Flux<Category> category = categoryService.findAllCategory();
		return ServerResponse.ok().contentType(APPLICATION_JSON).body(category, Category.class).switchIfEmpty(notFound);

	}
}
