package com.ps.inventory.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Table(value="ItemPrice")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemPrice  implements Persistable<Integer>  {
	
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
	@Column("lastModifiedDate")
    private LocalDateTime lastModifiedDate;
	@Column("userName")
	 @LastModifiedBy
    private String userName;
    @Transient
	private boolean newItemPrice;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}
	public BigDecimal getWholeSalePrice() {
		return wholeSalePrice;
	}
	public void setWholeSalePrice(BigDecimal wholeSalePrice) {
		this.wholeSalePrice = wholeSalePrice;
	}
	public BigDecimal getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}
	public BigDecimal getDisplayPrice() {
		return displayPrice;
	}
	public void setDisplayPrice(BigDecimal displayPrice) {
		this.displayPrice = displayPrice;
	}
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	public BigDecimal getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	  @Override
	   @Transient
	public boolean isNew() {
		  return this.newItemPrice || id == null;
	}
	  public ItemPrice setAsNew(){
	        this.newItemPrice = true;
	        return this;
	    }
    
    
    
	
}
