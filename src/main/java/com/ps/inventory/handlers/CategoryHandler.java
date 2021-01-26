package com.ps.inventory.handlers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.ps.inventory.model.Category;
import com.ps.inventory.service.CategoryService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Component
public class CategoryHandler {
	private static Mono<ServerResponse> notFound = ServerResponse.notFound().build();
	
	@Autowired
	private CategoryService categoryService;

	public CategoryHandler(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	public Mono<ServerResponse> createCategory(ServerRequest serverRequest ) {
		Mono<Category> category = serverRequest.bodyToMono(Category.class);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(categoryService.createCategory(category), Category.class).switchIfEmpty(notFound);

	}
	public Mono<ServerResponse> getCategoryById(ServerRequest serverRequest ) {
	Integer id = new Integer(serverRequest.pathVariable("Id"));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(categoryService.findById(id), Category.class).switchIfEmpty(notFound);

	}

	public Mono<ServerResponse> updateCategory(ServerRequest serverRequest) {
		Mono<Category> category =	serverRequest.bodyToMono(Category.class);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(categoryService.updateCategory(category), Category.class).switchIfEmpty(notFound);

	}

	public Mono<ServerResponse> deleteCategoryById(ServerRequest serverRequest ) {
		Integer id = new Integer(serverRequest.pathVariable("id"));
      	return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(categoryService.deleteCategoryById(id), Category.class).switchIfEmpty(notFound);

	}

	public Mono<ServerResponse> findAllCategory(ServerRequest serverRequest) {
		Flux<Category> category = categoryService.findAllCategory();
		return ServerResponse.ok().contentType(APPLICATION_JSON)
				.body(category, Category.class)
				.switchIfEmpty(notFound);

	}
}
