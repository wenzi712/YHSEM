package com.yh.pojo.account;

import java.util.List;

import com.yh.util.PageUtil;

public class Account extends PageUtil{
	
	private String accountId;
	
	private String accountName;
	
	private String accountPwd;
	
	private String token;
	
	private int enabledInfoFlow;
	
	private String accountTypeId;
	
	private String accountType;
	
	private String userIds;
	
	private  int accountStatus;
	
	private List<String> userIdsList;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountPwd() {
		return accountPwd;
	}

	public void setAcccountPwd(String accountPwd) {
		this.accountPwd = accountPwd;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getEnabledInfoFlow() {
		return enabledInfoFlow;
	}

	public void setEnabledInfoFlow(int enabledInfoFlow) {
		this.enabledInfoFlow = enabledInfoFlow;
	}

	public String getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
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

	public int getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}



	

	
	
	

}
