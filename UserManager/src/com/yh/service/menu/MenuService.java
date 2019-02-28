/** 
 * <pre>项目名称:ssm-02 
 * 文件名称:MenuService.java 
 * 包名:com.jk.service.menu 
 * 创建日期:2018年7月19日下午9:40:48 
 * Copyright (c) 2018, meng412@gmail.com All Rights Reserved.</pre> 
 */  
package com.yh.service.menu;

import java.util.List;

import com.yh.pojo.menu.Menu;

/** 
 * <pre>项目名称：ssm-02   
 * 类名称：MenuService    
 * 类描述：    
 * 创建人：李孟 meng_java@412.com    
 * 创建时间：2018年7月19日 下午9:40:48    
 * 修改人：李孟 meng_java@412.com  
 * 修改时间：2018年7月19日 下午9:40:48    
 * 修改备注：       
 * @version </pre>    
 */
public interface MenuService {

	/** <pre>selectTreeList(这里用一句话描述这个方法的作用)   
	 * 创建人：李孟 meng_java@412.com     
	 * 创建时间：2018年7月19日 下午9:42:05    
	 * 修改人：李孟 meng_java@412.com      
	 * 修改时间：2018年7月19日 下午9:42:05    
	 * 修改备注： 
	 * @param menu
	 * @return</pre>    
	 */
	List<Menu> selectTreeList(Menu menu);

	/** <pre>selectTreeList2(这里用一句话描述这个方法的作用)   
	 * 创建人：李孟 meng_java@412.com     
	 * 创建时间：2018年7月19日 下午9:45:25    
	 * 修改人：李孟 meng_java@412.com      
	 * 修改时间：2018年7月19日 下午9:45:25    
	 * 修改备注： 
	 * @param menu
	 * @return</pre>    
	 */
	List<Menu> selectTreeList2(Menu menu);

}
