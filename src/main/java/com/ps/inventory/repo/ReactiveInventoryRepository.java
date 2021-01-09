package com.ps.inventory.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Component;

import com.ps.inventory.model.Inventory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ReactiveInventoryRepository {

	@Autowired
	private R2dbcEntityTemplate r2dbcEntityTemplate;

	public Mono<Inventory> save(Inventory entity) {

		return r2dbcEntityTemplate.insert(entity);
	}

	public Mono<Inventory> update(Inventory entity) {

		return r2dbcEntityTemplate.update(entity);
	}

	public Flux<Inventory> findAll() {
		return r2dbcEntityTemplate.select(Inventory.class).all();

	}

	public Flux<Inventory> findByEmail(String email) {

		return this.r2dbcEntityTemplate.select(Inventory.class)
				.matching(Query.query(Criteria.where("email").is(email)))
				.all();
	}

	public Flux<Inventory> findByMobile(String mobile) {

		return this.r2dbcEntityTemplate.select(Inventory.class)
				.matching(Query.query(Criteria.where("email").is(mobile))).all();

	}

	public Mono<Inventory> findById(Integer id) {
		return this.r2dbcEntityTemplate.
				selectOne(Query.query(Criteria.where("id").is(id)), Inventory.class);
	}


	public  Mono<Void> delete(Inventory inventory){
		return this.r2dbcEntityTemplate.delete(inventory).then();
	}
		
	}


