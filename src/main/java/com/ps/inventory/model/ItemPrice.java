package com.ps.inventory.model;

import java.math.BigDecimal;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Table(value="ItemPrice")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ItemPrice {
	
	@Id
	@Column("id")
	private Integer id;
	@Column("inventoryId")
	private Integer inventoryId;
	@Column("wholeSalePrice")
	private BigDecimal wholeSalePrice;
	@Column("retailPrice")
	private BigDecimal retailPrice;
	@Column("displayPrice")
	private BigDecimal displayPrice;
	@Column("salePrice")
	private BigDecimal salePrice;
	@Column("discountPercentage")
	private BigDecimal discountPercentage;

	
}
