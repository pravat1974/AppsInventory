package com.ps.inventory.model;


import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(value="Category")

@JsonIgnoreProperties({ "new" })
public class Category implements Persistable<Integer> {
	
	@Id
	@Column("id")
	private Integer id;
	
	@Column("creationDate")
	private LocalDateTime creationDate;
	@Column("startDate")
	private LocalDateTime  startDate;
	@Column("endDate")
	private LocalDateTime  endDate;
	@Column("categoryName")
	private String categoryName;
	@Column("displayName")
	private String displayName;
	@Column("description")
	private String description;
	@Column("categoryType")
	private String categoryType;
	@Transient
	private boolean newCategory;
	
	public Category() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		if(creationDate==null) {
			this.creationDate =LocalDateTime.now();
		}
		this.creationDate = creationDate;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		if(startDate==null) {
			this.startDate = LocalDateTime.now();
		}
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
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	

	  public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	   @Transient
	public boolean isNew() {
		  return this.newCategory|| id == null;
	}
	  public Category setAsNew(){
	        this.newCategory = true;
	        return this;
	    }

	@Override
	public String toString() {
		return "Category {id=" + id + ", creationDate=" + creationDate + ", startDate=" + startDate + ", endDate="
				+ endDate + ", categoryName=" + categoryName + ", displayName=" + displayName + ", description="
				+ description + ", categoryType=" + categoryType + ", newCategory=" + newCategory + "}";
	}
	  
	  
}
