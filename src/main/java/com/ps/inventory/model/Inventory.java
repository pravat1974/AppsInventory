package com.ps.inventory.model;
import java.time.LocalDate;

import java.util.List;
import java.util.Set;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



@Table(value="Inventory")

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
public class Inventory implements Persistable<Integer> {

	@Id
	@Column("id")
	private Integer id;
	@Column("inventoryName")
	private String inventoryName;
	@Transient
	private  List<Product> product;
	
	private LocalDate creationDate;
	private LocalDate startDate;
	private LocalDate endDate;
	private String displayName;
	private String description;
	private Integer catalogrefId;
	private String  availStatus;
	private LocalDate availabilityDate;
	private Integer stockLevel;
	private Integer backorderLevel;
	private Integer preorderLevel;
	private Integer stockThresh;
	private Integer backorderThresh;
	private Integer preorderThresh;

	
	
	
	public Inventory() {
		super();
	}



	public String getInventoryName() {
		return inventoryName;
	}



	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}



	public List<Product> getProduct() {
		return product;
	}



	public void setProduct(List<Product> product) {
		this.product = product;
	}



	public LocalDate getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}



	public LocalDate getStartDate() {
		return startDate;
	}



	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}



	public LocalDate getEndDate() {
		return endDate;
	}



	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}



	public String getDisplayName() {
		return displayName;
	}



	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Integer getCatalogrefId() {
		return catalogrefId;
	}



	public void setCatalogrefId(Integer catalogrefId) {
		this.catalogrefId = catalogrefId;
	}



	public String getAvailStatus() {
		return availStatus;
	}



	public void setAvailStatus(String availStatus) {
		this.availStatus = availStatus;
	}



	public LocalDate getAvailabilityDate() {
		return availabilityDate;
	}



	public void setAvailabilityDate(LocalDate availabilityDate) {
		this.availabilityDate = availabilityDate;
	}



	public Integer getStockLevel() {
		return stockLevel;
	}



	public void setStockLevel(Integer stockLevel) {
		this.stockLevel = stockLevel;
	}



	public Integer getBackorderLevel() {
		return backorderLevel;
	}



	public void setBackorderLevel(Integer backorderLevel) {
		this.backorderLevel = backorderLevel;
	}



	public Integer getPreorderLevel() {
		return preorderLevel;
	}



	public void setPreorderLevel(Integer preorderLevel) {
		this.preorderLevel = preorderLevel;
	}



	public Integer getStockThresh() {
		return stockThresh;
	}



	public void setStockThresh(Integer stockThresh) {
		this.stockThresh = stockThresh;
	}



	public Integer getBackorderThresh() {
		return backorderThresh;
	}



	public void setBackorderThresh(Integer backorderThresh) {
		this.backorderThresh = backorderThresh;
	}



	public Integer getPreorderThresh() {
		return preorderThresh;
	}



	public void setPreorderThresh(Integer preorderThresh) {
		this.preorderThresh = preorderThresh;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	@Override
	public Integer getId() {

		return null;
	}



	@Override
	public boolean isNew() {

		return false;
	}

	
	
	

}
