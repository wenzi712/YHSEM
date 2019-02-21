/** 
 * <pre>项目名称:ssm-02 
 * 文件名称:MenuController.java 
 * 包名:com.jk.controller.menu 
 * 创建日期:2018年7月19日下午9:37:38 
 * Copyright (c) 2018, meng412@gmail.com All Rights Reserved.</pre> 
 */  
package com.cjl.controller.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjl.service.menu.MenuService;
import com.cjl.pojo.menu.Menu;

/** 
 * <pre>项目名称：ssm-02   
 * 类名称：MenuController    
 * 类描述：    
 * 创建人：李孟 meng_java@412.com    
 * 创建时间：2018年7月19日 下午9:37:38    
 * 修改人：李孟 meng_java@412.com  
 * 修改时间：2018年7月19日 下午9:37:38    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("selectTreeList")
	@ResponseBody
	List<Menu> selectTreeList(Menu menu) {
		menu.setPid(menu.getId());
		List<Menu> list = menuService.selectTreeList(menu);
		return list;
	}
	
	@RequestMapping("selectTreeList2")
	@ResponseBody
	List<Menu> selectTreeList2(Menu menu) {
		menu.setPid(menu.getId());
		List<Menu> list = menuService.selectTreeList2(menu);
		return list;
	}

}
