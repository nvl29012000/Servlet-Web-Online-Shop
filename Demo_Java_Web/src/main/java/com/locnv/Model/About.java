package com.locnv.Model;

public class About extends Abstract<About>{
	private long ID;
	private String Name;
	private String Title;
	private String Description;
	private String Image;
	private String MetaKeyword;
	private String MetaDescription;
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
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	
}
