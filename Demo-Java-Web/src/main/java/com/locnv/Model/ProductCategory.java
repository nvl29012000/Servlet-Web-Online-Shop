package com.locnv.Model;

public class ProductCategory extends Abstract<ProductCategory>{
	private long ID;
	private String Name;
	private String Title;
	private long ParentID;
	private int DisplayOrder;
	private String SeoTitle;
	private String MetaKeyword;
	private String MetaDescription;
	private boolean ShowOnHome;
	private boolean Status;
	private String Image;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public void setName(String name) {
		Name = name;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public long getParentID() {
		return ParentID;
	}
	public void setParentID(long parentID) {
		ParentID = parentID;
	}
	public int getDisplayOrder() {
		return DisplayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		DisplayOrder = displayOrder;
	}
	public String getSeoTitle() {
		return SeoTitle;
	}
	public void setSeoTitle(String seoTitle) {
		SeoTitle = seoTitle;
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
	public boolean isShowOnHome() {
		return ShowOnHome;
	}
	public void setShowOnHome(boolean showOnHome) {
		ShowOnHome = showOnHome;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
}
