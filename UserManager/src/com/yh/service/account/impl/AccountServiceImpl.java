package com.yh.service.account.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yh.mapper.account.AccountMapper;
import com.yh.pojo.account.Account;
import com.yh.service.account.AccountService;


@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired 
	private AccountMapper accountMapper;

	@Override
	public Map<String, Object> queryUserInfo(Account account) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		//设置分页
		PageHelper.startPage(account.getPage(), account.getRows());
		List<Account> list = accountMapper.queryUserInfo(account);
		Page p = (Page) list;
		long total = p.getTotal();
		map.put("rows", list);
		map.put("total", total);
		return map;
	}

	@Override
	public void insertUserInfo(Account account) {
		// TODO Auto-generated method stub
		accountMapper.insertUserInfo(account);
	}

	@Override
	public Account selectUserByID(Account account) {
		// TODO Auto-generated method stub
		List<Account> list = accountMapper.selectUserByID(account);
		Account u = null;
		if (null != list && 1 == list.size()) {
			u = list.get(0);
		}
		return u;
	}

	@Override
	public void updateUserInfo(Account account) {
		// TODO Auto-generated method stub
		accountMapper.updateUserInfo(account);
	}

	@Override
	public void deleteUser(Account account) {
		// TODO Auto-generated method stub
		
		String userIds = account.getUserIds();
		if (null != userIds && !"".equals(userIds)) {
			String[] split = userIds.split(",");
			List<String> asList = Arrays.asList(split);
			account.setUserIdsList(asList);
			if (account.getAccountStatus() == 0){
				
				accountMapper.deleteUser(account);
			}else if (account.getAccountStatus() == 1){
				
				accountMapper.deleteUser1(account);
			}
		  }
			
		}

	@Override
	public Map<String, Object> queryDisabledlist(Account account) {
		// TODO Auto-generated method stub
				Map<String, Object> map = new HashMap<>();
				//设置分页
				PageHelper.startPage(account.getPage(), account.getRows());
				List<Account> list = accountMapper.queryDisabledlist(account);
				Page p = (Page) list;
				long total = p.getTotal();
				map.put("rows", list);
				map.put("total", total);
				return map;
 }

	@Override
	public List<Account> queryAccountType() {

	
			List<Account> list = accountMapper.queryAccountType();
			Account a = new Account();
			a.setAccountType("请选择");
			list.add(0, a);
			return list;
		
	}

	@Override
	public void updateEnabledInfoFlow(Account account) {
		// TODO Auto-generated method stub
		accountMapper.updateEnabledInfoFlow(account);
	}

}


