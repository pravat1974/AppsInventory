package com.ps.inventory.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Table(value="Inventory")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Inventory implements Persistable<Integer> {

	@Id
	@Column("id")
	private Integer id;
	@Column("inventoryName")
	private String inventoryName;
	@Transient
	private  List<Product> product;
	@Column("creationDate")
	private LocalDateTime creationDate;
	@Column("startDate")
	private LocalDateTime startDate;
	@Column("endDate")
	private LocalDateTime endDate;
	@Column("displayName")
	private String displayName;
	@Column("description")
	private String description;
	@Column("catalogrefId")
	private Integer catalogrefId;
	@Column("availStatus")
	private String  availStatus;
	@Column("availabilityDate")
	private LocalDate availabilityDate;
	@Column("backorderLevel")
	private Integer stockLevel;
	@Column("inventoryName")
	private Integer backorderLevel;
	@Column("preorderLevel")
	private Integer preorderLevel;
	@Column("stockThresh")
	private Integer stockThresh;
	@Column("backorderThresh")
	private Integer backorderThresh;
	@Column("preorderThresh")
	private Integer preorderThresh;
	
	@Transient
	private boolean newInventory;

	
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
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
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
			return id;
	}
	@Override
	public boolean isNew() {
		  return this.newInventory || id == null;
	}
	
	


}
