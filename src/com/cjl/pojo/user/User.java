package com.cjl.pojo.user;

import java.util.List;

import com.cjl.util.PageUtil;

public class User extends PageUtil{
	
	private String userId;
	
	private String userName;
	
	private String userPhone;
	
	private int userSex;
	
	private int userAge;
	
	private String userIds;
	
	
	private List<String> userIdsList;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getUserSex() {
		return userSex;
	}

	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	public List<String> getUserIdsList() {
		return userIdsList;
	}

	public void setUserIdsList(List<String> userIdsList) {
		this.userIdsList = userIdsList;
	}
	
	

}
