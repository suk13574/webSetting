package com.devfun.settingweb_boot.dto;

public class LoginUser {
	private String userId;
	private String hrOrgan;
	private String createDate;
	
	//---getter, setter---
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getHrOrgan() {
		return hrOrgan;
	}
	
	public void setHrOrgan(String hrOrgan) {
		this.hrOrgan = hrOrgan;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
