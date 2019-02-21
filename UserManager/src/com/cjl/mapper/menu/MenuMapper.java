/** 
 * <pre>项目名称:ssm-02 
 * 文件名称:MenuMapper.java 
 * 包名:com.jk.mapper.menu 
 * 创建日期:2018年7月19日下午9:46:37 
 * Copyright (c) 2018, meng412@gmail.com All Rights Reserved.</pre> 
 */  
package com.cjl.mapper.menu;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.cjl.pojo.menu.Menu;

/** 
 * <pre>项目名称：ssm-02   
 * 类名称：MenuMapper    
 * 类描述：    
 * 创建人：李孟 meng_java@412.com    
 * 创建时间：2018年7月19日 下午9:46:37    
 * 修改人：李孟 meng_java@412.com  
 * 修改时间：2018年7月19日 下午9:46:37    
 * 修改备注：       
 * @version </pre>    
 */
public interface MenuMapper {

	/** <pre>selectTreeList(这里用一句话描述这个方法的作用)   
	 * 创建人：李孟 meng_java@412.com     
	 * 创建时间：2018年7月19日 下午9:46:46    
	 * 修改人：李孟 meng_java@412.com      
	 * 修改时间：2018年7月19日 下午9:46:46    
	 * 修改备注： 
	 * @param menu
	 * @return</pre>    
	 */
	@Select("select t_id as id,"
			+ " t_text as text,"
			+ " t_href as href,"
			+ " t_pid as pid"
			+ " from t_menus"
			+ " where t_pid = #{pid}")
	List<Menu> selectTreeList(Menu menu);

}
