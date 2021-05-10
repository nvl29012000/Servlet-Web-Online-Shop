package com.locnv.Model;

public class Contact {
	private long ID;
	private String Content;
	private boolean Status;
	private String Facebook;
	private String Youtube;
	private String Gmail;

	public String getFacebook() {
		return Facebook;
	}

	public void setFacebook(String facebook) {
		Facebook = facebook;
	}

	public String getYoutube() {
		return Youtube;
	}

	public void setYoutube(String youtube) {
		Youtube = youtube;
	}

	public String getGmail() {
		return Gmail;
	}

	public void setGmail(String gmail) {
		Gmail = gmail;
	}

	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	
}
