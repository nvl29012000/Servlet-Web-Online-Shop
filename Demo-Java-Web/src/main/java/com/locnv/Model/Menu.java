package com.locnv.Model;

public class Menu extends Abstract<Menu>{
	private long ID;
	private String Text;
	private String Link;
	private int DisplayOrder;
	private String Target;
	private boolean Status;
	private long MenuTypeID;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public int getDisplayOrder() {
		return DisplayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		DisplayOrder = displayOrder;
	}
	public String getTarget() {
		return Target;
	}
	public void setTarget(String target) {
		Target = target;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	public long getMenuTypeID() {
		return MenuTypeID;
	}
	public void setMenuTypeID(long menuTypeID) {
		MenuTypeID = menuTypeID;
	}
}
