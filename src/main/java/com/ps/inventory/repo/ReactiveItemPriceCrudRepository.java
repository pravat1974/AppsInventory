package com.ps.inventory.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.ps.inventory.model.ItemPrice;

public interface ReactiveItemPriceCrudRepository extends ReactiveCrudRepository<ItemPrice, Integer> {

}
