package com.locnv.Model;

import com.locnv.dao.IProductDAO;
import com.locnv.dao.impl.ProductDAO;
import com.locnv.service.IProductService;
import com.locnv.service.impl.ProductService;

import javax.inject.Inject;
import java.math.BigDecimal;

public class BillDetail {
	private long ID;
	private long ProductID;
	private BigDecimal price;
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

	private IProductDAO productService = new ProductDAO();

	public String getProductName(){
		return productService.findByID(getProductID()).getName();
	}
	public String getProductImage(){
		return productService.findByID(getProductID()).getImage();
	}
	public BigDecimal tongTien(){
		return BigDecimal.valueOf(getQuantity()*getPrice().doubleValue());
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
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
