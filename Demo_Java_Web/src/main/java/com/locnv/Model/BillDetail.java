package com.locnv.Model;

public class BillDetail {
	private long ID;
	private long ProductID;
	private long BillID;
	private int Quantity;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public long getProductID() {
		return ProductID;
	}
	public void setProductID(long productID) {
		ProductID = productID;
	}
	public long getBillID() {
		return BillID;
	}
	public void setBillID(long billID) {
		BillID = billID;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
}
