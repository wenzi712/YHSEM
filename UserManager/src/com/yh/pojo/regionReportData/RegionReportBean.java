package com.yh.pojo.regionReportData;

import java.util.Date;

import com.yh.util.PageUtil;

public class RegionReportBean extends PageUtil{
	//账户日期
	private String Data;
	//账户地域ID
	private String accrId;
	//账户
	private String username;
	//报表ID
	private String regionId;
	
	private String region;
	//账户地域ID
	private String cityId;
	//地域城市ID
	private String city;
	//城市展现量
	private int displays;
	//点击量
	private int clicks;
	//消费点击率
	private double cost;
	
	private String cvr;
	//平均点击价格
	private double acp;
	//千次展现
	private double cpm;
	//消费平均排名
	private double vr;

	

	
	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public String getAccrId() {
		return accrId;
	}

	public void setAccrId(String accrId) {
		this.accrId = accrId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}



	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getCvr() {
		return cvr;
	}

	public void setCvr(String cvr) {
		this.cvr = cvr;
	}

	public double getAcp() {
		return acp;
	}

	public void setAcp(double acp) {
		this.acp = acp;
	}

	public double getCpm() {
		return cpm;
	}

	public void setCpm(double cpm) {
		this.cpm = cpm;
	}

	public double getVr() {
		return vr;
	}

	public void setVr(double vr) {
		this.vr = vr;
	}

	public int getDisplays() {
		return displays;
	}

	public void setDisplays(int displays) {
		this.displays = displays;
	}
	
	
}
