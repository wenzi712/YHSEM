/** 
 * <pre>项目名称:ssm-02 
 * 文件名称:MenuServiceImpl.java 
 * 包名:com.jk.service.menu.impl 
 * 创建日期:2018年7月19日下午9:41:45 
 * Copyright (c) 2018, meng412@gmail.com All Rights Reserved.</pre> 
 */  
package com.yh.service.menu.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.menu.MenuMapper;
import com.yh.pojo.menu.Menu;
import com.yh.service.menu.MenuService;

/** 
 * <pre>项目名称：ssm-02   
 * 类名称：MenuServiceImpl    
 * 类描述：    
 * 创建人：李孟 meng_java@412.com    
 * 创建时间：2018年7月19日 下午9:41:45    
 * 修改人：李孟 meng_java@412.com  
 * 修改时间：2018年7月19日 下午9:41:45    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<Menu> selectTreeList(Menu menu) {
		
		List<Menu> list = menuMapper.selectTreeList(menu);
		if (0 == menu.getPid()) {
			for (Menu m : list) {
				m.setState("closed");
			}
		}
		return list;
	}

	@Override
	public List<Menu> selectTreeList2(Menu menu) {
		
		List<Menu> list = menuMapper.selectTreeList(menu);
		for (Menu m : list) {
			//判断是否父级
			if (0 == m.getPid()) {
				m.setState("closed");
			}
			//获取当前节点的子列表
			m.setPid(m.getId());
			List<Menu> clist = selectTreeList2(m);
			m.setChildren(clist);
		}
		return list;
	}

}
