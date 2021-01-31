package com.ps.inventory.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Table(value="Inventory")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Inventory implements Persistable<Integer> {

	@Id
	@Column("id")
	private Integer id;
	@Column("inventoryName")
	private String inventoryName;
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
	@Column("catagoryId")
	private Integer catagoryId;
	@Column("availStatus")
	private String  availStatus;
	@Column("availabilityDate")
	private LocalDate availabilityDate;
	@Column("stockLevel")
	private Integer stockLevel;
	@Column("stockThresh")
	private Integer stockThresh;
	@Column("itemPriceId")
	private Integer itemPriceId;
	@Transient
	private ItemPrice itemPrice;
	
	
	@Transient
	private boolean newInventory;

	
	public String getInventoryName() {
		return inventoryName;
	}
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
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
	public Integer getCatagoryId() {
		return catagoryId;
	}
	public void setCatalogrefId(Integer catagoryId) {
		this.catagoryId = catagoryId;
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
	
	public Integer getStockThresh() {
		return stockThresh;
	}
	public void setStockThresh(Integer stockThresh) {
		this.stockThresh = stockThresh;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public Integer getId() {
			return id;
	}
	
	
	public Integer getItemPriceId() {
		return itemPriceId;
	}
	public void setItemPriceId(Integer itemPriceId) {
		this.itemPriceId = itemPriceId;
	}
	public ItemPrice getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(ItemPrice itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	@Override
	public boolean isNew() {
		  return this.newInventory || id == null;
	}
	
	


}
