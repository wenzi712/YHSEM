package com.yh.pojo.parameter;

import java.util.Date;

import com.yh.util.PageUtil;

public class Parameter extends PageUtil {
<<<<<<< HEAD
	//台账ID
	private String parameterId;
	//账户类型
	private String accountType;
	//账户名
	private String  accountName;
	//账户密码
	private String accountPwd;
	//账户令牌
	private String token;
	//账户时间
	private Date accountDate;
	//报表ID
	private String reportId;
	//报表ID生成时间
	private Date reportIdDate;
	//报表状态
	private int reportState;
	//报表状态生成时间
	private Date reportStateDate;
	//报表URL路径
	private String reportUrl;
	//报表URL生成时间
	private Date reportUrlDate;
	
	

	public String getParameterId() {
		return parameterId;
	}

	public void setParameterId(String parameterId) {
		this.parameterId = parameterId;
	}
=======
	
	
	
	private String accountType;
	
	private String  accountName;
	
	private Date accountDate;
	
	private String searchType;
	
	private String reportId;
>>>>>>> 884352bcad5fb878e9eff072faf42fbe611fcfc4

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

<<<<<<< HEAD
	

=======
>>>>>>> 884352bcad5fb878e9eff072faf42fbe611fcfc4
	public Date getAccountDate() {
		return accountDate;
	}

	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}

<<<<<<< HEAD

=======
	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
>>>>>>> 884352bcad5fb878e9eff072faf42fbe611fcfc4

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

<<<<<<< HEAD


	public Date getReportIdDate() {
		return reportIdDate;
	}

	public void setReportIdDate(Date reportIdDate) {
		this.reportIdDate = reportIdDate;
	}



	public int getReportState() {
		return reportState;
	}

	public void setReportState(int reportState) {
		this.reportState = reportState;
	}

	public Date getReportStateDate() {
		return reportStateDate;
	}

	public void setReportStateDate(Date reportStateDate) {
		this.reportStateDate = reportStateDate;
	}

	public String getReportUrl() {
		return reportUrl;
	}

	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}

	public Date getReportUrlDate() {
		return reportUrlDate;
	}

	public void setReportUrlDate(Date reportUrlDate) {
		this.reportUrlDate = reportUrlDate;
	}

	public String getAccountPwd() {
		return accountPwd;
	}

	public void setAccountPwd(String accountPwd) {
		this.accountPwd = accountPwd;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

	
=======
>>>>>>> 884352bcad5fb878e9eff072faf42fbe611fcfc4
}
