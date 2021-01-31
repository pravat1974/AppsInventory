package com.ps.inventory.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.data.relational.core.query.Update;
import org.springframework.data.relational.core.query.Query;
import org.springframework.data.relational.core.query.Update;
import com.ps.inventory.model.Inventory;
import com.ps.inventory.model.ItemPrice;

import static org.springframework.data.relational.core.query.Criteria.where;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SuppressWarnings("unused")
@Component
public class ReactiveItemPriceRepository {

	@Autowired
	private R2dbcEntityTemplate r2dbcEntityTemplate;

	
	public Mono<Integer> updateItemPrice(ItemPrice itemPrice) {
		
		 return this.r2dbcEntityTemplate.update(
	                Query.query(where("id").is(itemPrice.getId())),
	                Update.update("inventoryId", itemPrice.getInventoryId()),
	                ItemPrice.class
	        );

	}
}

