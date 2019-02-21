
package com.cjl.controller.user;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjl.pojo.user.User;
import com.cjl.service.user.UserService;


@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("list")
	String toListPage() {
		return "user/list";
	}
	
	@RequestMapping("queryUserInfo")
	@ResponseBody
	Map<String, Object> queryUserInfo(User user, HttpSession session) {
		
		Map<String, Object> map = userService.queryUserInfo(user);
		return map;
	}
	
	@RequestMapping("toUserAdd")
	String toUserAdd() {
		return "user/add";
	}
	
	@RequestMapping("insertUserInfo")
	@ResponseBody
	String insertUserInfo(User user) {
		userService.insertUserInfo(user);
		return "{}";
	}
	
	@RequestMapping("toEdit")
	String toEdit(ModelMap mm, User user) {
		User b = userService.selectUserByID(user);
		mm.addAttribute("user", b);
		return "user/edit";
	}

	@RequestMapping("updateUserInfo")
	@ResponseBody
	String updateUserInfo(User user) {
		userService.updateUserInfo(user);
		return "{}";
	}
	
	@RequestMapping("deleteUser")
	@ResponseBody
	String deleteUser(User user) {
		userService.deleteUser(user);
		return "{}";
	}
	
	
	
}
