/** 
 * <pre>项目名称:ssm-02 
 * 文件名称:Menu.java 
 * 包名:com.jk.vo.menu 
 * 创建日期:2018年7月19日下午9:38:59 
 * Copyright (c) 2018, meng412@gmail.com All Rights Reserved.</pre> 
 */  
package com.cjl.pojo.menu;

import java.io.Serializable;
import java.util.List;

/** 
 * <pre>项目名称：ssm-02   
 * 类名称：Menu    
 * 类描述：    
 * 创建人：李孟 meng_java@412.com    
 * 创建时间：2018年7月19日 下午9:38:59    
 * 修改人：李孟 meng_java@412.com  
 * 修改时间：2018年7月19日 下午9:38:59    
 * 修改备注：       
 * @version </pre>    
 */
public class Menu implements Serializable {
	
	private int id;
	private String text;
	private String href;
	private String state;
	private int pid;
	
	private List<Menu> children;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

}
