
package com.yh.controller.account;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.pojo.account.Account;
import com.yh.service.account.AccountService;

@Controller
@RequestMapping("user")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("list")
	String toListPage() {
		return "user/list";
	}

	public  Map<String, Object> queryUserInfo(Account account) {
		
		Map<String, Object> map = accountService.queryUserInfo(account);
	
		return map;
	}
	@RequestMapping("queryUserInfo")  
	@ResponseBody
	public Map<String, Object> queryAccountInfo(Account account) {
		
		Map<String, Object> map = accountService.queryUserInfo(account);
		
		
		return map;
	}
	
	
	@RequestMapping("queryDisabledlist")
	@ResponseBody
	Map<String, Object> queryDisabledlist(Account account, HttpSession session) {
		
		Map<String, Object> map = accountService.queryDisabledlist(account);
		return map;
	}
	
	@RequestMapping("toUserAdd")
	String toUserAdd() {
		return "user/add";
	}
	
	@RequestMapping("toDisabledList")
	String toDisabledList() {
		return "user/disabledlist";
	}
	
	@RequestMapping("insertUserInfo")
	@ResponseBody
	String insertUserInfo(Account account) {
		accountService.insertUserInfo(account);
		return "{}";
	}
	
	@RequestMapping("toEdit")
	String toEdit(ModelMap mm, Account account) {
		Account b = accountService.selectUserByID(account);
		mm.addAttribute("user", b);
		return "user/edit";
	}

	@RequestMapping("updateUserInfo")
	@ResponseBody
	String updateUserInfo(Account account) {
		accountService.updateUserInfo(account);
		return "{}";
	}
	
	@RequestMapping("deleteUser")
	@ResponseBody
	String deleteUser(Account account) {
		accountService.deleteUser(account);
		return "{}";
	}
	@RequestMapping("queryAccountType")
	@ResponseBody
	List<Account> queryAccountType() {
		
		return  accountService.queryAccountType();
		
	}
	@RequestMapping("updateEnabledInfoFlow")
	@ResponseBody
	String updateEnabledInfoFlow(Account account) {
		accountService.updateEnabledInfoFlow(account);
		return "{}";
	}
	
}
