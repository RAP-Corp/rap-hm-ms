package com.rap.microservices.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseModel {
	private String insertedBy;
	private long insertedDate;
	private String updatedBy;
	private long updatedDate;
	public String getInsertedBy() {
		return insertedBy;
	}
	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}
	
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public long getInsertedDate() {
		return insertedDate;
	}
	public void setInsertedDate(long insertedDate) {
		this.insertedDate = insertedDate;
	}
	public long getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(long updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
}
