package com.ps.inventory.repo;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.ps.inventory.model.Inventory;



public interface ReactiveInventoryCrudRepository extends ReactiveCrudRepository<Inventory, Integer>{
	


}
