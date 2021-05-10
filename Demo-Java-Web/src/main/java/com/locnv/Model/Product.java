package com.locnv.Model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Product extends Abstract<Product>{
	private long ID;
	private String Name;
	private String ProductCode;
	private String Title;
	private String Description;
	private String Image;
	private BigDecimal Price;
	private BigDecimal SalePrice;
	private int Quantity;
	private long CategoryID;
	private String ProductDetail;
	private Timestamp SaleDate;
	private String MetaKeyword;
	private String MetaDescription;
	private int Views;
	private boolean Status;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getProductCode() {
		return ProductCode;
	}
	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public BigDecimal getPrice() {
		return Price;
	}
	public void setPrice(BigDecimal price) {
		Price = price;
	}
	public BigDecimal getSalePrice() {
		return SalePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		SalePrice = salePrice;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public long getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(long categoryID) {
		CategoryID = categoryID;
	}
	public String getProductDetail() {
		return ProductDetail;
	}
	public void setProductDetail(String productDetail) {
		ProductDetail = productDetail;
	}
	public String getMetaKeyword() {
		return MetaKeyword;
	}
	public void setMetaKeyword(String metaKeyword) {
		MetaKeyword = metaKeyword;
	}
	public String getMetaDescription() {
		return MetaDescription;
	}
	public void setMetaDescription(String metaDescription) {
		MetaDescription = metaDescription;
	}
	public int getViews() {
		return Views;
	}
	public void setViews(int views) {
		Views = views;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	public Timestamp getSaleDate() {
		return SaleDate;
	}
	public void setSaleDate(Timestamp saleDate) {
		SaleDate = saleDate;
	}
}
