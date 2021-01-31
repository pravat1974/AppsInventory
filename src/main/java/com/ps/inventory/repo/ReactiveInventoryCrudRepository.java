package com.ps.inventory.repo;


import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.ps.inventory.model.Inventory;

import reactor.core.publisher.Mono;



public interface ReactiveInventoryCrudRepository extends ReactiveCrudRepository<Inventory, Integer>{
@Query("Update Inventory set itemPriceId=? where id=?")	
public Mono<Inventory> updateInventory(Integer itemPriceId,Integer id);

}
