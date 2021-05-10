package com.locnv.Model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Abstract<T> {
	private Timestamp CreatedDate;
	private Timestamp ModifiedDate;
	private String CreatedBy;
	private String ModifiedBy;
	private List<T> ListResult = new ArrayList<>();
	public Timestamp getCreatedDate() {
		return CreatedDate;
	}
	private int page = 1;
	private int items = 3;
	private int total;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCreatedDate(Timestamp createdDate) {
		CreatedDate = createdDate;
	}


	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Timestamp getModifiedDate() {
		return ModifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		ModifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public String getModifiedBy() {
		return ModifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}

	public List<T> getListResult() {
		return ListResult;
	}

	public void setListResult(List<T> listResult) {
		ListResult = listResult;
	}
}
